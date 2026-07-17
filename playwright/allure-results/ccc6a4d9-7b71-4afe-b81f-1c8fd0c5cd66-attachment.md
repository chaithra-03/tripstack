# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: booking.spec.ts >> tripstack
- Location: tests\booking.spec.ts:88:5

# Error details

```
TypeError: _TicketPage.TicketPage is not a constructor
```

# Test source

```ts
  1  | import { Page } from "@playwright/test";
  2  | import { LoginPage } from "../pages/LoginPage";
  3  | import { HomePage } from "../pages/HomePage";
  4  | import { BusListingPage } from "../pages/BusListingPage";
  5  | import { SeatSelectionPage } from "../pages/SeatSelectionPage";
  6  | import { PassengerInformationPage } from "../pages/passengerInformationPage";
  7  | import { CheckoutPage} from "../pages/CheckoutPage"
  8  | import { TicketPage } from "../pages/TicketPage";
  9  | 
  10 | export class BookingFlow {
  11 | 
  12 |     private readonly loginPage: LoginPage;
  13 |     private readonly homePage: HomePage;
  14 |     private readonly busListingPage: BusListingPage;
  15 |     private readonly seatSelectionPage: SeatSelectionPage;
  16 |     private readonly passengerInformationPage: PassengerInformationPage;
  17 |     private readonly checkoutPage: CheckoutPage;
  18 |     private readonly ticketPage: TicketPage;
  19 | 
  20 |     constructor(private readonly page: Page) {
  21 | 
  22 |         this.loginPage = new LoginPage(page);
  23 |         this.homePage = new HomePage(page);
  24 |         this.busListingPage = new BusListingPage(page);
  25 |         this.seatSelectionPage = new SeatSelectionPage(page);
  26 |         this.passengerInformationPage = new PassengerInformationPage(page);
  27 |         this.checkoutPage = new CheckoutPage(page);
> 28 |         this.ticketPage=new TicketPage(page);
     |                         ^ TypeError: _TicketPage.TicketPage is not a constructor
  29 | 
  30 |     }
  31 | 
  32 |     async login(username: string, password: string): Promise<void> {
  33 | 
  34 |         await this.loginPage.open();
  35 |         await this.loginPage.enterEmail(username);
  36 |         await this.loginPage.enterPassword(password);
  37 |         await this.loginPage.clickSignIn();
  38 | 
  39 |     }
  40 | 
  41 |     async searchBus(fromCity:string, toCity:string, date:string): Promise<void>{
  42 |         await this.homePage.verifyHomePage();
  43 |         await this.homePage.switchBuses();
  44 |         await this.homePage.enterFrom(fromCity);
  45 |         await this.homePage.enterDestination(toCity);
  46 |         await this.homePage.selectDate(date);
  47 |         await this.homePage.clickSearch();
  48 |     }
  49 | 
  50 |     async filterSearchResults(): Promise<void>{
  51 |         await this.busListingPage.verifyListingPage();
  52 |         await this.busListingPage.selectBusType();
  53 |         await this.busListingPage.verifyTypeResults();
  54 |         await this.busListingPage.clickSelect();
  55 |     }
  56 | 
  57 |     async selectSeats(): Promise<void>{
  58 |         await this.seatSelectionPage.verifySelectionPage();
  59 |         await this.seatSelectionPage.selectSeat();
  60 |         await this.seatSelectionPage.selectBoarding();
  61 |         await this.seatSelectionPage.selectDroping();
  62 |         await this.seatSelectionPage.clickContinue();
  63 |     }
  64 | 
  65 |     async passengerInformation(firstName:string, lastName:string, age:string,gender:string, email:string, phoneNumber:string): Promise<void>{
  66 |         await this.passengerInformationPage.fillFirstName(firstName);
  67 |         await this.passengerInformationPage.fillLastName(lastName);
  68 |         await this.passengerInformationPage.fillAge(age);
  69 |         await this.passengerInformationPage.fillGender(gender);
  70 |         await this.passengerInformationPage.fillEmail(email);
  71 |         await this.passengerInformationPage.fillPhoneNumber(phoneNumber);
  72 |         await this.passengerInformationPage.clickContinue();
  73 |     }
  74 | 
  75 |     async checkout(name:string, number:string, expiry:string, cvv:string): Promise<void>{
  76 |         await this.checkoutPage.fillName(name);
  77 |         await this.checkoutPage.fillNumber(number);
  78 |         await this.checkoutPage.fillExpiry(expiry);
  79 |         await this.checkoutPage.fillCVV(cvv);
  80 |         await this.checkoutPage.clickPay();
  81 |     }
  82 | 
  83 |     async ticketConfirmation(): Promise<void>{
  84 |         await this.ticketPage.verifyTicket();
  85 |     }
  86 | 
  87 | }
```