package com.lucas.client.index;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.*;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.util.ObjectBuilder;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.function.Function;

@SpringBootTest
public class Index_Search {

    @Autowired
    private ElasticsearchClient client;

    @Test
    public void getIndex() throws IOException {
        GetIndexResponse response = client.indices().get(i -> i.index("shopping"));
        System.out.println(response);
    }

    // 查询索引 - 使用 Lambda 表达式
    @Test
    public void queryIndexByLambda() throws IOException {

        // 查询索引
        GetIndexRequest request = GetIndexRequest.of(builder -> builder.index("shopping"));

        // 获取索引响应对象
        GetIndexResponse getIndexResponse = client.indices().get(request);

        System.out.println(getIndexResponse.get("shopping").aliases());

        getIndexResponse.get("shopping").mappings().properties().forEach((key, value) -> {
            System.out.println(key+" : "+ value.toString());
            System.out.println(value._kind());
        });

        System.out.println(getIndexResponse.get("shopping").settings().index().routing());
    }
}
