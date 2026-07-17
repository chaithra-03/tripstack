import { Locator, Page } from "@playwright/test";

export class SeatSelectionLocators {

    constructor(private readonly page: Page) {}

    verifyPage(): Locator {
        return this.page.getByRole("heading", {name: "Boarding points"});
    }

    boardingPoint(): Locator {
        return this.page.getByRole("radio", {name: "Delhi City Junction"});
    }

    droppingPoint(): Locator {
        return this.page.getByRole("radio", {name: "Mumbai Railway Station"});
    }

    seat(): Locator{
        return this.page.locator("//*[contains(@aria-label,'available')]").first();
    }

    continueButton(): Locator{
        return this.page.getByRole("button", {name: "Continue to passenger details"});
    }

    verifySelected(): Locator{
        return this.page.locator("//*[contains(@aria-label,'Seat S29 available') and @aria-pressed='true']")
    }

}