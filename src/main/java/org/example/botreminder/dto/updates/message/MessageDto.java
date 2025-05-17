package org.example.botreminder.dto.updates.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MessageDto {
    @SerializedName("message_id")
    private Integer messageId;

    private String text;

    public MessageDto(Integer messageId) {
        this.messageId = messageId;
    }

}
