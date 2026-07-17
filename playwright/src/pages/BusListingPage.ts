import { Page } from "@playwright/test";
import { BusListingLocators } from "../locators/BusListingLocators";
import { expect } from "../fixtures/test";

export class BusListingPage {

    private readonly locators: BusListingLocators;

    constructor(private readonly page: Page) {
        this.locators = new BusListingLocators(page);
    }

    async verifyListingPage(): Promise<void> {
        await expect(this.locators.verifyListing()).toBeVisible();
    }

    async selectBusType(): Promise<void>{
        await this.locators.semiSleeper().click();
        await expect(this.locators.semiSleeper()).toBeChecked();
    }

    async verifyTypeResults(): Promise<void>{
        await expect(this.locators.verifyBus()).toBeVisible();
        await expect(this.locators.verifyBadge()).toBeVisible();
    }

    async clickSelect(): Promise<void>{
        await expect(this.locators.selectSeats()).toBeVisible();
        await this.locators.selectSeats().click();
    }

}