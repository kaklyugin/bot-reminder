package org.example.botreminder.dto.updates.callback;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CallbackQueryDto {

    private String id;

    public CallbackQueryDto(String id) {
        this.id = id;
    }
}
