package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {

    HomePage homepage;
    AddCustomerPage customerPage;
    BankManagerLoginPage managerloginpage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage loginPage;
    CustomerPage customer;
    AccountPage account;

    @BeforeMethod(alwaysRun = true)
    public void init() {

        homepage = new HomePage();
        customerPage = new AddCustomerPage();
        managerloginpage = new BankManagerLoginPage();
        openAccountPage = new OpenAccountPage();
        loginPage = new CustomerLoginPage();
        customer = new CustomerPage();
        account = new AccountPage();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homepage.clickOnHome();
        //click On "Bank Manager Login" Tab
        managerloginpage.clickOnBankManagerLogin();
        //click On "Add Customer" Tab
        customerPage.clickOnAddCustomer();
        //enter FirstName
        customerPage.enterOnFirstName("Tina");
        //enter LastName
        customerPage.enterOnLastName("Pathak");
        //enter PostCode
        customerPage.enterPostCode("HA3 7FD");
        //click On "Add Customer" Button
        customerPage.clickOnSubmitAddCustomer();
        //popup display
        customerPage.popUpDisplay();
        //verify message "Customer added successfully"
        customerPage.getMessageSuccessfully();
        //click on "ok" button on popup.
        customerPage.okButton();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //click On "Bank Manager Login" Tab
        managerloginpage.clickOnBankManagerLogin();
        //click On "Open Account" Tab
        openAccountPage.clickOnOpenAccount();
        //Search customer that created in first test
        openAccountPage.setSearchFirstTest("Harry Potter");
        Thread.sleep(1000);
        //Select currency "Pound"
        openAccountPage.selectCurrency("Pound");
        //click on "process" button
        openAccountPage.clickOnProcess();
        //popup displayed
        customerPage.popUpDisplay();
        //verify message "Account created successfully"
        customerPage.getMessageSuccessfully();
        //click on "ok" button on popup.
        customerPage.okButton();
    }

    @Test(groups = {"smoke","regression"})
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        loginPage.clickOnLoginLink();
        //search customer that you created.
        customer.searchOnCreatedCustomer("Harry Potter");
        //click on "Login" Button
        customer.clickOnLogin();
        //verify "Logout" Tab displayed.
//       String expectedText = "Logout";
//       String actualText = customer.verifyOnLogout();
//       Assert.assertEquals(actualText,expectedText,"Login page not displayed");
        //click on "Logout"
        Thread.sleep(1000);
        customer.clickOnLogout();
        //verify "Your Name" text displayed.
        String expectedText1 = "Tina Pathak";
        String actualText1 = customer.verifyYourNameDisplayed();
        Assert.assertEquals(actualText1, expectedText1, "Message not displayed");

    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {

        //click on "Customer Login" Tab
        loginPage.clickOnLoginLink();
        //search customer that you created.
        customer.searchOnCreatedCustomer("Harry Potter");
        //click on "Login" Button
        customer.clickOnLogin();
        Thread.sleep(1000);
        //click on "Deposit" Tab
        account.byDeposit();
        //Enter amount 100
        account.enter100("100");
        //click on "Deposit" Button
        account.clickOnDeposit();
        //verify message "Deposit Successful"
        String expectedText = "Deposit Successful";
        String actualText = account.verifyDepositText();
        Assert.assertEquals(actualText, expectedText, "Message not displayed");

    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        loginPage.clickOnLoginLink();
        //search customer that you created.
        customer.searchOnCreatedCustomer("Harry Potter");
        //click on "Login" Button
        customer.clickOnLogin();
        Thread.sleep(1000);
        //click on "Withdrawl" Tab
        account.clickOnWithdrawl();
        //Enter amount 50
        account.deposit50("50");
        //click on "Deposit" Button
        account.submitWithdrawl();
        //verify message "Transaction Successful"
        String expectedText = "Transaction Successful";
        String actualText = account.verifyTransaction();
        Assert.assertEquals(actualText, expectedText, "Message not displayed");
    }
}



