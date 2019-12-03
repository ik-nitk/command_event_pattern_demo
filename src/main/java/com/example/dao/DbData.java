package com.example.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class DbData {
    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private String value;
}
