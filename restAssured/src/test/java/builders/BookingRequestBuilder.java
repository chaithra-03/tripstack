package builders;

import models.BookingRequest;

import java.util.List;

public class BookingRequestBuilder {

    private String journeyType;
    private String inventoryId;
    private List<String> seatIds;
    private boolean refundable = true;

    public BookingRequestBuilder forBus(String inventoryId) {
        this.journeyType = "bus";
        this.inventoryId = inventoryId;
        return this;
    }

    public BookingRequestBuilder withSeatIds(List<String> seatIds) {
        this.seatIds = List.copyOf(seatIds);
        return this;
    }

    public BookingRequestBuilder refundable(boolean refundable) {
        this.refundable = refundable;
        return this;
    }

    public BookingRequest build() {
        return new BookingRequest(journeyType, inventoryId, seatIds, refundable);
    }
}
