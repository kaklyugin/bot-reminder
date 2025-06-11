package org.example.botreminder.dto.send;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
public class BotResponseMessageDto extends BotResponseContentDto {

    @SerializedName(value = "chat_id")
    private String chatId;

    public BotResponseMessageDto(String chatId, BotResponseContentDto content) {
        super(content.toBuilder());
        this.chatId = chatId;
    }

}
