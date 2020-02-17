package com.task.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BookingPayload {

    @JsonProperty("additionalneeds")
    private String additionalNeeds;
    @JsonProperty("bookingdates")
    private BookingDates bookingDates;
    @JsonProperty("depositpaid")
    private Boolean depositPaid;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("totalprice")
    private long totalPrice;

}
