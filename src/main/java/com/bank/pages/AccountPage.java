package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Deposit']" )
    WebElement deposit;

    @CacheLookup
    @FindBy(xpath ="//input[@placeholder='amount']" )
    WebElement enterAmount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickDeposit;

    @CacheLookup
    @FindBy
    WebElement verifyDepositSuccessfully;

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Withdrawl']" )
    WebElement withdrawl;

    @CacheLookup
    @FindBy(xpath ="//input[@placeholder='amount']" )
    WebElement enter50;

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Withdraw']" )
    WebElement clickWithdrawl;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement textTransaction;





    public void byDeposit(){
        clickOnElement(deposit);
    }
    public void enter100(String amount){

        sendTextToElement(enterAmount,amount);
    }
    public void clickOnDeposit(){
        clickOnElement(clickDeposit);
    }
    public String verifyDepositText(){
        return getTextFromElement(verifyDepositSuccessfully);
    }
    public void clickOnWithdrawl(){
        clickOnElement(withdrawl);
    }
    public void deposit50(String depositAmount){
        sendTextToElement(enter50,depositAmount);
    }
    public void submitWithdrawl(){
        clickOnElement(clickWithdrawl);
    }
    public String verifyTransaction(){
        return getTextFromElement(textTransaction);
    }

}
