package com.task.api.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Comment {

    private String body;
    private String email;
    private long id;
    private String name;
    private long postId;

}
