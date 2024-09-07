package com.lucas.client.document;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
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
import java.util.ArrayList;
import java.util.List;

public class Doc_Insert {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 插入文档
    @Test
    public void insertDocument() throws IOException {

        User user = new User("zhangsi", "女", 30);

        IndexResponse indexResponse = client.index(builder -> builder
                .index("users").id("1004").document(user));
        System.out.println("Indexed with version " + indexResponse.version());
        
    }

    // 批量插入文档---BulkOperation
    @Test
    public void insertBatchDocument() throws IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhangsan", "男", 30));
        userList.add(new User("lisi", "男", 31));
        userList.add(new User("wangwu", "男", 32));
        userList.add(new User("zhaoliu", "男", 33));

        int num = 1000;
        List<BulkOperation> bulkOperationList = new ArrayList<>();
        for (User user : userList) {
            int id = num;
            bulkOperationList.add(BulkOperation.of(builder -> builder.index(doc -> doc.id(String.valueOf(id)).document(user))));
            num += 1;
        }


        BulkResponse bulkResponse = client.bulk(builder -> builder.index("users").operations(bulkOperationList));
        System.out.println("BulkResponse took: " + bulkResponse.took());
        System.out.println("BulkResponse items: " + bulkResponse.items());
    }
}
