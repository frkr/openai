package com.github.frkr.openai;

import com.openai.api.OpenAIRequest;
import com.openai.api.OpenAIResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class OpenAITeste {
    private static RestTemplate rest    = RestTemplateConfig.restTemplate();
    private static String       api_key = "";
    private static String       url     = "https://api.openai.com/v1/completions";

    public static void main(String[] args) {
        try {
            args = "Como ler XML em cobol?".split(" ");
            HttpHeaders header = RestTemplateConfig.defaultHeader();
            header.setBearerAuth(api_key);

            OpenAIRequest chat = new OpenAIRequest(
                    "text-davinci-003",
                    String.join(" ", args),
                    0L,
                    400L,
                    1L,
                    0.2,
                    0L
            );

            String resultado = RestTemplateConfig.request(rest, header, HttpMethod.POST, url, chat, OpenAIResponse.class)
                    .getBody().getChoices().get(0).getText();

            System.out.println();
            System.out.println(String.join(" ", args));
            System.out.println();

            System.out.println(resultado);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
