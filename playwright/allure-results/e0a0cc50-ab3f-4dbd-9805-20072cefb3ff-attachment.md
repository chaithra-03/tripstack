# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: booking.spec.ts >> tripstack
- Location: tests\booking.spec.ts:88:5

# Error details

```
TypeError: _BusListingPage.SearchResultsPage is not a constructor
```

# Test source

```ts
  1  | import { Page } from "@playwright/test";
  2  | import { LoginPage } from "../pages/LoginPage";
  3  | import { HomePage } from "../pages/HomePage";
  4  | import { BusListingPage } from "../pages/BusListingPage";
  5  | 
  6  | export class BookingFlow {
  7  | 
  8  |     private readonly loginPage: LoginPage;
  9  |     private readonly homePage: HomePage;
  10 |     private readonly busListingPage: BusListingPage;
  11 | 
  12 |     constructor(private readonly page: Page) {
  13 | 
  14 |         this.loginPage = new LoginPage(page);
  15 |         this.homePage = new HomePage(page);
> 16 |         this.busListingPage = new BusListingPage(page);
     |                                  ^ TypeError: _BusListingPage.SearchResultsPage is not a constructor
  17 | 
  18 |     }
  19 | 
  20 |     async login(username: string, password: string): Promise<void> {
  21 | 
  22 |         await this.loginPage.open();
  23 |         await this.loginPage.enterEmail(username);
  24 |         await this.loginPage.enterPassword(password);
  25 |         await this.loginPage.clickSignIn();
  26 | 
  27 |     }
  28 | 
  29 |     async searchBus(fromCity:string, toCity:string, date:string): Promise<void>{
  30 |         await this.homePage.verifyHomePage();
  31 |         await this.homePage.switchBuses();
  32 |         await this.homePage.enterFrom(fromCity);
  33 |         await this.homePage.enterDestination(toCity);
  34 |         await this.homePage.selectDate(date);
  35 |         await this.homePage.clickSearch();
  36 |     }
  37 | 
  38 |     async filterSearchResults(): Promise<void>{
  39 |         await this.busListingPage.verifyListingPage();
  40 |         await this.busListingPage.selectBusType();
  41 |         await this.busListingPage.verifyTypeResults();
  42 |         await this.busListingPage.clickSelect();
  43 |     }
  44 | 
  45 | }
```