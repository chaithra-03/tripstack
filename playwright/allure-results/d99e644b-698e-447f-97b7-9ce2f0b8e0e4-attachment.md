# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: booking.spec.ts >> tripstack
- Location: tests\booking.spec.ts:88:5

# Error details

```
Error: locator.isVisible: Error: strict mode violation: getByText('CONFIRMED') resolved to 2 elements:
    1) <p class="muted">Your booking is confirmed. A copy is always avail…</p> aka getByText('Your booking is confirmed. A')
    2) <span data-id="state" class="badge badge-ok">CONFIRMED</span> aka getByText('CONFIRMED', { exact: true })

Call log:
    - checking visibility of getByText('CONFIRMED')

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
    - list "Booking progress" [ref=e11]:
      - listitem [ref=e12]:
        - generic [ref=e13]: "1"
        - text: Search
      - listitem [ref=e14]:
        - generic [ref=e15]: "2"
        - text: Seats
      - listitem [ref=e16]:
        - generic [ref=e17]: "3"
        - text: Passenger
      - listitem [ref=e18]:
        - generic [ref=e19]: "4"
        - text: Payment
      - listitem [ref=e20]:
        - generic [ref=e21]: "5"
        - text: Ticket
    - heading "You're all set! 🎉" [level=1] [ref=e22]
    - paragraph [ref=e23]: Your booking is confirmed. A copy is always available under My Trips.
    - generic [ref=e24]:
      - generic [ref=e25]:
        - generic [ref=e26]:
          - generic [ref=e27]:
            - generic [ref=e28]:
              - generic [ref=e29]:
                - img [ref=e30]
                - text: Booking reference (PNR)
              - generic [ref=e32]: TS-1006-0003
            - generic [ref=e33]: CONFIRMED
          - generic [ref=e34]:
            - generic [ref=e35]:
              - generic [ref=e36]: Journey
              - generic [ref=e37]: Bus
            - generic [ref=e38]:
              - generic [ref=e39]: Seats
              - generic [ref=e40]: S1
            - generic [ref=e41]:
              - generic [ref=e42]: Amount paid
              - generic [ref=e43]: ₹1298.85
        - button "View my trips" [ref=e44] [cursor=pointer]
      - complementary [ref=e45]:
        - generic [ref=e46]:
          - paragraph [ref=e47]: Need a hand?
          - paragraph [ref=e48]: Show your PNR at check-in. You can review or cancel this booking anytime from My Trips.
  - contentinfo [ref=e49]:
    - generic [ref=e50]:
      - generic [ref=e51]: © TripStack — a demo travel marketplace for SDET training.
      - generic [ref=e52]: Flights · Buses · Seat selection · Secure checkout
```

# Test source

```ts
  1  | import { Page } from "@playwright/test";
  2  | import { TicketLocators } from "../locators/TicketLocators";
  3  | import { expect } from "../fixtures/ui.fixture";
  4  | 
  5  | export class TicketPage {
  6  | 
  7  |     private readonly locators: TicketLocators;
  8  | 
  9  |     constructor(private readonly page: Page) {
  10 |         this.locators = new TicketLocators(page);
  11 |     }
  12 | 
  13 | 
  14 |     async verifyTicket(): Promise<void>{
  15 |         await this.locators.pnr().isVisible();
> 16 |         await this.locators.verifyPage().isVisible();
     |                                          ^ Error: locator.isVisible: Error: strict mode violation: getByText('CONFIRMED') resolved to 2 elements:
  17 |         await this.locators.viewButton().isVisible();
  18 |     }
  19 | 
  20 | }
```