package com.example.demo.model.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private String message;
    private Object Data;

    public ResponseMessage(String message) {
        this.message = message;
    }
}


