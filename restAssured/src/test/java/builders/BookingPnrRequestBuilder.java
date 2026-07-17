package builders;

import models.BookingPnrRequest;

public class BookingPnrRequestBuilder {

    private String pnr;

    public BookingPnrRequestBuilder withPnr(String pnr) {
        this.pnr = pnr;
        return this;
    }

    public BookingPnrRequest build() {
        return new BookingPnrRequest(pnr);
    }
}
