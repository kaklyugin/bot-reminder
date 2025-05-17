package org.example.botreminder.cmdprocessor;

import org.example.botreminder.dto.UserResponse;

public class FrequencyUpdateCommand extends Command {

    public FrequencyUpdateCommand(UserResponse userResponse, UserResponseHandler userResponseHandler) {
        super(userResponse, userResponseHandler);
    }

    @Override
    void execute() {
        userResponseHandler.handle(userResponse);
    }
}
