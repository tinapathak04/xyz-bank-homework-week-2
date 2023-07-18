package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Add Customer']" )
    WebElement clickAddCustomer;

    @CacheLookup
    @FindBy(xpath ="//input[@placeholder='First Name']" )
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath ="//input[@placeholder='Last Name']" )
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @CacheLookup
    @FindBy(xpath ="//button[@type='submit']" )
    WebElement submitAddCustomer;


    public void clickOnAddCustomer(){
        clickOnElement(clickAddCustomer);
    }
    public void enterOnFirstName(String name){

        sendTextToElement(firstName,name);
    }
    public void enterOnLastName(String lastname){
        sendTextToElement(lastName,lastname);
    }
    public void enterPostCode(String postcode){
        sendTextToElement(postCode,postcode);
    }
    public void clickOnSubmitAddCustomer(){
        clickOnElement(submitAddCustomer);
    }
    public void popUpDisplay(){
        driver.switchTo().alert();
    }
    public void getMessageSuccessfully(){
        System.out.println(getTextFromAlert());
    }
    public void okButton(){
        acceptAlert();
    }

}
