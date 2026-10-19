package presentation.html;

import domain.NewsArticle;
import domain.PublishedArticle;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomepageRendererTest {
    private static final UUID LEAD_ID = UUID.fromString(
            "00000000-0000-0000-0000-000000000001"
    );
    private static final UUID SUMMARY_ID = UUID.fromString(
            "00000000-0000-0000-0000-000000000002"
    );

    private final HomepageRenderer renderer = new HomepageRenderer();

    @Test
    void rendersLeadWithLeadParagraphAndRemainingArticleAsSummary() {
        PublishedArticle lead = article(LEAD_ID, "lead");
        PublishedArticle summary = article(SUMMARY_ID, "summary");

        String homepage = renderer.render(List.of(lead, summary));

        assertTrue(homepage.contains("class=\"lead-article\""));
        assertTrue(homepage.contains("<h1><a href=\"articles/" + LEAD_ID));
        assertTrue(homepage.contains("Lead lead"));
        assertTrue(homepage.contains("href=\"articles/" + LEAD_ID + ".html\""));
        assertTrue(homepage.contains("class=\"article-summary\""));
        assertTrue(homepage.contains("<h2><a href=\"articles/" + SUMMARY_ID));
        assertTrue(homepage.contains("href=\"articles/" + SUMMARY_ID + ".html\""));
        assertFalse(homepage.contains("Lead summary"));
        assertFalse(homepage.contains("First paragraph lead"));
        assertFalse(homepage.contains("First paragraph summary"));
        assertTrue(homepage.contains("bootstrap@5.3.8/dist/css/bootstrap.min.css"));
        assertTrue(homepage.contains("<link rel=\"stylesheet\" href=\"styles.css\">"));
        assertTrue(homepage.contains("aria-label=\"The Enchanted Horn Chronicle – Startseite\""));
        assertTrue(homepage.contains("<main id=\"main-content\" class=\"homepage-layout container-xxl"));
        assertTrue(homepage.contains("aria-label=\"Werbung links\""));
        assertTrue(homepage.contains("aria-label=\"Werbung rechts\""));
    }

    @Test
    void rendersEmptyHomepageForEmptyArticleList() {
        String homepage = renderer.render(List.of());

        assertTrue(homepage.contains("<main id=\"main-content\""));
        assertFalse(homepage.contains("<article"));
    }

    private PublishedArticle article(UUID id, String marker) {
        return new PublishedArticle(
                id,
                new NewsArticle(
                        "Kicker " + marker,
                        "Dateline " + marker,
                        "Headline " + marker,
                        "Subheadline " + marker,
                        "Lead " + marker,
                        List.of("First paragraph " + marker),
                        "Byline " + marker
                ),
                Instant.parse("2026-10-19T08:00:00Z")
        );
    }
}
