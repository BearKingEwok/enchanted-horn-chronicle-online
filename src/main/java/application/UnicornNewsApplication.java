package application;

import domain.NewsArticle;
import persistence.HtmlFileWriter;
import presentation.html.NewsArticleHtmlRenderer;
import presentation.html.NewsPageRenderer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UnicornNewsApplication {
    static void main(String[] args) throws IOException {
        NewsArticleHtmlRenderer renderer = new NewsArticleHtmlRenderer();
        NewsPageRenderer newsPageRenderer = new NewsPageRenderer(renderer);
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

        String htmlPage = newsPageRenderer.render(List.of(article));
        Path directory = Path.of("target/site");
        Files.createDirectories(directory);

        htmlFileWriter.write(directory.resolve("index.html"), htmlPage);
    }
}
