package org.example.botreminder.cmdprocessor.commands;

import org.example.botreminder.cmdprocessor.Command;
import org.example.botreminder.dto.send.BotResponseContentDto;
import org.example.botreminder.dto.send.BotResponseMessageDto;
import org.example.botreminder.model.UserResponseEntity;
import org.example.botreminder.service.TgBotService;

import java.util.List;

public class StartCommand extends Command {

    public StartCommand(UserResponseEntity userResponseEntity, TgBotService tgBotService) {
        super(userResponseEntity,tgBotService);
    }

    @Override
    public void execute() {
        super.getTgBotService().saveUserResponse(userResponseEntity);
        BotResponseContentDto responseContent =  BotResponseContentDto
                .builder().text("Получить список сптуников")
                .replyMarkup(BotResponseContentDto.InlineKeyboard.builder()
                        .keyboardRow(
                        List.of(
                                BotResponseContentDto.InlineKeyboardButton
                                .builder()
                                .text("Amateur Sat")
                                .callbackData("AMATEUR_SAT")
                                .build(),
                                BotResponseContentDto.InlineKeyboardButton
                                        .builder()
                                        .text("NOAA")
                                        .callbackData("NOAA_SAT")
                                        .build())
                                )
                        .build()
                ).build();
        var message = new BotResponseMessageDto(userResponseEntity.getChatId(),responseContent);
        super.getTgBotService().sendMessage(message);
    }

}
