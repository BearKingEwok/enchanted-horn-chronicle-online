package usecases;

import domain.NewsArticle;
import domain.PublishedArticle;
import presentation.html.NewsPageRenderer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewsSiteGenerator {
    private final NewsPageRenderer newsPageRenderer;

    public NewsSiteGenerator(NewsPageRenderer newsPageRenderer) {
        this.newsPageRenderer = newsPageRenderer;
    }

    private boolean publishedArticlesHaveDuplicateIds(List<PublishedArticle> publishedArticles) {
        return publishedArticles.stream()
                .map(PublishedArticle::id)
                .collect(Collectors.toSet()).size()
                !=
                publishedArticles.size();
    }

    public String generateHomepage(List<PublishedArticle> publishedArticles) {
        if (publishedArticlesHaveDuplicateIds(publishedArticles)) {
            throw new IllegalArgumentException("duplicated article ids");
        }
        List<NewsArticle> newsArticles = publishedArticles.stream()
                .sorted(
                        Comparator.comparing(
                                PublishedArticle::publishedAt
                        ).reversed()
                )
                .map(PublishedArticle::newsArticle)
                .toList();
        return newsPageRenderer.render(newsArticles);
    }

    public List<String> generateArticlePages(List<PublishedArticle> publishedArticles) {
        if (publishedArticlesHaveDuplicateIds(publishedArticles)) {
            throw new IllegalArgumentException("duplicated article ids");
        }
        return publishedArticles.stream()
                .map(PublishedArticle::newsArticle)
                .map(List::of).map(newsPageRenderer::render)
                .toList();
    }
}
