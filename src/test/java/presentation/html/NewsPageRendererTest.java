package presentation.html;

import domain.NewsArticle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NewsPageRendererTest {
    private final NewsPageRenderer renderer = new NewsPageRenderer(
            new NewsArticleHtmlRenderer()
    );

    @Test
    void rendersCompleteArticleDetailPageWithBackLink() {
        NewsArticle article = article();

        String renderedPage = renderer.render(article);

        assertTrue(renderedPage.contains("<title>Drachenrat beschließt autofreien Montag – The Enchanted Horn Chronicle</title>"));
        assertTrue(renderedPage.contains("bootstrap@5.3.8/dist/css/bootstrap.min.css"));
        assertTrue(renderedPage.contains("<html lang=\"de\" data-bs-theme=\"dark\">"));
        assertTrue(renderedPage.contains("<link rel=\"stylesheet\" href=\"../styles.css\">"));
        assertTrue(renderedPage.contains("<main id=\"main-content\" class=\"article-layout container-xxl"));
        assertTrue(renderedPage.contains("<a class=\"back-link\" href=\"../index.html\">Zurück zur Startseite</a>"));
        assertTrue(renderedPage.contains("<h1>Drachenrat beschließt autofreien Montag</h1>"));
        assertTrue(renderedPage.contains("<p class=\"lead\">Nach einer langen Debatte hat der Drachenrat eine Entscheidung getroffen.</p>"));
        assertTrue(renderedPage.contains("<p>Ab Montag bleiben die Hauptstraßen für Kutschen gesperrt.</p>"));
        assertTrue(renderedPage.contains("<p class=\"byline\">Von Ada Federkiel</p>"));
        assertTrue(renderedPage.contains("aria-label=\"Weitere Artikel\""));
        assertTrue(renderedPage.contains("aria-label=\"Werbung rechts\""));
    }

    @Test
    void rejectsNullArticle() {
        assertThrows(NullPointerException.class, () -> renderer.render(null));
    }

    private NewsArticle article() {
        return new NewsArticle(
                "EILMELDUNG",
                "Einhornstadt, 17. Oktober",
                "Drachenrat beschließt autofreien Montag",
                "Fliegende Pendler sind von der Regelung ausgenommen",
                "Nach einer langen Debatte hat der Drachenrat eine Entscheidung getroffen.",
                List.of(
                        "Ab Montag bleiben die Hauptstraßen für Kutschen gesperrt.",
                        "Die Bevölkerung reagierte mit vorsichtigem Optimismus."
                ),
                "Von Ada Federkiel"
        );
    }
}
