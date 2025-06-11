package org.example.botreminder.cmdprocessor;

import lombok.Data;
import org.example.botreminder.model.UserResponseEntity;
import org.example.botreminder.service.TgBotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public abstract class Command {
    private static final Logger logger = LoggerFactory.getLogger(Command.class);

    protected UserResponseEntity userResponseEntity;
    private TgBotService tgBotService;

    public Command(UserResponseEntity userResponseEntity, TgBotService tgBotService) {
        this.userResponseEntity = userResponseEntity;
        this.tgBotService = tgBotService;
    }

    protected void saveEntity() {
        logger.info("Called saveCommand(). Try to save user response  " + userResponseEntity);
        var result = tgBotService.saveUserResponse(userResponseEntity);
        logger.info("Saving command result = " + result);

    }

    protected abstract void execute();
}
