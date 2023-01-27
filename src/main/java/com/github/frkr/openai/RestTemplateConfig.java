package com.github.frkr.openai;

import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public final class RestTemplateConfig {

    private RestTemplateConfig() {
    }

    // TODO configuravel
    private static Integer timeout       = Math.toIntExact(TimeUnit.MINUTES.toMillis(2));
    private static String  timeoutHeader = "120";

    public static HttpHeaders defaultHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        header.setCacheControl(CacheControl.noCache());
        header.setAccessControlMaxAge(0);
        header.setExpires(0);
        header.setConnection("close");
        header.set("Keep-Alive", "timeout=" + timeoutHeader);
        return header;
    }

    public static RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
                super.prepareConnection(connection, httpMethod);
                connection.setReadTimeout(timeout);
                connection.setConnectTimeout(timeout);
                connection.setInstanceFollowRedirects(true);
            }
        };
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
        return new RestTemplate(factory);
    }

    public static <I, O> ResponseEntity<O> request(RestTemplate rest, HttpMethod method, String url, I input, Class<O> output) {
        return request(rest, defaultHeader(), method, url, input, output);
    }

    public static <I, O> ResponseEntity<O> request(RestTemplate rest, HttpHeaders header, HttpMethod method, String url, I input, Class<O> output) {
        HttpEntity<I> request = new HttpEntity<>(input, header);
        return rest.exchange(url, method, request, output);
    }
}
