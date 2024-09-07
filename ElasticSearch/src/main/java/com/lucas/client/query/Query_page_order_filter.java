package com.lucas.client.query;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.elasticsearch.core.search.SourceConfigBuilders;
import co.elastic.clients.elasticsearch.core.search.SourceFilter;
import com.lucas.client.config.ClientConfig;
import com.lucas.client.document.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Query_page_order_filter {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 分页查询
    @Test
    public void queryByPage() throws IOException {

        SearchResponse<User> response = client.search(
            builder -> builder
                    .index("users")
                    .query(queryBuilder -> queryBuilder.matchAll(MatchAllQuery.of(allQuerybuilder -> allQuerybuilder)))
//                    .from(0)
                    .from(3)
                    .size(3), User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 排序查询
    @Test
    public void queryByOrder() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder
                        .index("users")
                        .query(queryBuilder -> queryBuilder.matchAll(MatchAllQuery.of(allQuerybuilder -> allQuerybuilder)))
                        .sort(sortOptions -> sortOptions.field(fieldSort -> fieldSort.field("age").order(SortOrder.Desc))), User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 过滤查询
    @Test
    public void queryByFilter() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder
                        .index("users")
                        .query(queryBuilder -> queryBuilder.matchAll(MatchAllQuery.of(allQuerybuilder -> allQuerybuilder)))
                        //.source(sourceConfigBuilders -> sourceConfigBuilders.filter(sourceFilter -> sourceFilter.includes("name", "age")))
                        .source(sourceConfigBuilders -> sourceConfigBuilders.filter(sourceFilter -> sourceFilter.excludes("sex")))
                , User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }
}
