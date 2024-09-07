package com.lucas.client.query;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.json.JsonData;
import com.lucas.client.config.ClientConfig;
import com.lucas.client.document.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Query_matchAll_term_boolQuery {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 全量查询
    @Test
    public void matchAllQuery() throws IOException {

        SearchResponse<User> response = client.search(builder ->
                builder.index("users").
                        query(queryBuilder -> queryBuilder.matchAll(queryAllBuilder -> queryAllBuilder)), User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());


        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 条件查询
    @Test
    public void queryByCondition() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder.index("users").query(
                        queryBuilder -> queryBuilder.term(termQuery -> termQuery.field("age").value(30))), User.class);

        HitsMetadata<User> hits = response.hits();
        System.out.println(hits.total().value());
        System.out.println(hits.hits().size());
        System.out.println(response.took());

        for (Hit<User> hit : hits.hits()) {
            System.out.println(hit.source());
        }
    }

    // 组合查询
    @Test
    public void queryByBoolQuery() throws IOException {

        SearchResponse<User> response = client.search(
                builder -> builder.index("users").query(
                        queryBuilder -> queryBuilder.bool(
                                boolQuery -> boolQuery
                                        //.must(query -> query.term(termQuery -> termQuery.field("age").value(30)))
                                        //.must(query -> query.term(termQuery -> termQuery.field("sex").value("男")))
                                        //.mustNot(query -> query.term(termQuery -> termQuery.field("sex").value("男")))
                                        //.should(query -> query.term(termQuery -> termQuery.field("age").value(30)))
                                        //.should(query -> query.term(termQuery -> termQuery.field("age").value(31)))
                                        .must(query -> query.match(matchQuery -> matchQuery.field("age").query(30)))
                                        .must(query -> query.match(matchQuery -> matchQuery.field("sex").query("男")))
                        )

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
