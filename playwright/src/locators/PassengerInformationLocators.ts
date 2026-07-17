import { Locator, Page } from "@playwright/test";

export class PassengerInformationLocators {

    constructor(private readonly page: Page) {}

    firstName(): Locator {
        return this.page.getByLabel((/First name/));
    }

    lastName(): Locator {
        return this.page.getByLabel(/Last name/);
    }

    age(): Locator {
        return this.page.getByLabel(/Age/);
    }

    gender(): Locator {
        return this.page.getByRole("combobox", {name: /Gender/});
    }

    email(): Locator{
        return this.page.getByLabel("Email");
    }

    phoneNumber(): Locator{
        return this.page.getByLabel("Phone number");
    }

    continue(): Locator{
        return this.page.getByRole("button", {name: "Continue to payment"});
    }

}