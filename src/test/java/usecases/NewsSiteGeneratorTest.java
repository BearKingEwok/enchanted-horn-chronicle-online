package usecases;

import domain.NewsArticle;
import domain.PublishedArticle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presentation.html.NewsArticleHtmlRenderer;
import presentation.html.NewsPageRenderer;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NewsSiteGeneratorTest {
    private static final String OLDEST_ID = "00000000-0000-0000-0000-000000000001";
    private static final String MIDDLE_ID = "00000000-0000-0000-0000-000000000002";
    private static final String NEWEST_ID = "00000000-0000-0000-0000-000000000003";
    private static final PublishedArticle OLDEST_ARTICLE = publishedArticle(
            OLDEST_ID,
            "2026-10-17T08:00:00Z",
            "oldest"
    );
    private static final PublishedArticle OLDEST_ARTICLE_DUP_ID =
            publishedArticle(
                    OLDEST_ID,
                    "2026-10-17T08:00:00Z",
                    "oldest"
            );
    private static final PublishedArticle MIDDLE_ARTICLE = publishedArticle(
            MIDDLE_ID,
            "2026-10-18T08:00:00Z",
            "middle"
    );
    private static final PublishedArticle NEWEST_ARTICLE = publishedArticle(
            NEWEST_ID,
            "2026-10-19T08:00:00Z",
            "newest"
    );
    private NewsArticleHtmlRenderer renderer;
    private NewsPageRenderer newsPageRenderer;
    private NewsSiteGenerator newsSiteGenerator;

    private static PublishedArticle publishedArticle(String id, String publishedAt, String marker) {
        NewsArticle article = new NewsArticle(
                "Kicker " + marker,
                "Einhornstadt, " + marker,
                "Headline " + marker,
                "Subheadline " + marker,
                "Lead " + marker,
                List.of("First paragraph " + marker, "Second paragraph " + marker),
                "Byline " + marker
        );

        return new PublishedArticle(
                UUID.fromString(id),
                article,
                Instant.parse(publishedAt)
        );
    }

    @BeforeEach
    void setUp() {
        renderer = new NewsArticleHtmlRenderer();
        newsPageRenderer = new NewsPageRenderer(renderer);
        newsSiteGenerator = new NewsSiteGenerator(newsPageRenderer);
    }

    @Test
    void usesNewestPublishedArticleAsLeadArticle() {
        List<PublishedArticle> publishedArticles = List.of(MIDDLE_ARTICLE,
                OLDEST_ARTICLE, NEWEST_ARTICLE);
        String homePage =
                newsSiteGenerator.generateHomepage(publishedArticles);
        assertTrue(
                homePage.lastIndexOf("newest")
                        < homePage.indexOf("middle")
                        && homePage.lastIndexOf("middle") < homePage.indexOf("oldest")
        );
        assertTrue(homePage.contains("Kicker newest"));
        assertTrue(homePage.contains("Einhornstadt, newest"));
        assertTrue(homePage.contains("Headline newest"));
        assertTrue(homePage.contains("Subheadline newest"));
        assertTrue(homePage.contains("Lead newest"));
    }

    @Test
    void ordersRemainingArticlesByPublicationTimeDescending() {
        List<PublishedArticle> publishedArticles = List.of(MIDDLE_ARTICLE,
                OLDEST_ARTICLE, NEWEST_ARTICLE);
        String homePage =
                newsSiteGenerator.generateHomepage(publishedArticles);
        assertTrue(
                homePage.lastIndexOf("newest")
                        < homePage.indexOf("middle")
                        && homePage.lastIndexOf("middle") < homePage.indexOf("oldest")
        );
    }

    @Test
    void rejectsDuplicateArticleIdsBeforeGeneratingAnyPage() {
        List<PublishedArticle> publishedArticles = List.of(MIDDLE_ARTICLE,
                OLDEST_ARTICLE, NEWEST_ARTICLE, OLDEST_ARTICLE_DUP_ID);
        var exception = assertThrows(IllegalArgumentException.class, () ->
                newsSiteGenerator.generateHomepage(publishedArticles)
        );
        assertTrue(exception.getMessage().contains("duplicate") &&
                exception.getMessage().contains("id")
        );
    }

    @Test
    void generatesHomepageWithLinksToEveryArticle() {
        String homePage = newsSiteGenerator.generateHomepage(
                List.of(MIDDLE_ARTICLE, OLDEST_ARTICLE, NEWEST_ARTICLE)
        );

        assertTrue(homePage.contains("href=\"articles/" + OLDEST_ID + ".html\""));
        assertTrue(homePage.contains("href=\"articles/" + MIDDLE_ID + ".html\""));
        assertTrue(homePage.contains("href=\"articles/" + NEWEST_ID + ".html\""));
    }

    @Test
    void generatesOneDetailPageForEachArticle() {
        List<String> articlePages = newsSiteGenerator.generateArticlePages(
                List.of(MIDDLE_ARTICLE, OLDEST_ARTICLE, NEWEST_ARTICLE)
        );

        assertEquals(3, articlePages.size());

        for (String marker : List.of("oldest", "middle", "newest")) {
            long pagesForArticle = articlePages.stream()
                    .filter(page -> page.contains("Headline " + marker))
                    .filter(page -> page.contains("First paragraph " + marker))
                    .filter(page -> page.contains("Second paragraph " + marker))
                    .count();

            assertEquals(1, pagesForArticle);
        }

        assertTrue(articlePages.stream().allMatch(page ->
                Stream.of("oldest", "middle", "newest")
                        .filter(marker -> page.contains("Headline " + marker))
                        .count() == 1
        ));
    }
}
