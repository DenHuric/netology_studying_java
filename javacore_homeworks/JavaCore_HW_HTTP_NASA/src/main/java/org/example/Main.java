package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=UxzgMf8lzvOs7hhdK5xgnqakVjy8KUhyi1Rwmfqy");
        CloseableHttpResponse response = httpClient.execute(request);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<NasaContent> nasaContents = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<NasaContent>>() {
        });

        NasaContent urlImage = nasaContents.get(0);

        HttpGet request2 = new HttpGet(String.valueOf(urlImage.getUrl()));
        response = httpClient.execute(request2);
        String[] fileName = String.valueOf(urlImage.getUrl()).split("/");
        String name = fileName[fileName.length - 1];

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(name).getName()));
        response.getEntity().writeTo(bos);

    }
}