import { Locator, Page } from "@playwright/test";

export class HomeLocators {

    constructor(private readonly page: Page) {}

    buses(): Locator {
        return this.page.getByRole("link", {name: "Buses"}).first();
    }

    fromLocation(): Locator {
        return this.page.getByRole("combobox", {name: "From"});
    }

    toLocation(): Locator {
        return this.page.getByRole("combobox", {name: "To"});
    }

    datePicker(): Locator {
        return this.page.getByLabel("Date of journey");
    }

    searchButton(): Locator{
        return this.page.getByRole("button", {name: "Search buses"});
    }

    homeVerify(): Locator{
        return this.page.getByRole("heading", {name: "Book flights & buses across India"});
    }

    busVerify(): Locator{
        return this.page.getByRole("heading", {name: "Book bus tickets across India"});
    }

}