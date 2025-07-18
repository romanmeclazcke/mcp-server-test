package org.example.mcpservertest;

import org.example.mcpservertest.service.ProductService;
import org.example.mcpservertest.service.UserService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerTestApplication.class, args);
    }


    @Bean
    public ToolCallbackProvider userTool(UserService userService,ProductService productService){
        return MethodToolCallbackProvider.builder()
                .toolObjects(userService, productService) // register the userService as tool
                .build();
    }

}
