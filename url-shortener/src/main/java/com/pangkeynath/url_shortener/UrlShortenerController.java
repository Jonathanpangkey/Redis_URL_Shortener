package com.pangkeynath.url_shortener;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    @Autowired
    private UrlShortenerService urlShortenerService;

    // Endpoint to shorten a URL
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@Valid @RequestBody UrlRequest urlRequest) {
        // Call service to shorten the URL
        String shortUrl = urlShortenerService.shortenUrl(urlRequest.getOriginalUrl(), urlRequest.getCustomAlias());
        // Return the shortened URL with HTTP status 201 (Created)
        return new ResponseEntity<>(shortUrl, HttpStatus.CREATED);
    }

    // Endpoint to redirect to the original URL
    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl) {
        // Call service to get the original URL
        String originalUrl = urlShortenerService.getOriginalUrl(shortUrl);
        if (originalUrl != null) {
            // Return HTTP status 302 (Found) with the original URL in the Location header
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", originalUrl)
                    .build();
        } else {
            // Return HTTP status 404 (Not Found) if the short URL does not exist
            return ResponseEntity.notFound().build();
        }
    }
}

