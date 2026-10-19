package presentation.html;

import domain.NewsArticle;

import java.util.Objects;

public class NewsPageRenderer {
    private final NewsArticleHtmlRenderer articleRenderer;

    public NewsPageRenderer(NewsArticleHtmlRenderer articleRenderer) {
        this.articleRenderer = articleRenderer;
    }

    public String render(NewsArticle article) {
        Objects.requireNonNull(article, "article must not be null");
        String renderedArticle = articleRenderer.render(article);

        return """
                <!doctype html>
                <html lang="de">
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta charset="UTF-8">
                    <title>%s – The Enchanted Horn Chronicle</title>
                    %s
                </head>
                <body>
                    %s
                    <main id="main-content" class="article-layout container-xxl py-4 py-lg-5">
                        <div class="row g-4 g-xl-5">
                            <aside class="col-xl-2 d-none d-xl-block rail editorial-rail" aria-label="Weitere Artikel">
                                <h2>Weitere Artikel</h2>
                                <p>Empfehlungen aus demselben Ressort folgen in einer kommenden Ausgabe.</p>
                            </aside>
                            <div class="col-12 col-xl-8 article-column">
                                <a class="back-link" href="../index.html">Zurück zur Startseite</a>
                                %s
                            </div>
                            %s
                        </div>
                    </main>
                </body>
                </html>
                """.formatted(
                HtmlEscaper.escapeTextContent(article.headline()),
                NewsSiteChrome.renderStylesheets("../"),
                NewsSiteChrome.renderHeader("../"),
                renderedArticle,
                NewsSiteChrome.renderAdvertisement("Werbung rechts")
        );
    }

}
