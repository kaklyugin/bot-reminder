package org.example.botreminder.dto.updates.message;

import lombok.Getter;
import org.example.botreminder.dto.Chat;
import org.example.botreminder.dto.From;
import org.example.botreminder.dto.updates.AbstractUpdateResultDto;

@Getter
public class MessageUpdateResultDto extends AbstractUpdateResultDto {

    private final MessageUpdateDto message;

    public MessageUpdateResultDto(Long updateId, MessageUpdateDto message) {
        super(updateId);
        this.message = message;
    }

    @Override
    public String getUserResponse() {
        return this.message.getText();
    }

    @Override
    public String getResponseType() {
        return "message";
    }

    @Override
    public Chat getChat() {
        return message.getChat();
    }

    @Override
    public From getForm() {
        return message.getFrom();
    }
}
