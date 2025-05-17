package org.example.botreminder.cmdprocessor;

import org.example.botreminder.dto.UserResponse;

public interface UserResponseHandler {
    void handle(UserResponse userResponse);
}
