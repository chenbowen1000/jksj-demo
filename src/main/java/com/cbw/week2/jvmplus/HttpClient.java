package com.cbw.week2.jvmplus;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenbowen
 * @date 2021/8/17 1:29
 */
public class HttpClient {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8082);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void service(Socket socket){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://localhost:8082");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                System.out.println("success");
            }

            response.close();
            httpClient.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
