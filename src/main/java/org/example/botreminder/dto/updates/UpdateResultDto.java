package org.example.botreminder.dto.updates;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public abstract class UpdateResultDto {
    @SerializedName(value = "update_id")
    private Long updateId;

    public UpdateResultDto(Long updateId) {
        this.updateId = updateId;
    }
}
