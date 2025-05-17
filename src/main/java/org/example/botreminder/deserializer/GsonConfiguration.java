package org.example.botreminder.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.botreminder.dto.updates.UpdateResultDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeHierarchyAdapter(UpdateResultDto.class, new UpdateResultAdapter())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .disableHtmlEscaping()
                .setPrettyPrinting() // Only for development
                .create();
    }
}