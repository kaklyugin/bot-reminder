package org.example.botreminder.service;

import org.example.botreminder.cmdprocessor.CommandDispatcher;
import org.example.botreminder.dto.send.BotResponseMessageDto;
import org.example.botreminder.dto.updates.AbstractUpdateResultDto;
import org.example.botreminder.model.UserResponseEntity;
import org.example.botreminder.repository.UserUpdatesRepository;
import org.example.botreminder.service.botclient.HttpBotClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:tmp_config.properties")
public class TgBotService implements UpdatesProcessor {

    private final UserUpdatesRepository repository;
    private final HttpBotClient httpBotClient;
    private final CommandDispatcher commandDispatcher;


    public TgBotService(UserUpdatesRepository repository, HttpBotClient httpBotClient, CommandDispatcher commandDispatcher) {
        this.repository = repository;
        this.httpBotClient = httpBotClient;
        this.commandDispatcher = commandDispatcher;
    }

    public UserResponseEntity saveUserResponse(UserResponseEntity userResponseEntity) {
        return repository.save(userResponseEntity);
    }

    public boolean sendMessage(BotResponseMessageDto message) {
        return httpBotClient.sendMessage(message);
    }

    public void processUpdate(AbstractUpdateResultDto update) {
        commandDispatcher.dispatch(
                UserResponseEntity
                        .builder()
                        .type(update.getResponseType())
                        .text(update.getUserResponse())
                        .chatId(update.getChat().getId())
                        .updateId(update.getUpdateId())
                        .userId(update.getForm().getId())
                        .build()
        );
    }
}


