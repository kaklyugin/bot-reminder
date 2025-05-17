package org.example.botreminder.dto.updates.callback;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.example.botreminder.dto.updates.UpdateResultDto;

@Getter
public class CallbackQueryResultDto extends UpdateResultDto {

    @SerializedName("callback_query")
    private final CallbackQueryDto callbackQuery;

    public CallbackQueryResultDto(Long updateId, CallbackQueryDto callbackQuery) {
        super(updateId);
        this.callbackQuery = callbackQuery;
    }
}
