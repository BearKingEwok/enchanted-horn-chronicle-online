package presentation.html;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NewsSiteStylesheetTest {

    private final NewsSiteStylesheet stylesheet = new NewsSiteStylesheet();

    @Test
    void rendersEditorialStylesForDesktopAndSmallScreens() {
        String css = stylesheet.render();

        assertTrue(css.contains(".site-header"));
        assertTrue(css.contains(".article-column"));
        assertTrue(css.contains(".lead-article"));
        assertTrue(css.contains("@media (max-width: 640px)"));
    }
}
