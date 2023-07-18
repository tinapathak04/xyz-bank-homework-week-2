package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement createdCustomer;

    @CacheLookup
    @FindBy(xpath ="//select[@id='userSelect']" )
    WebElement login;

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Logout']" )
    WebElement verifyLogout;

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Logout']" )
    WebElement logout;

    @CacheLookup
    @FindBy(xpath ="//span[@class='fontBig ng-binding']" )
    WebElement textYourName;


    public void searchOnCreatedCustomer(String createdName) {
        selectByContainsTextFromDropDown((By) createdCustomer, createdName);
    }
    public void clickOnLogin(){
        clickOnElement(login);
    }
    public String verifyOnLogout(){
        return getTextFromElement(verifyLogout);
    }
    public void clickOnLogout(){
        clickOnElement(logout);
    }
    public String verifyYourNameDisplayed(){
        return getTextFromElement(textYourName);
    }


}
