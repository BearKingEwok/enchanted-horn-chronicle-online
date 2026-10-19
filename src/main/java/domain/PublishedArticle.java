package domain;

import java.time.Instant;
import java.util.UUID;

public record PublishedArticle(
        UUID id,
        NewsArticle newsArticle,
        Instant publishedAt
) {
    public PublishedArticle {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (newsArticle == null) {
            throw new IllegalArgumentException("newsArticle cannot be null");
        }
        if (publishedAt == null) {
            throw new IllegalArgumentException("publishedAt cannot be null");
        }
    }
}
