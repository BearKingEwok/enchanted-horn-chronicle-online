package application;

import domain.NewsArticle;
import domain.PublishedArticle;
import persistence.HtmlFileWriter;
import presentation.html.HomepageRenderer;
import presentation.html.NewsArticleHtmlRenderer;
import presentation.html.NewsPageRenderer;
import usecases.GeneratedPage;
import usecases.NewsSiteGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class UnicornNewsApplication {
    static void main(String[] args) throws IOException {
        NewsArticleHtmlRenderer renderer = new NewsArticleHtmlRenderer();
        NewsPageRenderer newsPageRenderer = new NewsPageRenderer(renderer);
        HomepageRenderer homepageRenderer = new HomepageRenderer();
        NewsSiteGenerator newsSiteGenerator = new NewsSiteGenerator(
                homepageRenderer,
                newsPageRenderer
        );
        HtmlFileWriter htmlFileWriter = new HtmlFileWriter();
        NewsArticle article = new NewsArticle(
                "EILMELDUNG",
                "Einhornstadt, 17. Oktober",
                "Drachenrat beschließt autofreien Montag",
                "Fliegende Pendler sind von der Regelung ausgenommen",
                "Nach einer langen Debatte hat der Drachenrat eine Entscheidung getroffen.",
                List.of(
                        "Ab Montag bleiben die Hauptstraßen für Kutschen gesperrt.",
                        "Die Bevölkerung reagierte mit vorsichtigem Optimismus."
                ),
                "Von Ada Federkiel"
        );

        PublishedArticle publishedArticle = new PublishedArticle(
                UUID.fromString("00000000-0000-0000-0000-000000000001"),
                article,
                Instant.parse("2026-10-17T08:00:00Z")
        );
        List<PublishedArticle> articles = List.of(publishedArticle);

        Path directory = Path.of("target/site");
        Files.createDirectories(directory);

        htmlFileWriter.write(
                directory.resolve("index.html"),
                newsSiteGenerator.generateHomepage(articles)
        );
        for (GeneratedPage page : newsSiteGenerator.generateArticlePages(articles)) {
            Path target = directory.resolve(page.relativePath());
            Files.createDirectories(target.getParent());
            htmlFileWriter.write(target, page.html());
        }
    }
}
