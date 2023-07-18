package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Customer Login']" )
    WebElement loginLink;

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }
}
