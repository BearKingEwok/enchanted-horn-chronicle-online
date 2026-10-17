package domain;

import java.util.List;

public record NewsArticle(
        String kicker,
        String dateline,
        String headline,
        String subheadline,
        String leadParagraph,
        List<String> paragraphs,
        String byLine
) {
    public NewsArticle {
        if (kicker == null || kicker.isBlank()) {
            throw new IllegalArgumentException("kicker must not be null or blank");
        }
        if (dateline == null || dateline.isBlank()) {
            throw new IllegalArgumentException("dateline must not be null or blank");
        }
        if (headline == null || headline.isBlank()) {
            throw new IllegalArgumentException("headline must not be null or blank");
        }
        if (paragraphs == null || paragraphs.isEmpty() ||
                paragraphs.stream().anyMatch(s -> s == null || s.isBlank())) {
            throw new IllegalArgumentException("paragraphs must not be null, " +
                    "empty or blank");
        }
        paragraphs = List.copyOf(paragraphs);
        if (byLine == null || byLine.isBlank()) {
            throw new IllegalArgumentException("byLine must not be null or blank");
        }
    }
}
