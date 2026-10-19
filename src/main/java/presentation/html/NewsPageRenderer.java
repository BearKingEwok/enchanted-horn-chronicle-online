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
                </head>
                <body>
                    <nav>
                        <a class="back-link" href="../index.html">Zurück zur Startseite</a>
                    </nav>
                    <main>
                        %s
                    </main>
                </body>
                </html>
                """.formatted(
                HtmlEscaper.escapeTextContent(article.headline()),
                renderedArticle
        );
    }

}
