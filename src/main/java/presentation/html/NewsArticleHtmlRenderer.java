package presentation.html;

import domain.NewsArticle;

import java.util.Objects;

public final class NewsArticleHtmlRenderer {

    public String render(NewsArticle article) {
        Objects.requireNonNull(article, "article must not be null");

        StringBuilder html = new StringBuilder();
        html.append("<article>\n");
        html.append("  <header>\n");
        appendParagraph(html, "kicker", article.kicker(), 4);
        appendParagraph(html, "dateline", article.dateline(), 4);
        appendElement(html, "h1", null, article.headline(), 4);
        appendOptionalParagraph(html, "subheadline", article.subheadline(), 4);
        html.append("  </header>\n");
        appendOptionalParagraph(html, "lead", article.leadParagraph(), 2);
        html.append("  <div class=\"article-body\">\n");
        for (String paragraph : article.paragraphs()) {
            appendElement(html, "p", null, paragraph, 4);
        }
        html.append("  </div>\n");
        html.append("  <footer>\n");
        appendParagraph(html, "byline", article.byLine(), 4);
        html.append("  </footer>\n");
        html.append("</article>");
        return html.toString();
    }

    private void appendOptionalParagraph(StringBuilder html, String className,
                                         String content, int indentation) {
        if (content != null) {
            appendParagraph(html, className, content, indentation);
        }
    }

    private void appendParagraph(StringBuilder html, String className,
                                 String content, int indentation) {
        appendElement(html, "p", className, content, indentation);
    }

    private void appendElement(StringBuilder html, String tag, String className,
                               String content, int indentation) {
        html.append(" ".repeat(indentation)).append('<').append(tag);
        if (className != null) {
            html.append(" class=\"").append(className).append('"');
        }
        html.append('>')
                .append(escapeTextContent(content))
                .append("</").append(tag).append(">\n");
    }

    private String escapeTextContent(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
