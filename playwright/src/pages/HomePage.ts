import { Page } from "@playwright/test";
import { HomeLocators } from "../locators/HomeLocators";
import { expect } from "../fixtures/test";

export class HomePage {

    private readonly locators: HomeLocators;

    constructor(private readonly page: Page) {
        this.locators = new HomeLocators(page);
    }

    async verifyHomePage(): Promise<void> {
        await expect(this.page).toHaveURL("/");
        await expect(this.locators.homeVerify()).toBeVisible();
    }

    async switchBuses(): Promise<void>{
        await this.locators.buses().click();
        await expect(this.locators.busVerify()).toBeVisible();
    }

    async enterFrom(city: string): Promise<void> {
        await this.locators.fromLocation().fill(city);
        await expect(this.locators.fromLocation()).toHaveValue(city);
    }

    async enterDestination(city: string): Promise<void> {
        await this.locators.toLocation().fill(city);
        await expect(this.locators.toLocation()).toHaveValue(city);
    }

    async selectDate(date: string): Promise<void>{
        await this.locators.datePicker().fill(date);
        await expect(this.locators.datePicker()).toHaveValue(date);
    }

    async clickSearch(): Promise<void> {
        await expect(this.locators.searchButton()).toBeVisible();
        await this.locators.searchButton().click();
    }

}