package org.example.botreminder.cmdprocessor;

import org.example.botreminder.cmdprocessor.handlers.MessageUpdateHandler;
import org.example.botreminder.cmdprocessor.handlers.NotificationFrequencyUpdater;
import org.example.botreminder.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class CommandInvoker {
    public void invokeCommand(UserResponse userResponse)
    {
        if (userResponse.getType().equals("message"))
        {
            new UpdateMessageCommand(userResponse,new MessageUpdateHandler()).run();
        }
        if (userResponse.getType().equals("callback"))
        {
            new FrequencyUpdateCommand(userResponse,new NotificationFrequencyUpdater()).run();
        }
    }
}
