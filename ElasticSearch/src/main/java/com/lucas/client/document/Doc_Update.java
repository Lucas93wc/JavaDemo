package com.lucas.client.document;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import com.lucas.client.config.ClientConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Doc_Update {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 更新文档
    @Test
    public void updateDocument() throws IOException {

        User user = new User();
        user.setSex("女");

        UpdateResponse<User> updateResponse = client.update(builder ->
            builder.index("users").id("1001").doc(user)
        , User.class);
        System.out.println("Indexed with version " + updateResponse.version());


        // 插入数据
//            IndexRequest.of(builder -> builder.document())
//            request.index("user").id("1001");
//            IndexResponse response = client.index(request);


        
    }
}
