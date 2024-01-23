package com.lucas.client;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
import java.net.URI;

public class ClientTest {
    /**
     * elasticsearch url.
     * 集群使用英文逗号隔开
     */
//    @Autowired
//    private ElasticsearchProperties elasticsearchProperties;

    @Bean
    @Lazy
    public ElasticsearchClient client(@Autowired(required = false) JsonpMapper jsonpMapper, @Autowired(required = false) ObjectMapper objectMapper) {
        String[] uris = new String[]{"http://localhost:9200"};

        // 解析hostlist配置信息
        // 创建HttpHost数组，其中存放es主机和端口的配置信息
        HttpHost[] httpHostArray = new HttpHost[uris.length];


        for (int i = 0; i < uris.length; i++) {
            String item = uris[i];

            URI uri = URI.create(item);
            httpHostArray[i] = new HttpHost(uri.getHost(),
                    uri.getPort(), uri.getScheme());
        }


//        RequestConfig.Builder requesrBuilder = RequestConfig.custom()
//                .setConnectTimeout(Long.valueOf(elasticsearchProperties.getConnectionTimeout().toMillis()).intValue())
//                .setSocketTimeout(Long.valueOf(elasticsearchProperties.getSocketTimeout().toMillis()).intValue());
//        RequestConfig requestConfig = requesrBuilder.build();

        RestClientBuilder builder = RestClient.builder(httpHostArray);

        //
//        SSLFactory sslFactory = SSLFactory.builder()
//                .withUnsafeTrustMaterial()
//                .withUnsafeHostnameVerifier()
//                .build();

        // Create the low-level client
        // 添加认证
//        if (elasticsearchProperties.getUsername() != null) {
//            final CredentialsProvider provider = new BasicCredentialsProvider();
//            provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(elasticsearchProperties.getUsername(), elasticsearchProperties.getPassword()));
//
//            builder.setHttpClientConfigCallback(f ->
//                    f.setDefaultCredentialsProvider(provider)
//                            .setSSLContext(sslFactory.getSslContext())
//                            .setDefaultRequestConfig(requestConfig)
//            );
//        }

//        if (elasticsearchProperties.getPathPrefix() != null) {
//            builder.setPathPrefix(elasticsearchProperties.getPathPrefix());
//        }


        RestClient restClient = builder.build();

        ElasticsearchTransport transport = null;
        if (jsonpMapper != null) {
            transport = new RestClientTransport(restClient, jsonpMapper);
        } else if (objectMapper != null) {
            transport = new RestClientTransport(restClient, new JacksonJsonpMapper(objectMapper));
        } else {
            transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        }
        // Create the transport with a Jackson mapper


        // And create the API client
        return new ElasticsearchClient(transport);
    }


    public static void main(String[] args) {
        // 创建低级客户端
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
        // 使用Jackson映射器创建传输层
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper()
        );
        // 创建API客户端
        ElasticsearchClient client = new ElasticsearchClient(transport);


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
