package presentation.html;

import domain.NewsArticle;
import domain.PublishedArticle;

import java.util.List;
import java.util.Objects;

public final class HomepageRenderer {

    public String render(List<PublishedArticle> articles) {
        Objects.requireNonNull(articles, "articles must not be null");

        StringBuilder content = new StringBuilder();
        if (!articles.isEmpty()) {
            content.append(renderLeadArticle(Objects.requireNonNull(articles.getFirst())));
            articles.stream()
                    .skip(1)
                    .map(Objects::requireNonNull)
                    .map(this::renderArticleSummary)
                    .forEach(summary -> content.append('\n').append(summary));
        }

        return renderDocument(content.toString());
    }

    private String renderLeadArticle(PublishedArticle publishedArticle) {
        NewsArticle article = publishedArticle.newsArticle();
        StringBuilder html = new StringBuilder();
        html.append("<article class=\"lead-article\" id=\"top-news\">\n");
        appendSummaryHeader(html, publishedArticle, "h1");
        appendOptionalParagraph(html, "lead", article.leadParagraph(), 2);
        html.append("</article>");
        return html.toString();
    }

    private String renderArticleSummary(PublishedArticle publishedArticle) {
        StringBuilder html = new StringBuilder();
        html.append("<article class=\"article-summary\">\n");
        appendSummaryHeader(html, publishedArticle, "h2");
        html.append("</article>");
        return html.toString();
    }

    private void appendSummaryHeader(StringBuilder html, PublishedArticle publishedArticle,
                                     String headingTag) {
        NewsArticle article = publishedArticle.newsArticle();
        html.append("  <header>\n");
        appendParagraph(html, "kicker", article.kicker(), 4);
        appendParagraph(html, "dateline", article.dateline(), 4);
        html.append("    <").append(headingTag).append("><a href=\"articles/")
                .append(publishedArticle.id())
                .append(".html\">")
                .append(HtmlEscaper.escapeTextContent(article.headline()))
                .append("</a></").append(headingTag).append(">\n");
        appendOptionalParagraph(html, "subheadline", article.subheadline(), 4);
        html.append("  </header>\n");
    }

    private void appendOptionalParagraph(StringBuilder html, String className,
                                         String content, int indentation) {
        if (content != null) {
            appendParagraph(html, className, content, indentation);
        }
    }

    private void appendParagraph(StringBuilder html, String className,
                                 String content, int indentation) {
        html.append(" ".repeat(indentation))
                .append("<p class=\"")
                .append(className)
                .append("\">")
                .append(HtmlEscaper.escapeTextContent(content))
                .append("</p>\n");
    }

    private String renderDocument(String content) {
        return """
                <!doctype html>
                <html lang="de" data-bs-theme="dark">
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta charset="UTF-8">
                    <meta name="theme-color" content="#0d1012">
                    <meta name="description" content="Aktuelle Nachrichten aus Einhornland und der magischen Welt.">
                    <title>The Enchanted Horn Chronicle</title>
                    %s
                </head>
                <body>
                    %s
                    <main id="main-content" class="homepage-layout container-xxl py-4 py-lg-5">
                        <div class="row g-4 g-xl-5">
                            %s
                            <section class="col-12 col-xl-8 news-stream" aria-label="Aktuelle Nachrichten">
                                %s
                            </section>
                            %s
                        </div>
                    </main>
                </body>
                </html>
                """.formatted(
                NewsSiteChrome.renderStylesheets(""),
                NewsSiteChrome.renderHeader(""),
                NewsSiteChrome.renderAdvertisement("Werbung links"),
                content,
                NewsSiteChrome.renderAdvertisement("Werbung rechts")
        );
    }
}
