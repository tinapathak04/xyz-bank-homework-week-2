package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement clickOpenAccount;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchFirstTest;

    @CacheLookup
    @FindBy(xpath ="//select[@id='currency']" )
    WebElement currency;

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Process']" )
    WebElement process;


    public void clickOnOpenAccount(){
        clickOnElement(clickOpenAccount);
    }
    public void setSearchFirstTest(String searchName){
        selectByContainsTextFromDropDown((By) searchFirstTest,searchName);
    }
    public void selectCurrency(String currency1){
       selectByContainsTextFromDropDown((By) currency,currency1);
    }
    public void clickOnProcess(){
        clickOnElement(process);
    }


}
