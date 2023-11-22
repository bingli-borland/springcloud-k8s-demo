package com.bingli.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author msh01
 * @version 1.0.0
 * @createTime 2023年11月22日 17:38:00
 */
public class Test {

    public static void main(String[] args) throws Exception {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
                -1, TimeUnit.SECONDS);
        // connectionManager.setValidateAfterInactivity(-1);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                // 关闭自动重试
                .disableAutomaticRetries()
                .build();
        doGet(httpClient);

        Thread.sleep(9800);

        doGet(httpClient);
    }

    private static void doGet(CloseableHttpClient httpClient) {
        try (CloseableHttpResponse response = httpClient.execute(new HttpGet("http://localhost:12001/data"))) {

            // 不调用close，不归还连接
            Thread.sleep(1000);
            System.out.println(Arrays.asList(response.getAllHeaders()));
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
