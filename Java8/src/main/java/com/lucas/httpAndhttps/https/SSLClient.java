package com.lucas.httpAndhttps.https;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-12 14:29
 */
public class SSLClient {
    public static CloseableHttpClient build() throws Exception {
        CustomizeTrustManager customizeTrustManager = new CustomizeTrustManager();
        TrustManager[] trustAllCerts = new TrustManager[1];
        trustAllCerts[0] = customizeTrustManager;

        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, trustAllCerts, null);

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", socketFactory).build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(registry);
        HttpClientBuilder builder = HttpClients.custom().setConnectionManager(manager);
        CloseableHttpClient httpClient = builder.build();
        return httpClient;
    }

    static class CustomizeTrustManager implements TrustManager, X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {

        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {

        }
    }
}
