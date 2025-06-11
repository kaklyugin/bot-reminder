package org.example.botreminder.messageprovider;

import org.example.botreminder.service.UpdatesProcessor;

public interface MessageProvider {
    void pushAndProcessUpdate(UpdatesProcessor updatesProcessor, String update);
}
