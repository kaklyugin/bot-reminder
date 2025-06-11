package org.example.botreminder.dto.updates.callback;

import lombok.Getter;
import lombok.ToString;
import org.example.botreminder.dto.Chat;
import org.example.botreminder.dto.From;

@Getter
@ToString
public class CallbackQueryDto {
    private String id;
    private String data;
    private From from;
    private Chat chat;
}
