package org.example.botreminder.dto.send;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageSendDto {

    @SerializedName(value = "chat_id")
    private String chatId;
    private String text;

    public MessageSendDto(String chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

}
