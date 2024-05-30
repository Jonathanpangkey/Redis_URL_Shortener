package com.pangkeynath.url_shortener;
import jakarta.validation.constraints.NotBlank;

public class UrlRequest {

    // Original URL to be shortened
    @NotBlank(message = "Original URL is mandatory")
    private String originalUrl;

    // Optional custom alias for the short URL
    private String customAlias;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public void setCustomAlias(String customAlias) {
        this.customAlias = customAlias;
    }
}
