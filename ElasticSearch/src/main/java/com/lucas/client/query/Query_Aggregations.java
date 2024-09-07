package com.lucas.client.query;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.HighlightField;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.json.JsonData;
import com.lucas.client.config.ClientConfig;
import com.lucas.client.document.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class Query_Aggregations {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 聚合查询
    @Test
    public void queryByAggregationsQuery() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder.index("users").aggregations("age",
                        aggregationBuilder -> aggregationBuilder.max(maxAggregateBuilder -> maxAggregateBuilder.field("age")))
                , User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 分组查询
    @Test
    public void queryByAggregationsTermsQuery() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder.index("users").aggregations("age",
                        aggregationBuilder -> aggregationBuilder.terms(termsAggregateBuiler -> termsAggregateBuiler.field("age")))
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
