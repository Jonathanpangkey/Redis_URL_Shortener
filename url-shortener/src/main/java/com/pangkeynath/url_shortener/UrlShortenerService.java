package com.pangkeynath.url_shortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UrlShortenerService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // Prefix for Redis keys
    private static final String URL_KEY_PREFIX = "url:";
    // Time-to-live for the shortened URLs in days
    private static final long URL_TTL_DAYS = 30;

    // Method to shorten a URL
    public String shortenUrl(String originalUrl, String customAlias) {
        // Validate the URL format
        if (!isValidUrl(originalUrl)) {
            throw new IllegalArgumentException("Invalid URL format");
        }

        // Generate short URL or use custom alias if provided
        String shortUrl = StringUtils.hasText(customAlias) ? customAlias : generateShortUrl();
        // Check if the short URL alias already exists
        if (redisTemplate.hasKey(URL_KEY_PREFIX + shortUrl)) {
            throw new IllegalArgumentException("Short URL alias already in use");
        }

        // Store the original URL in Redis with an expiration time
        redisTemplate.opsForValue().set(URL_KEY_PREFIX + shortUrl, originalUrl, URL_TTL_DAYS, TimeUnit.DAYS);
        return shortUrl;
    }

    // Method to get the original URL from a shortened URL
    public String getOriginalUrl(String shortUrl) {
        // Retrieve the original URL from Redis
        return redisTemplate.opsForValue().get(URL_KEY_PREFIX + shortUrl);
    }

    // Method to generate a random short URL
    private String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // Method to validate the URL format
    private boolean isValidUrl(String url) {
        return url.matches("^(http|https)://.*$");
    }
}

