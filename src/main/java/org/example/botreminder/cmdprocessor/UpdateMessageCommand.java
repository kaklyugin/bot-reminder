package org.example.botreminder.cmdprocessor;

import org.example.botreminder.dto.UserResponse;

public class UpdateMessageCommand extends Command {

    public UpdateMessageCommand(UserResponse userResponse, UserResponseHandler userResponseHandler) {
        super(userResponse, userResponseHandler);
    }

    @Override
    void execute() {
        userResponseHandler.handle(userResponse);
    }
}
