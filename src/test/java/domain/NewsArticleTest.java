package domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NewsArticleTest {
    private final String kicker = "kicker";
    private final String dateline = "dateline";
    private final String headline = "headline";
    private final String subheadline = "subheadline";
    private final String leadParagraph = "leadParagraph";
    private final List<String> paragraphs = List.of("bodyParagraph1", "bodyParagraph2", "bodyParagraph3");
    private final String byLine = "byLine";

    public static Stream<Consumer<ArticleBuilder>> provideBlankArgumentsForRequiredFields() {
        return Stream.of(b -> b.kicker = " ", b -> b.dateline = " ", b -> b.headline = " ", b -> b.paragraphs = List.of(" ", " ", ""), b -> b.byLine = " ");
    }

    private static Stream<Consumer<ArticleBuilder>> provideNullArgumentsForRequiredFields() {
        return Stream.of(b -> b.kicker = null, b -> b.dateline = null, b -> b.headline = null, b -> b.paragraphs = null, b -> b.byLine = null);
    }

    private static Stream<Consumer<ArticleBuilder>> provideNullArgumentsForOptionalFields() {
        return Stream.of(b -> b.subheadline = null, b -> b.leadParagraph = null);
    }

    private NewsArticle createNewsArticleWithNullParameterMutations(Consumer<ArticleBuilder> mutator) {
        ArticleBuilder builder = new ArticleBuilder(kicker, dateline, headline, subheadline, leadParagraph, paragraphs, byLine);

        mutator.accept(builder);

        return new NewsArticle(builder.kicker, builder.dateline, builder.headline, builder.subheadline, builder.leadParagraph, builder.paragraphs, builder.byLine);
    }

    @ParameterizedTest
    @MethodSource("provideNullArgumentsForRequiredFields")
    void throwsIllegalArgumentExceptionIfKickerOrDatelineOrHeadlineOrBodyParagraphsOrBylineIsMissing(Consumer<ArticleBuilder> mutator) {

        assertThrows(IllegalArgumentException.class, () -> createNewsArticleWithNullParameterMutations(mutator));
    }

    @ParameterizedTest
    @MethodSource("provideBlankArgumentsForRequiredFields")
    void throwsIllegalArgumentExceptionIfAnyFieldHasBlankValues(Consumer<ArticleBuilder> mutator) {

        var throwable = assertThrows(IllegalArgumentException.class, () -> createNewsArticleWithNullParameterMutations(mutator));

        assertTrue(throwable.getMessage().contains("blank"));
    }

    @Test
    void doesNotChangeParagraphsWhenOriginalListIsModified() {
        var p = Arrays.asList("bodyParagraph1", "bodyParagraph2", "bodyParagraph3");
        var article = createNewsArticle(p);
        var originalP = List.copyOf(p);
        p.set(0, "X");
        assertEquals(originalP, article.paragraphs());
    }

    @Test
    void createsNewsArticleWithExpectedContent() {
        NewsArticle article = createNewsArticle(null);

        assertEquals(kicker, article.kicker());
        assertEquals(dateline, article.dateline());
        assertEquals(headline, article.headline());
        assertEquals(subheadline, article.subheadline());
        assertEquals(leadParagraph, article.leadParagraph());
        assertEquals(byLine, article.byLine());
        assertEquals(paragraphs, article.paragraphs());
    }

    private NewsArticle createNewsArticle(List<String> customParagraphs) {
        return new NewsArticle(kicker, dateline, headline, subheadline, leadParagraph, customParagraphs == null ? paragraphs : customParagraphs, byLine);
    }

    @Test
    void throwsIllegalArgumentExceptionIfBodyParagraphHasAtLeastOneParagraphMissingOrAllParagraphsAreBlank() {
        assertThrows(IllegalArgumentException.class, () -> createNewsArticleWithNullParameterMutations(b -> b.paragraphs = List.of()));

        assertThrows(IllegalArgumentException.class, () -> createNewsArticleWithNullParameterMutations(b -> b.paragraphs = List.of("  ", "   ")));
    }

    @ParameterizedTest
    @MethodSource("provideNullArgumentsForOptionalFields")
    void allowNullValuesForSubheadlineAndLeadParagraph(Consumer<ArticleBuilder> mutator) {
        assertDoesNotThrow(() -> createNewsArticleWithNullParameterMutations(mutator));
    }

    private static class ArticleBuilder {
        String kicker, dateline, headline, subheadline, leadParagraph, byLine;
        List<String> paragraphs;

        ArticleBuilder(String k, String d, String h, String s, String l, List<String> p, String b) {
            this.kicker = k;
            this.dateline = d;
            this.headline = h;
            this.subheadline = s;
            this.leadParagraph = l;
            this.byLine = b;
            this.paragraphs = p;
        }
    }
}