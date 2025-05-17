package org.example.botreminder.handler;

import lombok.Data;

@Data
public abstract class AbstractCommandHandler {

    private String commandCode;

    public abstract void handle(String userMessage);

}
