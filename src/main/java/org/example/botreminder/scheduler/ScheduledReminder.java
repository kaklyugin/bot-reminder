package org.example.botreminder.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
@Configuration
@PropertySource("classpath:tmp_config.properties")
public class ScheduledReminder {

    private final CustomBotClient botMessageHttpSender;
    private final String message;

    public ScheduledReminder(CustomBotClient botMessageHttpSender,
                             @Value("${tmp.message}") String message) {
        this.botMessageHttpSender = botMessageHttpSender;
        this.message = message;
    }

    @Async
    @Scheduled(cron = "0 0 8-20 * * *")
    public void scheduleFixedRateTaskAsync() {
        botMessageHttpSender.sendMessage(message);
    }
}
