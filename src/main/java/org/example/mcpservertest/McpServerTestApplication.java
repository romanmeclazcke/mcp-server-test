package org.example.mcpservertest;

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
    public ToolCallbackProvider userTool(UserService userService){
        return MethodToolCallbackProvider.builder()
                .toolObjects(userService) // register the userService as tool
                .build();
    }

}
