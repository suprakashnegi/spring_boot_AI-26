package com.example.Ai.Controller;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
// @Slf4j
public class AiResponse {

    private final ChatClient chatClient;

    // private final static Logger log = LoggerFactory.getLogger(AiResponse.class);

    public AiResponse(@Qualifier("chatCliet") ChatClient builder) {
        this.chatClient = builder;
    }

    @GetMapping("/response")
    public ResponseEntity<@Nullable String> getResponse(
            @RequestParam(value = "prompt",
                    defaultValue = "What do you do?")
            String prompt) {

        var response = chatClient.prompt()
                //  .system("You are a helpful AI assistant. Always reply in plain natural language text only. Do not return JSON, markdown, code blocks, or structured objects.")
                .advisors(new SimpleLoggerAdvisor(),new SafeGuardAdvisor(List.of("king")))
                .user(user -> user.text(prompt))
                .call()
                .content();

            // Integer tokenCount = response.getMetadata().getUsage().getTotalTokens();
            // log.info("Token count: {}", tokenCount);   
            return ResponseEntity.ok(response);
            // String responseText = response.getResult().getOutput().getText();
        // return ResponseEntity.ok(new AiResponseDto(responseText));
    }
}

