package presentation.html;

import domain.NewsArticle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NewsPageRendererTest {
    private final NewsPageRenderer renderer = new NewsPageRenderer(
            new NewsArticleHtmlRenderer()
    );

    @Test
    void rendersCompleteArticleDetailPageWithBackLink() {
        NewsArticle article = article();

        String renderedPage = renderer.render(article);

        assertEquals("""
                <!doctype html>
                <html lang="de">
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta charset="UTF-8">
                    <title>Drachenrat beschließt autofreien Montag – The Enchanted Horn Chronicle</title>
                </head>
                <body>
                    <nav>
                        <a class="back-link" href="../index.html">Zurück zur Startseite</a>
                    </nav>
                    <main>
                        <article>
                  <header>
                    <p class="kicker">EILMELDUNG</p>
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
                </article>
                    </main>
                </body>
                </html>
                """, renderedPage);
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
