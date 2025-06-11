package org.example.botreminder.dto.updates.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import org.example.botreminder.dto.Chat;
import org.example.botreminder.dto.From;

@Getter
@ToString
public class MessageUpdateDto {
    @SerializedName("message_id")
    private Integer messageId;
    private String text;
    private From from;
    private Chat chat;

    public MessageUpdateDto(Integer messageId) {
        this.messageId = messageId;
    }

}
