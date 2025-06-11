package org.example.botreminder.dto.updates.callback;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.example.botreminder.dto.Chat;
import org.example.botreminder.dto.From;
import org.example.botreminder.dto.updates.AbstractUpdateResultDto;

@Getter
public class CallbackQueryResultDto extends AbstractUpdateResultDto {

    @SerializedName("callback_query")
    private final CallbackQueryDto callbackQuery;

    public CallbackQueryResultDto(Long updateId, CallbackQueryDto callbackQuery) {
        super(updateId);
        this.callbackQuery = callbackQuery;
    }

    @Override
    public String getUserResponse() {
        return this.getCallbackQuery().getData();
    }

    @Override
    public String getResponseType() {
        return "callback";
    }

    @Override
    public Chat getChat() {
        return callbackQuery.getChat();
    }

    @Override
    public From getForm() {
        return callbackQuery.getFrom();
    }
}
