package com.task.api.scenarios;

import com.task.api.data.Comment;
import com.task.api.data.Post;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static com.task.TestProperties.getProperty;
import static com.task.api.constants.Endpoints.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonPlaceholderScenario {

    @BeforeClass
    public static void config() throws IOException {
        RestAssured.baseURI = getProperty("json.placeholder.url");
    }

    @Test
    public void shouldReturnHighestUserIdValue() {
        long maxValueOfUserId = getHighestUserIdValue();
        assertThat(maxValueOfUserId).isEqualTo(10);
    }

    @Test
    public void shouldReturnHighestIdValueForProvidedUserId() {
        long highestIdValue = getHighestIdValue();
        assertThat(highestIdValue).isEqualTo(100);
    }

    @Test
    public void shouldUpdatePostForProvidedPostId() {
        long postId = getPostIdForProvidedId();
        Comment commentPayload = new Comment();
        commentPayload.setBody("Lorem ipsum");
        commentPayload.setEmail("quellesup@gmail.com");
        commentPayload.setName("eta eta");
        commentPayload.setPostId(postId);
        Comment commentResponse = given()
                .basePath(COMMENTS_WITH_ID + getHighestIdValue())
                .contentType(ContentType.JSON)
                .body(commentPayload)
        .when()
                .post()
        .then()
                .statusCode(201)
                .extract().body().as(Comment.class);
        assertThat(commentResponse.getName()).isEqualTo("eta eta");
        assertThat(commentResponse.getPostId()).isEqualTo(20);
    }

    private long getHighestUserIdValue() {
        List<Post> listOfPosts = given().basePath(POSTS_ENDPOINTS).when().get().then()
                .extract().jsonPath().getList("", Post.class);
        return listOfPosts.stream()
                .max(Comparator.comparing(Post::getUserId))
                .map(Post::getUserId).get();
    }

    private long getHighestIdValue() {
        long maxValueOfUserId = getHighestUserIdValue();
        List<Post> listOfPosts = given().basePath(POSTS_ENDPOINTS+"?userid="+maxValueOfUserId)
                .when()
                    .get()
                .then()
                    .extract().jsonPath().getList("", Post.class);
        return listOfPosts.stream()
                .max(Comparator.comparing(Post::getId))
                .map(Post::getId).get();
    }

    private long getPostIdForProvidedId() {
        long maxId = getHighestIdValue();
        List<Comment> listOfComments = given()
                .basePath(COMMENTS)
                .when()
                    .get()
                .then()
                    .extract().jsonPath().getList("", Comment.class);
        return listOfComments.stream()
                .filter(c -> c.getId() == maxId)
                .findFirst().get().getPostId();
    }
}
