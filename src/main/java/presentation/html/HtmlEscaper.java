package presentation.html;

final class HtmlEscaper {
    private HtmlEscaper() {
    }

    static String escapeTextContent(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
