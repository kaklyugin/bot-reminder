package org.example.botreminder.cmdprocessor.commands;

import org.example.botreminder.cmdprocessor.Command;
import org.example.botreminder.model.UserResponseEntity;
import org.example.botreminder.service.TgBotService;

public class RescheduleCommand extends Command {

    public RescheduleCommand(UserResponseEntity userResponseEntity, TgBotService tgBotService) {
        super(userResponseEntity, tgBotService);
    }

    @Override
    public void execute() {

    }
}
