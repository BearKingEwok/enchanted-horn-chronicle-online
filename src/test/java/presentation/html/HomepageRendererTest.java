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
    }

    @Test
    void rendersEmptyHomepageForEmptyArticleList() {
        String homepage = renderer.render(List.of());

        assertTrue(homepage.contains("<main>"));
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
