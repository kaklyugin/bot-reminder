package org.example.botreminder.cmdprocessor;

import org.example.botreminder.cmdprocessor.commands.RescheduleCommand;
import org.example.botreminder.cmdprocessor.commands.StartCommand;
import org.example.botreminder.model.UserResponseEntity;
import org.example.botreminder.service.TgBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandDispatcher {

    @Autowired
    private TgBotService tgBotService;

    public void dispatch(UserResponseEntity userResponseEntity) {
        if (userResponseEntity.getText().equals("/start")) {
            new StartCommand(userResponseEntity, tgBotService).execute();
        }
        if (userResponseEntity.getText().equals("/reschedule")) {
            new RescheduleCommand(userResponseEntity, tgBotService).execute();
        }
    }
}
