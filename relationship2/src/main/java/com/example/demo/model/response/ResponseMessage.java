package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private Object Data;
    private String Message;
    private Integer totalPage;
    public ResponseMessage(String message) {
        Message = message;
    }
}
