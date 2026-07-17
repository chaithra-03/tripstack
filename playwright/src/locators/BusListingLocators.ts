import { Locator, Page } from "@playwright/test";

export class BusListingLocators {

    constructor(private readonly page: Page) {}

    verifyListing(): Locator {
        return this.page.getByRole("heading", {name: "Buses from DEL to BOM"});
    }

    semiSleeper(): Locator {
        return this.page.getByRole("checkbox", {name: " Semi-Sleeper"});
    }

    verifyBus(): Locator{
        return this.page.locator("//article[@aria-label='NueGo Electric']")
    }

    selectSeats(): Locator{
        return this.page.getByRole("button", {name: "Select Seats"});
    }

    verifyBadge(): Locator{
        return this.page.getByText("ac-semi");
    }

    

    

}