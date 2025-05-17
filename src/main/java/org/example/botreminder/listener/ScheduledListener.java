package org.example.botreminder.listener;

import org.example.botreminder.cmdprocessor.CommandInvoker;
import org.example.botreminder.deserializer.GsonConfiguration;
import org.example.botreminder.dto.UserResponse;
import org.example.botreminder.dto.updates.TelegramResponseDto;
import org.example.botreminder.scheduler.CustomBotClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
@Configuration
@PropertySource("classpath:tmp_config.properties")
public class ScheduledListener {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledListener.class);

    private final CustomBotClient customBotClient;
    private final GsonConfiguration gsonConfiguration;
    private final CommandInvoker commandInvoker;

    public ScheduledListener(CustomBotClient customBotClient,
                             GsonConfiguration gson,
                             CommandInvoker commandInvoker, CommandInvoker commandInvoker1) {
        this.customBotClient = customBotClient;
        this.gsonConfiguration = gson;
        this.commandInvoker = commandInvoker1;
    }

    @Async
    @Scheduled(cron = "*/1 * * * * *")
    public void getUpdatesBySchedule() {
        logger.info("Launched getUpdates scheduled task");
        var updatesJson = customBotClient.getUpdates();
        var updates = gsonConfiguration.gson().fromJson(updatesJson, TelegramResponseDto.class);
        logger.info("Deserialized json with updates = " + updates.toString());
        updates.getResult().forEach(
                update -> {
                    commandInvoker.invokeCommand(
                            new UserResponse(update.getResponseType(),
                                    update.getUserResponse()));
                }
        );

    }
}
