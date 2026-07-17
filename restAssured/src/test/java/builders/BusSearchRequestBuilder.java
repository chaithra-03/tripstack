package builders;

import models.BusSearchRequest;

public class BusSearchRequestBuilder {

    private String from;
    private String to;
    private String date;

    public BusSearchRequestBuilder withFrom(String from) {
        this.from = from;
        return this;
    }

    public BusSearchRequestBuilder withTo(String to) {
        this.to = to;
        return this;
    }

    public BusSearchRequestBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public BusSearchRequest build() {
        return new BusSearchRequest(from, to, date);
    }
}
