import {expect, test} from "@playwright/test"

test("booking", async({page}) =>{
    await page.goto("https://www.redbus.in/");
    await page.locator("#srcinput").fill("Trivandrum");
    await page.locator("//*[contains(@aria-label,'Trivandrum') and @role='button']").click();
    await page.locator("#destinput").fill("Bangalore");
    await page.locator("//*[contains(@aria-label,'Bengaluru') and @role='button']").click();
    await page.getByRole("button", {name: "Search buses"}).click();
    await expect(page).toHaveURL(/bus-tickets/);
    await page.waitForLoadState();
    await expect(page.locator("//*[@aria-label='Trivandrum to Bangalore']")).toBeVisible();

})

test("dropdown", async({page}) =>{
    await page.goto("https://www.testmuai.com/selenium-playground/jquery-dropdown-search-demo/")
    await page.locator('#country').selectOption("India")
    await page.waitForTimeout(10000)
})


test("tripstack", async({page}) =>{
    page.goto("https://tripstack.doomple.com/")
    await page.getByRole("combobox", { name: "From" }).fill("BLR")
    // await page.getByRole("option", { name: /Bengaluru/i }).click();

    await page.getByRole("combobox", { name: "To" }).fill("MAA")
    // await page.getByRole("option", { name: /Chennai/i }).click();
    await page.getByLabel("Date").fill("2026-07-23");
    await page.getByRole("button", {name: "Search"}).click()
    await page.getByRole("button", {name: "Book"}).first().click()
    await page.waitForTimeout(10000);
})


test.only("amazon", async({page}) =>{
    await page.goto("https://www.amazon.in/");
    await expect(page.getByRole("link", {name:"Amazon.in"})).toBeVisible();
    await page.getByLabel("Search Amazon.in").fill("minimalist salicylic acid facewash");
    await page.getByRole("button", {name: "Go", exact: true }).click();
    await page.waitForTimeout(10000);
    await expect(page.getByRole("heading", {name:"Anti-Acne Salicylic Acid 2% Face Wash For Oily & Acne Prone Skin | With LHA for Pore Cleansing, Oil Control & Sebum Regulation | Sulfate-Free Formula for Gentle Exfoliation | Cleanser for Women & Men | 250 ml"})).toBeVisible();
    await page.waitForTimeout(10000);
})

test.only("check", async({page}) =>{
    await page.goto("https://www.amazon.in/Minimalist-Regulation-Sulfate-Free-Exfoliation-Combination/dp/B0D3WX7G3H/ref=sr_1_6?crid=3RB8QKX2OBYIL&dib=eyJ2IjoiMSJ9.fsH1R7LGQ3BHFxrfUmOep9GRvcFk1pGUPZTukSwYr2Hudlvy3lsD4HjnCYXBtdKAm7A46vbZr_Aq0B_VRlLRb-42H7JqdZ9hGJC7Yxj5c4le88HBDbwGa5AyO1VGpf-fzS2Kxx6hbNLKzJ5KET-h8CuH0VFXgL31XH71QT71z6AvEI5bsyMG7lxtItH46BTZXhSMrX9Ma0Kp5uJCIERuGxEN_tz3_B4IOp4Ml5mUXBrdo6Ydn0rgbjQQnhrB2QvcGdACclvTCKEZqjMt4h3OZOPoFwmfkGdJOtjK6wXWvdE.tEIeXjTrtwssVkhE3IwLH6MTVuT9pxFA_FvsIN4JrkE&dib_tag=se&keywords=minimalist%2Bsalicylic%2Bacid%2Bfacewash&qid=1784558138&sprefix=minimalist%2Bsalicylic%2Bacid%2Bfacewash%2Caps%2C636&sr=8-6&th=1");
})