package com.example.Ai.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@Data
@NoArgsConstructor
public class AiResponseDto {
    private String title;
    private String response;
}
