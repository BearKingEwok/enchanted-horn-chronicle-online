package application;

import domain.NewsArticle;
import domain.PublishedArticle;
import persistence.HtmlFileWriter;
import persistence.NewsArticleData;
import presentation.html.HomepageRenderer;
import presentation.html.NewsArticleHtmlRenderer;
import presentation.html.NewsPageRenderer;
import presentation.html.NewsSiteStylesheet;
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
        List<NewsArticle> articles = new NewsArticleData().getAusgabe1386();
        List<PublishedArticle> publishedArticles = articles.stream()
                .map(
                        newsArticle ->
                                new PublishedArticle(
                                        UUID.randomUUID(),
                                        newsArticle,
                                        Instant.now()
                                )
                )
                .toList();

        Path directory = Path.of("target/site");
        Files.createDirectories(directory);

        htmlFileWriter.write(
                directory.resolve("index.html"),
                newsSiteGenerator.generateHomepage(publishedArticles)
        );
        htmlFileWriter.write(
                directory.resolve("styles.css"),
                new NewsSiteStylesheet().render()
        );
        for (GeneratedPage page : newsSiteGenerator.generateArticlePages(publishedArticles)) {
            Path target = directory.resolve(page.relativePath());
            Files.createDirectories(target.getParent());
            htmlFileWriter.write(target, page.html());
        }
    }
}
