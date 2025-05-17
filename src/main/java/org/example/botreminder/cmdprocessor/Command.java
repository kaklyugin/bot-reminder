package org.example.botreminder.cmdprocessor;

import lombok.Data;
import org.example.botreminder.dto.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public abstract class Command {
    private static final Logger logger = LoggerFactory.getLogger(Command.class);

    protected UserResponse userResponse;
    protected UserResponseHandler userResponseHandler;

    public Command(UserResponse userResponse, UserResponseHandler userResponseHandler) {
        this.userResponse = userResponse;
        this.userResponseHandler = userResponseHandler;
    }

    protected void saveCommand() {
        logger.info("Saving command: " + userResponse);
    }
    protected void updateLastMessageId() {
        logger.info("Updated last message id: " + userResponse);
    }
    protected void run()
    {
        saveCommand();
        updateLastMessageId();
        execute();
    }
    abstract void execute();
}
