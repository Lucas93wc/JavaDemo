package com.lucas.client.document;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import com.lucas.client.config.ClientConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Doc_Delete {
    private ElasticsearchClient client = new ClientConfig().elasticsearchClient();

    // 删除文档
    @Test
    public void deleteDocument() throws IOException {

        DeleteResponse response = client.delete(builder -> builder.index("users").id("1001"));

        System.out.println("DeleteResponse: " + response.toString());
        
    }

    // 批量删除文档
    @Test
    public void deleteBatchDocument() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("1000");
        list.add("1001");
        list.add("1002");
        list.add("1003");

        List<BulkOperation> bulkOperationList = new ArrayList<>();
        for (String id : list) {
            bulkOperationList.add(BulkOperation.of(builder -> builder.delete(doc -> doc.id(id))));
        }

        BulkResponse bulkResponse = client.bulk(builder -> builder.index("users").operations(bulkOperationList));
        System.out.println("BulkResponse took: " + bulkResponse.took());
        System.out.println("BulkResponse items: " + bulkResponse.items());
    }
}
