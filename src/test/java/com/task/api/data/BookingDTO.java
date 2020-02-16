package com.task.api.data;

import lombok.Data;

@Data
public class BookingDTO {

    private String additionalneeds;
    private BookingDates bookingdates;
    private Boolean depositpaid;
    private String firstname;
    private String lastname;
    private long totalprice;

}
