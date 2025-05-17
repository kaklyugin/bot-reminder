package org.example.botreminder.dto.updates.message;

import lombok.Getter;
import org.example.botreminder.dto.updates.UpdateResultDto;

@Getter
public class MessageResultDto extends UpdateResultDto {

    private final MessageDto message;

    public MessageResultDto(Long updateId, MessageDto message) {
        super(updateId);
        this.message = message;
    }
}
