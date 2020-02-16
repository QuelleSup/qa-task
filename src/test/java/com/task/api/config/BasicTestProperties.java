package com.task.api.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BasicTestProperties {
    private final String username;
    private final String password;
    private final String basicURL;
}
