package builders;

import models.BusSeatsRequest;

public class BusSeatsRequestBuilder {

    private String busId;

    public BusSeatsRequestBuilder withBusId(String busId) {
        this.busId = busId;
        return this;
    }

    public BusSeatsRequest build() {
        return new BusSeatsRequest(busId);
    }
}
