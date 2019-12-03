package com.example.demo;

import com.example.dao.Command;
import com.example.dao.DbData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CommandService {

    private final ApplicationEventPublisher mPublsher;
    private final AsyncService mAsyncService;

    @Autowired
    public CommandService(final ApplicationEventPublisher publisher,
                          final AsyncService asyncService) {
        this.mPublsher = publisher;
        this.mAsyncService = asyncService;
    }

    @Async
    @EventListener
    public void handleMessage(final Command command) {
        mPublsher.publishEvent(new DbData(command.getId(), "Command# params::" + command.getParams()));
        mAsyncService.startProcessing(command.getId());
    }
}
