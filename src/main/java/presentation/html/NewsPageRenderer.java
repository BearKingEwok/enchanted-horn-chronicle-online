package presentation.html;

import domain.NewsArticle;

import java.util.List;
import java.util.Objects;

public class NewsPageRenderer {
    private final NewsArticleHtmlRenderer articleRenderer;

    public NewsPageRenderer(NewsArticleHtmlRenderer articleRenderer) {
        this.articleRenderer = articleRenderer;
    }

    public String render(List<NewsArticle> articles) {
        Objects.requireNonNull(articles);
        String joinedArticles;

        if (articles.isEmpty()) {
            joinedArticles = "";
        } else {
            joinedArticles = articles.stream()
                    .map(articleRenderer::render)
                    .reduce((a1, a2) -> a1 + "\n" + a2)
                    .orElse("");
        }

        return """
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
                """.formatted(joinedArticles);
    }

}
