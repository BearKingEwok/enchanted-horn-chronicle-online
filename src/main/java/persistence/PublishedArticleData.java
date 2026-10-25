package persistence;

import domain.NewsArticle;
import domain.PublishedArticle;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class PublishedArticleData {
    private final NewsArticleData newsArticleData;

    public PublishedArticleData(NewsArticleData newsArticleData) {
        this.newsArticleData = newsArticleData;
    }

    public List<PublishedArticle> getPublished1386() {
        Instant instant = Instant.ofEpochSecond(1792368000L);
        List<UUID> uuids = List.of(
                UUID.fromString("aa38b5f3-a28e-44fb-ba9a-6a4711b60baa"),
                UUID.fromString("071a9734-ff2b-4d96-b0ca-1104c21ccd00"),
                UUID.fromString("5116a1a1-99be-4271-b43c-ab9a00d98919"),
                UUID.fromString("7688928c-e17c-4cbb-874c-4b0ebc7fef24"),
                UUID.fromString("442b043c-0ce7-4405-a409-9f587bd79d3e"),
                UUID.fromString("c6c29eaa-647d-4d94-bb01-801e239851fe"),
                UUID.fromString("5e870fac-106c-469a-9eec-7054bbc5178d"),
                UUID.fromString("70da77db-b09c-48f8-a300-647d7d2cf5a6"),
                UUID.fromString("4ce19b00-0bee-4766-bd98-f43b37603a2f"),
                UUID.fromString("3a3b4ae0-4b23-4bea-8b78-127b60721ba3")
        );
        List<NewsArticle> articles = newsArticleData.getAusgabe1386();
        List<PublishedArticle> publishedArticles = IntStream.range(0,
                        uuids.size())
                .mapToObj(i -> new PublishedArticle(
                                uuids.get(i),
                                articles.get(i),
                                instant
                        )
                ).toList();
        return publishedArticles;
    }
}
