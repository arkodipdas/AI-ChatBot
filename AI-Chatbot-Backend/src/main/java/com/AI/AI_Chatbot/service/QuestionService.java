package com.AI.AI_Chatbot.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class QuestionService {

    @Value("${gemini.api.url}")
    private String geminiURL;
    @Value("${gemini.api.key}")
    private String geminiAPI;

    private final WebClient webClient;

    public QuestionService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }


    public String getAnswer(String question)
    {
        //Constructing the request payload
        Map<String,Object> request=Map.of("contents",new Object[]{
                Map.of("parts",new Object[]{
                        Map.of("text",question)})
        });
        //Making the API call
        String response = webClient.post()
                .uri(geminiURL+geminiAPI).header("Content-Type","application/json")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //Returning the response
        return response;
    }
}
