package com.lucas.client.document;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.util.ObjectBuilder;
import com.lucas.client.config.ClientConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Doc_Get {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 插入文档
    @Test
    public void getDocument() throws IOException {

        GetResponse<User> response = client.get(
                builder -> builder.index("users").id("1001")
        , User.class);

        System.out.println("document source " + response.source().toString());
        
    }
}
