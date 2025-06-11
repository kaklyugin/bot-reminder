package org.example.botreminder.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.example.botreminder.deserializer.GsonConfiguration;
import org.example.botreminder.dto.updates.TelegramResponseAsJsonStringsDto;
import org.example.botreminder.dto.updates.TelegramResponseDto;
import org.example.botreminder.service.botclient.HttpBotClient;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableAsync
@Configuration
@PropertySource("classpath:bot.properties")
public class UpdatesListener {

    private final HttpBotClient httpBotClient;
    private final GsonConfiguration gsonConfiguration;

    public UpdatesListener(HttpBotClient httpBotClient, GsonConfiguration gsonConfiguration) {
        this.httpBotClient = httpBotClient;
        this.gsonConfiguration = gsonConfiguration;
    }

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void getUpdatesBySchedule() {

        log.info("Launched getUpdates scheduled task");
        var updatesJson = httpBotClient.getUpdates();
        var updates = gsonConfiguration.gson().fromJson(updatesJson, TelegramResponseAsJsonStringsDto.class);
        log.info("Deserialized json with updates =  {}", updates.toString());
        if (!updates.isOk())
            throw new RuntimeException("No updates found." + updatesJson);

//        if (!updates.getResult().isEmpty()) {
//            updates.getResult().forEach(
//
//            );
//        }

    //}
}

}
