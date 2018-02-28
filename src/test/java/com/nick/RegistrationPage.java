package com.nick;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement emailField;

    @FindBy(id = "field-password")
    private WebElement passwordField;

    @FindBy(id = "field-birthday")
    private WebElement birthdayField;

    @FindBy(id = "field-city")
    private WebElement cityField;

    @FindBy(id = "field-phone")
    private WebElement phoneField;

    @FindBy(id = "field-fio")
    private WebElement fioField;

    @FindBy(id = "reg_submit")
    private WebElement submitRegistration;

    @FindBy(className = "b-form__header")
    private WebElement regFormName;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getRegistrationFormName() {
        return regFormName.getText();
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getBirthdayField() {
        return birthdayField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getSubmitRegistration() {
        return submitRegistration;
    }

    public WebElement getFioField() {
        return fioField;
    }
}

//        mainPage.clickToRegistrationButton();
//        Assert.assertEquals(REG_FORM_NAME,registrationPage.getRegistrationFormName());

//        registrationPage.getEmailField().sendKeys("testOTS");
//        registrationPage.getPasswordField().sendKeys("012345678");
//        registrationPage.getBirthdayField().sendKeys("13.01.91");
//        registrationPage.getCityField().sendKeys("Минск");
//        registrationPage.getFioField().sendKeys("Name Surname");
//        registrationPage.getPhoneField().sendKeys("333451671");
//        registrationPage.getSubmitRegistration().click();