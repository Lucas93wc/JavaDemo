package com.lucas.client.index;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexRequest;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.lucas.client.config.ClientConfig;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Index_Delete {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexResponse response = client.indices().delete(d -> d.index("product1"));
        boolean acknowledged = response.acknowledged();
        System.out.println(acknowledged);
    }

    // 删除索引 - 使用 Lambda 表达式
    @Test
    public void deleteIndexByLambda() throws IOException {
        // 删除索引
        DeleteIndexRequest request = DeleteIndexRequest.of(builder -> builder.index("user"));

        // 获取索引响应对象
        DeleteIndexResponse response = client.indices().delete(request);

        // 响应状态
        System.out.println(response.acknowledged());

    }
}
