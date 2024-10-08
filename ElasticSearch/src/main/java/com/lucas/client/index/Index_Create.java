package com.lucas.client.index;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.ElasticsearchIndicesClient;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.util.ObjectBuilder;
import com.lucas.client.config.ClientConfig;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.function.Function;

public class Index_Create {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 如果索引不存在则创建索引 - 使用构建器
    @Test
    public void createIndexIfNotExist() throws IOException {
        // 获取索引客户端对象
        ElasticsearchIndicesClient indices = client.indices();
        String indexName = "product2";

        // 1、构建【存在请求对象】
        ExistsRequest existsRequest = new ExistsRequest.Builder().index(indexName).build();
        // 2、判断目标索引是否存在
        boolean flag = indices.exists(existsRequest).value();
        if (flag) {
            System.out.println("索引【" + indexName + "】已存在！");
        } else {
            // 1. 获取【创建索引请求对象】
            CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName).build();
            // 2. 创建索引，得到【创建索引响应对象】
            CreateIndexResponse createIndexResponse = indices.create(createIndexRequest);
            boolean result = createIndexResponse.acknowledged();
            if (result) {
                System.out.println("索引【" + indexName + "】创建成功！");
            } else {
                System.out.println("索引【" + indexName + "】创建失败！");
            }
        }
    }

    // 如果索引不存在则创建索引 - 使用 Lambda 表达式
    @Test
    public void createIndexIfNotExistByLambda() throws IOException {
        // 获取索引客户端对象
        ElasticsearchIndicesClient indices = client.indices();
        String indexName = "product1";
        boolean flag = indices.exists(req -> req.index(indexName)).value();

        boolean flag1 = indices.exists(new Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>>() {
            @Override
            public ObjectBuilder<ExistsRequest> apply(ExistsRequest.Builder builder) {
                ExistsRequest.Builder index = builder.index(indexName);
                ExistsRequest build = index.build();
                return index;
            }
        }).value();

        BooleanResponse response = client.indices().exists(e -> e.index("product1"));
        boolean flag2 = response.value();

        if (flag) {
            System.out.println("索引【" + indexName + "】已存在！");
        } else {
            boolean result = false;
            result = indices.create(req -> req.index(indexName)).acknowledged();
            if (result) {
                System.out.println("索引【" + indexName + "】创建成功！");
            } else {
                System.out.println("索引【" + indexName + "】创建失败！");
            }
        }
    }

    // 使用 Lambda 表达式创建索引
    @Test
    public void createIndexByLambda() throws IOException {
        // 创建索引
        CreateIndexResponse resp = client.indices().create(q -> q.index("user"));
        // 响应状态
        boolean acknowledged = resp.acknowledged();
        System.out.println("索引结果: "+ acknowledged);
    }
}
