package com.task.api.data;

import lombok.Data;

@Data
public class Post {

    private String body;
    private long id;
    private String title;
    private long userId;

}
