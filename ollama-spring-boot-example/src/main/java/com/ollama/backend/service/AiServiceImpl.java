package com.ollama.backend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService{

    private ChatClient client;

    public AiServiceImpl(ChatClient.Builder builder){
        this.client = builder.build();
    }

    @Override
    public String askAi(String question) {
        return client.prompt(question).call().content();
    }
}
