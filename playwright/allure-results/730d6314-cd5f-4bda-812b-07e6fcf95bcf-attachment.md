# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: booking.spec.ts >> tripstack
- Location: tests\booking.spec.ts:88:5

# Error details

```
Error: locator.fill: Test ended.
Call log:
  - waiting for getByLabel('Name on card')

```

# Test source

```ts
  1  | import { Page } from "@playwright/test";
  2  | import { CheckoutLocators } from "../locators/CheckoutLocators";
  3  | import { expect } from "../fixtures/ui.fixture";
  4  | 
  5  | export class CheckoutPage {
  6  | 
  7  |     private readonly locators: CheckoutLocators;
  8  | 
  9  |     constructor(private readonly page: Page) {
  10 |         this.locators = new CheckoutLocators(page);
  11 |     }
  12 | 
  13 |      async fillName(name:string): Promise<void> {
> 14 |         await this.locators.cardName().fill(name);
     |                                        ^ Error: locator.fill: Test ended.
  15 |     }
  16 | 
  17 |     async fillNumber(number:string): Promise<void> {
  18 |         await this.locators.cardNumber().fill(number);
  19 |     }
  20 | 
  21 |     async fillExpiry(expiry:string): Promise<void> {
  22 |         await this.locators.expiry().fill(expiry);
  23 |     }
  24 | 
  25 |     async fillCVV(cvv:string): Promise<void> {
  26 |         await this.locators.cvv().fill(cvv);
  27 |     }
  28 | 
  29 | 
  30 |     async clickPay(): Promise<void>{
  31 |         await this.locators.payButton().click();
  32 |     }
  33 | 
  34 | }
```