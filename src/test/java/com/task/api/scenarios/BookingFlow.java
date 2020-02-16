package com.task.api.scenarios;
import com.task.api.AuthPayload;
import com.task.api.data.BookingDTO;
import io.restassured.response.Response;
import org.junit.Test;


import java.io.IOException;

import static com.task.TestProperties.*;
import static com.task.api.constants.Endpoints.AUTH_ENDPOINT;
import static com.task.api.constants.Endpoints.BOOKINGS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingFlow {

    public Response getAuthTokenResponse() throws IOException {
        AuthPayload authPayload = new AuthPayload(getProperty("username"), getProperty("password"));
        return given()
                .baseUri(getProperty("test.url"))
                .basePath(AUTH_ENDPOINT)
                .body(authPayload)
                .contentType("application/json")
                .post();
    }

    @Test
    public void shouldReturnValidToken() throws IOException {
        Response response = getAuthTokenResponse();
        assertThat(response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnBookingForProvidedId() throws IOException {
        BookingDTO bookingDTO = given()
                .baseUri(getProperty("test.url"))
                .basePath(BOOKINGS_ENDPOINT + "1")
        .when()
                .get()
        .then()
                .statusCode(200)
                .extract().body().as(BookingDTO.class);
        assertThat(bookingDTO.getFirstname()).isEqualTo("Jim");
    }
}
