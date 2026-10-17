package presentation.html;

import domain.NewsArticle;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NewsPageRendererTest {
    private final NewsArticleHtmlRenderer newsArticleRenderer = new NewsArticleHtmlRenderer();
    private final NewsPageRenderer newsPageRenderer = new NewsPageRenderer(newsArticleRenderer);

    private final Function<Integer, String> renderedArticle = """
            <article>
              <header>
                <p class="kicker">EILMELDUNG: %d</p>
                <p class="dateline">Einhornstadt, 17. Oktober</p>
                <h1>Drachenrat beschließt autofreien Montag</h1>
                <p class="subheadline">Fliegende Pendler sind von der Regelung ausgenommen</p>
              </header>
              <p class="lead">Nach einer langen Debatte hat der Drachenrat eine Entscheidung getroffen.</p>
              <div class="article-body">
                <p>Ab Montag bleiben die Hauptstraßen für Kutschen gesperrt.</p>
                <p>Die Bevölkerung reagierte mit vorsichtigem Optimismus.</p>
              </div>
              <footer>
                <p class="byline">Von Ada Federkiel</p>
              </footer>
            </article>"""::formatted;

    private NewsArticle createNewsArticle(int id) {
        return new NewsArticle(
                "EILMELDUNG: %d".formatted(id),
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

    @Test
    void shouldRenderNewsPageIfArticlesEmpty() {
        String expectedPage = """
                <!doctype html>
                <html lang="de">
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta charset="UTF-8">
                    <title>The Enchanted Horn Chronicle</title>
                </head>
                <body>
                    <main>
                
                    </main>
                </body>
                </html>
                """;

        String renderedPageEmpty = newsPageRenderer.render(List.of());
        assertEquals(expectedPage.replaceAll("\\s+", ""),
                renderedPageEmpty.replaceAll("\\s+", ""));
    }

    @Test
    void throwsNPEIfArticlesNull() {
        assertThrows(NullPointerException.class, () -> newsPageRenderer.render(null));
    }

    @Test
    void shouldRenderNewsPage() {
        String renderedPage =
                newsPageRenderer.render(List.of(createNewsArticle(1),
                        createNewsArticle(2)));

        String expectedPage = """
                <!doctype html>
                <html lang="de">
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta charset="UTF-8">
                    <title>The Enchanted Horn Chronicle</title>
                </head>
                <body>
                    <main>
                        %s
                    </main>
                </body>
                </html>
                """.formatted(renderedArticle.apply(1) + "\n" + renderedArticle.apply(2));

        assertEquals(expectedPage, renderedPage);
    }
}