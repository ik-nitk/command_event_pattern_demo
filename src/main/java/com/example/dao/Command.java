package com.example.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Command {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String params;
}
