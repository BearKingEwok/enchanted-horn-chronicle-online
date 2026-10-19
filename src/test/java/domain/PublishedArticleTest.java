package domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PublishedArticleTest {
    private static final UUID ID = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final Instant PUBLISHED_AT =
            Instant.parse("2026-10-02T07:30:32Z");
    private static final NewsArticle NEWS_ARTICLE = new NewsArticle(
            "kicker",
            "dateline",
            "headline",
            "subheadline",
            "leadParagraph",
            List.of("paragraph1", "paragraph2", "paragraph3"),
            "byLine"
    );

    @Test
    void preservesAssignedIdPublicationTimeAndArticle() {
        var publishedArticle = new PublishedArticle(ID, NEWS_ARTICLE, PUBLISHED_AT);
        assertEquals(ID, publishedArticle.id());
        assertEquals(NEWS_ARTICLE, publishedArticle.newsArticle());
        assertEquals(PUBLISHED_AT, publishedArticle.publishedAt());
    }

    @Test
    void rejectsNullId() {
        assertThrows(IllegalArgumentException.class, () ->
                new PublishedArticle(null, NEWS_ARTICLE, PUBLISHED_AT)
        );
    }

    @Test
    void rejectsNullPublicationTime() {
        assertThrows(IllegalArgumentException.class, () ->
                new PublishedArticle(ID, NEWS_ARTICLE, null)
        );
    }

    @Test
    void rejectsNullArticle() {
        assertThrows(IllegalArgumentException.class, () ->
                new PublishedArticle(ID, null, PUBLISHED_AT)
        );
    }
}
