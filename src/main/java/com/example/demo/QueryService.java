package com.example.demo;

import com.example.dao.DbData;
import com.example.dao.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class QueryService {

    private final DbMapper mapper;

    @Autowired
    public QueryService(final DbMapper mapper) {
        this.mapper = mapper;
    }

    @Async
    @EventListener
    public void handleMessage(final DbData data) {
        mapper.setValue(data.getKey(), data.getValue());
    }

    public Collection<String> query(final String key) {
        return mapper.getValue(key);
    }
}
