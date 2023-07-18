package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Home']")
    WebElement homeButton;
    public void clickOnHome(){
        clickOnElement(homeButton);
    }
}
