package org.example.botreminder.dto.updates;


import lombok.Getter;

import java.util.List;

@Getter
public class TelegramResponseDto {

    private boolean ok;
    private List<UpdateResultDto> result;

    public TelegramResponseDto() {
    }
}
