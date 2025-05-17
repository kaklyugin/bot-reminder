package org.example.botreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BotReminderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotReminderApplication.class, args);
    }

}
