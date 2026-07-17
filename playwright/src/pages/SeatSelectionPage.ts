import { Page } from "@playwright/test";
import { SeatSelectionLocators } from "../locators/SeatSelectionLocators";
import { expect } from "../fixtures/test";

export class SeatSelectionPage {

    private readonly locators: SeatSelectionLocators;

    constructor(private readonly page: Page) {
        this.locators = new SeatSelectionLocators(page);
    }

    async verifySelectionPage(): Promise<void> {
        await expect(this.locators.verifyPage()).toBeVisible();
    }

    async selectSeat(): Promise<void>{
        await this.locators.seat().click();
        await this.locators.verifySelected().isVisible();
    }

    async selectBoarding(): Promise<void>{
        await this.locators.boardingPoint().click();
    }

    async selectDroping(): Promise<void>{
        await this.locators.droppingPoint().click();
    }

    async clickContinue(): Promise<void>{
        await expect(this.locators.continueButton()).toBeVisible();
        await this.locators.continueButton().click();
    }

}