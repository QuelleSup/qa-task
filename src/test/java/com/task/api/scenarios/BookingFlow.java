package com.task.api.scenarios;
import com.task.api.data.AuthPayload;
import com.task.api.data.BookingDates;
import com.task.api.data.BookingPayload;
import com.task.api.data.BookingResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;

import static com.task.TestProperties.*;
import static com.task.api.constants.Endpoints.AUTH_ENDPOINT;
import static com.task.api.constants.Endpoints.BOOKINGS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingFlow {

    @BeforeClass
    public static void config() throws IOException {
        RestAssured.baseURI = getProperty("test.url");
    }

    @Test
    public void shouldReturnValidToken() throws IOException {
        Response response = getAuthTokenResponse();
        assertThat(response.jsonPath().getString("token")).isNotNull();
    }

    @Test
    public void shouldReturnBookingForProvidedId() throws IOException {
        BookingPayload bookingPayload = given()
                .basePath(BOOKINGS_ENDPOINT + "1")
        .when()
                .get()
        .then()
                .statusCode(200)
                .extract().body().as(BookingPayload.class);
        assertThat(bookingPayload.getFirstName()).isNotNull();
    }

    @Test
    public void shouldCreateNewBooking() {
        BookingPayload bp = setBookingPayload();
        BookingResponse bookingResponse = given()
                .basePath(BOOKINGS_ENDPOINT)
                .contentType(ContentType.JSON)
                .body(bp)
        .when()
                .post()
        .then()
                .statusCode(200)
                .extract().body().as(BookingResponse.class);
        assertThat(bookingResponse.getBookingId()).isNotNull();
        assertThat(bookingResponse.getBookingPayload().getFirstName()).isEqualTo("Jack");
    }

    @Test
    public void shouldUpdateExistingBooking() throws IOException {
        String token = getAuthTokenResponse().jsonPath().getString("token");
        BookingPayload bookingPayload = given()
                .basePath(BOOKINGS_ENDPOINT + "1")
                .header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(setBookingPayload())
        .when()
                .put()
        .then()
                .statusCode(200)
                .extract().body().as(BookingPayload.class);
        assertThat(bookingPayload.getFirstName()).isEqualTo("Jack");
    }

    public Response getAuthTokenResponse() throws IOException {
        AuthPayload authPayload = new AuthPayload(getProperty("username"), getProperty("password"));
        return given()
                .basePath(AUTH_ENDPOINT)
                .body(authPayload)
                .contentType("application/json")
                .post();
    }

    public BookingPayload setBookingPayload() {
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2019-01-01");
        bookingDates.setCheckout("2020-01-01");
        BookingPayload bookingPayload = new BookingPayload();
        bookingPayload.setAdditionalNeeds("Breakfast");
        bookingPayload.setBookingDates(bookingDates);
        bookingPayload.setDepositPaid(false);
        bookingPayload.setFirstName("Jack");
        bookingPayload.setLastName("White");
        bookingPayload.setTotalPrice(1000);
        return bookingPayload;
    }

}
