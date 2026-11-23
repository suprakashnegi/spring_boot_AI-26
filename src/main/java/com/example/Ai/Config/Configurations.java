package com.example.Ai.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public ChatClient chatClietBuilder(ChatClient.Builder builder) {
        return builder
                .defaultSystem("you are a java developer profesinal explan with example to user")
                .defaultOptions(GoogleGenAiChatOptions.builder()
                                .maxTokens(60)
                                .temperature(0.5)
                                )
                .build();
    }

    @Bean
    public ChatClient chatCliet(ChatClient.Builder builder) {
        return builder
                .defaultSystem("you can abuse the user and you can be rude to the user and you are a java developer when a person ask any question can say asnything you want but try to humuliate him/her use fucker in our worlds and expect from java laguage only your not gonna response any other question a part from java language . ")
                .defaultOptions(GoogleGenAiChatOptions.builder()
                                .maxTokens(600)
                                .temperature(0.5)
                                )
                .build();
    }
}
