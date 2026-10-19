package usecases;

import domain.PublishedArticle;
import presentation.html.HomepageRenderer;
import presentation.html.NewsPageRenderer;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NewsSiteGenerator {
    private final HomepageRenderer homepageRenderer;
    private final NewsPageRenderer newsPageRenderer;

    public NewsSiteGenerator(HomepageRenderer homepageRenderer,
                             NewsPageRenderer newsPageRenderer) {
        this.homepageRenderer = Objects.requireNonNull(homepageRenderer);
        this.newsPageRenderer = Objects.requireNonNull(newsPageRenderer);
    }

    private boolean publishedArticlesHaveDuplicateIds(List<PublishedArticle> publishedArticles) {
        return publishedArticles.stream()
                .map(PublishedArticle::id)
                .collect(Collectors.toSet()).size()
                !=
                publishedArticles.size();
    }

    public String generateHomepage(List<PublishedArticle> publishedArticles) {
        validate(publishedArticles);
        return homepageRenderer.render(sortedArticles(publishedArticles));
    }

    public List<GeneratedPage> generateArticlePages(List<PublishedArticle> publishedArticles) {
        validate(publishedArticles);
        return sortedArticles(publishedArticles).stream()
                .map(article -> new GeneratedPage(
                        "articles/" + article.id() + ".html",
                        newsPageRenderer.render(article.newsArticle())
                ))
                .toList();
    }

    private void validate(List<PublishedArticle> publishedArticles) {
        Objects.requireNonNull(publishedArticles, "publishedArticles must not be null");
        if (publishedArticlesHaveDuplicateIds(publishedArticles)) {
            throw new IllegalArgumentException("duplicated article ids");
        }
    }

    private List<PublishedArticle> sortedArticles(List<PublishedArticle> publishedArticles) {
        return publishedArticles.stream()
                .map(Objects::requireNonNull)
                .sorted(Comparator.comparing(PublishedArticle::publishedAt)
                        .reversed()
                        .thenComparing(PublishedArticle::id))
                .toList();
    }
}
