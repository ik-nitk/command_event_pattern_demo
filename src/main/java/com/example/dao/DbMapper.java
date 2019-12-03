package com.example.dao;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
public class DbMapper {
    static final ListMultimap<String, String> STORE = MultimapBuilder.treeKeys().arrayListValues().build();

    public Collection<String> getValue(final String key) {
        return STORE.get(key);
    }

    public void setValue(final String key, final String value) {
        STORE.put(key, value);
    }
}
