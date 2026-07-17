import { Page } from "@playwright/test";
import { LoginLocators } from "../locators/LoginLocators";
import { expect } from "../fixtures/test";

export class LoginPage {

    private readonly locators: LoginLocators;

    constructor(private readonly page: Page) {
        this.locators = new LoginLocators(page);
    }

    async open(): Promise<void> {
        await this.page.goto("/login");
    }

    async enterEmail(email: string): Promise<void> {
        await this.locators.email().fill(email);
        await expect(this.locators.email()).toHaveValue(email);
    }

    async enterPassword(password: string): Promise<void> {
        await this.locators.password().fill(password);
        await expect(this.locators.password()).toHaveValue(password);
    }

    async clickSignIn(): Promise<void> {
        await expect(this.locators.signInButton()).toBeVisible();
        await this.locators.signInButton().click();
    }

}