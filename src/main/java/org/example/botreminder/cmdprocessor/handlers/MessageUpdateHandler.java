package org.example.botreminder.cmdprocessor.handlers;

import org.example.botreminder.cmdprocessor.UserResponseHandler;
import org.example.botreminder.dto.UserResponse;

public class MessageUpdateHandler implements UserResponseHandler {

    @Override
    public void handle(UserResponse userResponse) {
        System.out.println("Write to db new text = " + userResponse.getText());
    }
}