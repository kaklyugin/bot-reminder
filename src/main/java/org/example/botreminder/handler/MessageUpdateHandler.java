package org.example.botreminder.handler;

import java.util.logging.Logger;

public class MessageUpdateHandler extends AbstractCommandHandler {

    Logger logger = Logger.getLogger(MessageUpdateHandler.class.getName());

    @Override
    public void handle(String userMessage) {
        logger.info("Trying to handle user message = " + userMessage);
    }
}
