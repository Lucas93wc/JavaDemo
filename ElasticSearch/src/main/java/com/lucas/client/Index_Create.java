package com.lucas.client;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

public class Index_Create {
    private static HttpHost httpHost = new HttpHost("localhost", 9200, "http");

    public static void main(String[] args) {
        try {
            createIndexByLambda();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 如果索引不存在则创建索引 - 使用 Lambda 表达式
    public static void createIndexIfNotExistByLambda() throws IOException {

        try (
            // 创建低级客户端
            RestClient restClient = RestClient.builder(httpHost).build();
            // 使用Jackson映射器创建传输层
            ElasticsearchTransport transport = new RestClientTransport(
                     restClient, new JacksonJsonpMapper()
            )
        ) {
            // 创建API客户端
            ElasticsearchClient client = new ElasticsearchClient(transport);

            // 创建索引
            CreateIndexResponse resp = client.indices().create(q -> q.index("users"));

            // 响应状态
            boolean acknowledged = resp.acknowledged();
            System.out.println("索引结果: " + acknowledged);
        }
    }

    // 使用 Lambda 表达式创建索引
    public static void createIndexByLambda() throws IOException {
        // 创建低级客户端
        RestClient restClient = RestClient.builder(httpHost).build();
        // 使用Jackson映射器创建传输层
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper()
        );
        // 创建API客户端
        ElasticsearchClient client = new ElasticsearchClient(transport);

        // 创建索引
        CreateIndexResponse resp = client.indices().create(q -> q.index("users"));
        // 响应状态
        boolean acknowledged = resp.acknowledged();
        System.out.println("索引结果: "+ acknowledged);


        // 关闭客户端
        try {
            transport.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
