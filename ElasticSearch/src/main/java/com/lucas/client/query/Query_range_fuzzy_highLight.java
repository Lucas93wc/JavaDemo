package com.lucas.client.query;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
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

public class Query_range_fuzzy_highLight {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 范围查询
    @Test
    public void queryByRangeQuery() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder.index("users").query(
                        queryBuilder -> queryBuilder.range(
                                rangeQuery -> rangeQuery
                                        .field("age")
                                        .gte(JsonData.of(30))
                                        .lte(JsonData.of(31)))

                )
                , User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 模糊查询
    @Test
    public void queryByFuzzyQuery() throws IOException {
        SearchResponse<User> response = client.search(
                builder -> builder.index("users").query(
                        queryBuilder -> queryBuilder.fuzzy(fuzzyQuery ->
                                fuzzyQuery.field("name").value(fieldValue -> fieldValue.stringValue("zhangsa")).fuzziness("2"))

                )
                , User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 高亮查询
    @Test
    public void queryByHighLightQuery() throws IOException {
        SearchResponse<User> response = client.search(
                builder -> builder
                            .index("users")
                            .query(
                                queryBuilder -> queryBuilder.terms(
                                        termsQuery -> termsQuery.field("name").terms(
                                                termsQueryField -> termsQueryField.value(Arrays.asList(FieldValue.of("zhangsan")))))
                            )
                            .highlight(
                                    highLight -> highLight.fields("name", HighlightField.of(
                                            highLightField -> highLightField
                                                                .preTags("<font color='red'>")
                                                                .postTags("</font>")))
                            )
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
