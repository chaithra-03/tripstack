import { Page } from "@playwright/test";
import { PassengerInformationLocators } from "../locators/PassengerInformationLocators";
import { expect } from "../fixtures/test";

export class PassengerInformationPage {

    private readonly locators: PassengerInformationLocators;

    constructor(private readonly page: Page) {
        this.locators = new PassengerInformationLocators(page);
    }

    async fillFirstName(firstName:string): Promise<void> {
        await this.locators.firstName().fill(firstName);
    }

    async fillLastName(lastName:string): Promise<void> {
        await this.locators.lastName().fill(lastName);
    }

    async fillAge(age:string): Promise<void> {
        await this.locators.age().fill(age);
    }

    async fillGender(gender:string): Promise<void> {
        await this.locators.gender().selectOption(gender);
    }

    async fillEmail(email:string): Promise<void> {
        await this.locators.email().fill(email);
    }

    async fillPhoneNumber(phoneNumber:string): Promise<void> {
        await this.locators.phoneNumber().fill(phoneNumber);
    }

    async clickContinue(): Promise<void>{
        await this.locators.continue().click();
    }

}