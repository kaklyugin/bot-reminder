package org.example.botreminder.messageprovider;

import com.google.gson.Gson;
import org.example.botreminder.dto.tgresponse.SendStatusDto;
import org.example.botreminder.model.RawUpdateEntity;
import org.example.botreminder.repository.RawUpdatesRepository;
import org.example.botreminder.service.UpdatesProcessor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class InMemoryMessageProvider implements MessageProvider {

    private final RawUpdatesRepository rawUpdatesRepository;
    private final HashSet<Long> sentUpdateIds = new HashSet<>();
    private final UpdatesProcessor updatesProcessor;
    private final Gson gson;

    public InMemoryMessageProvider(RawUpdatesRepository rawUpdatesRepository, UpdatesProcessor updatesProcessor, Gson gson) {
        this.rawUpdatesRepository = rawUpdatesRepository;
        this.updatesProcessor = updatesProcessor;
        this.gson = gson;
    }

    @Override
    public void pushAndProcessUpdate(UpdatesProcessor updatesProcessor, String update) {
        //TODO Доработать репозиторий, чтобы дважды не сохранять апдейты. Возможно, использовать InMemoryCache
        rawUpdatesRepository.save(RawUpdateEntity.builder().rawJson(update).build());
        var result = gson.fromJson(update, SendStatusDto.class);
        if (!sentUpdateIds.contains(update.getId)) {
            updatesProcessor.processUpdate(update);
            sentUpdateIds.add(update.getUpdateId());
        }
    }
}
