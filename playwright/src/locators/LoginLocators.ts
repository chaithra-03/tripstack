import { Locator, Page } from "@playwright/test";

export class LoginLocators {

    constructor(private readonly page: Page) {}

    email(): Locator {
        return this.page.getByLabel("Email");
    }

    password(): Locator {
        return this.page.getByLabel("Password");
    }

    signInButton(): Locator {
        return this.page.getByRole("button", {name: "Sign in"});
    }


}