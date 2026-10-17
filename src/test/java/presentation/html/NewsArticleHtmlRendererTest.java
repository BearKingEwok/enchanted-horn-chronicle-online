package presentation.html;

import domain.NewsArticle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NewsArticleHtmlRendererTest {

    private final NewsArticleHtmlRenderer renderer = new NewsArticleHtmlRenderer();

    @Test
    void rendersCompleteArticleAsHtmlFragment() {
        NewsArticle article = new NewsArticle(
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

        String html = renderer.render(article);

        assertEquals("""
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
                </article>""", html);
    }

    @Test
    void omitsOptionalElementsWhenTheirContentIsMissing() {
        NewsArticle article = new NewsArticle(
                "MÄRCHENWELT",
                "Einhornstadt, 17. Oktober",
                "Brücke wegen Trollversammlung gesperrt",
                null,
                null,
                List.of("Reisende werden gebeten, den Zauberwald zu umfliegen."),
                "Von Ada Federkiel"
        );

        String html = renderer.render(article);

        assertFalse(html.contains("class=\"subheadline\""));
        assertFalse(html.contains("class=\"lead\""));
    }

    @Test
    void escapesArticleTextBeforeEmbeddingItInHtml() {
        NewsArticle article = new NewsArticle(
                "Magie & Technik",
                "Wald <Nord>",
                "1 < 2 & 3 > 2",
                null,
                null,
                List.of("<script>alert('spell')</script>"),
                "Von A. & B."
        );

        String html = renderer.render(article);

        assertEquals("""
                <article>
                  <header>
                    <p class="kicker">Magie &amp; Technik</p>
                    <p class="dateline">Wald &lt;Nord&gt;</p>
                    <h1>1 &lt; 2 &amp; 3 &gt; 2</h1>
                  </header>
                  <div class="article-body">
                    <p>&lt;script&gt;alert('spell')&lt;/script&gt;</p>
                  </div>
                  <footer>
                    <p class="byline">Von A. &amp; B.</p>
                  </footer>
                </article>""", html);
    }
}
