package org.example.mcpservertest.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductService {

    private WebClient webClient;

    public ProductService(){
        this.webClient = WebClient.builder()
                .baseUrl("https://fakestoreapi.com/products")
                .build();
    }

    @Tool(description = "Get all products on database")
    public String getAllProducts(){
        return this.webClient.get().retrieve().bodyToMono(String.class).block();
    }

}

