# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: booking.spec.ts >> tripstack
- Location: tests\booking.spec.ts:88:5

# Error details

```
Test timeout of 30000ms exceeded.
```

```
Error: locator.fill: Test timeout of 30000ms exceeded.
Call log:
  - waiting for getByLabel('Name on card')

```

# Page snapshot

```yaml
- generic [active] [ref=e1]:
  - banner [ref=e2]:
    - generic [ref=e3]:
      - link "TripStack" [ref=e4] [cursor=pointer]:
        - /url: /
      - navigation "Primary" [ref=e5]:
        - link "Flights" [ref=e6] [cursor=pointer]:
          - /url: /flights/search
        - link "Buses" [ref=e7] [cursor=pointer]:
          - /url: /buses/search
        - link "My Trips" [ref=e8] [cursor=pointer]:
          - /url: /my-trips
        - link "Log out" [ref=e9] [cursor=pointer]:
          - /url: /logout
  - main [ref=e10]:
    - generic [ref=e12]:
      - generic [ref=e13]: "409"
      - heading "Seat no longer available" [level=1] [ref=e14]
      - alert [ref=e15]: One of those seats was just taken. Please pick another.
      - generic [ref=e16]:
        - link "← Back" [ref=e17] [cursor=pointer]:
          - /url: https://tripstack.doomple.com/book/passenger?type=bus&inventory=BUS-DELBOM-03&seats=S1&boardingPoint=Delhi+City+Junction&droppingPoint=Mumbai+Railway+Station
        - link "Go to home" [ref=e18] [cursor=pointer]:
          - /url: /
  - contentinfo [ref=e19]:
    - generic [ref=e20]:
      - generic [ref=e21]: © TripStack — a demo travel marketplace for SDET training.
      - generic [ref=e22]: Flights · Buses · Seat selection · Secure checkout
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
     |                                        ^ Error: locator.fill: Test timeout of 30000ms exceeded.
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