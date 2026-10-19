package usecases;

import java.util.Objects;

public record GeneratedPage(String relativePath, String html) {
    public GeneratedPage {
        if (relativePath == null || relativePath.isBlank()) {
            throw new IllegalArgumentException("relativePath must not be null or blank");
        }
        Objects.requireNonNull(html, "html must not be null");
    }
}
