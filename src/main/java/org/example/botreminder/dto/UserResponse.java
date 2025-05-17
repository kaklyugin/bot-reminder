package org.example.botreminder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public class UserResponse {
    private String type;
    private String text;
}
