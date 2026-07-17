package builders;

import models.BookingIdRequest;

public class BookingIdRequestBuilder {

    private String bookingId;

    public BookingIdRequestBuilder withBookingId(String bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public BookingIdRequest build() {
        return new BookingIdRequest(bookingId);
    }
}
