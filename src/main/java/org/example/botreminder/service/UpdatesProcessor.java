package org.example.botreminder.service;

import org.example.botreminder.dto.updates.AbstractUpdateResultDto;

public interface UpdatesProcessor {
    void processUpdate(AbstractUpdateResultDto update);
}
