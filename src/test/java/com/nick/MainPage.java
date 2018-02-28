package com.nick;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = "a[class='enter']")
    private WebElement enterLink;

    @FindBy(xpath = "//a[@class='topbar__link' and contains (@title, 'Почта')]")
    private WebElement goToMailButton;

    @FindBy(xpath = "//*[@class='button wide auth__reg']")
    private WebElement registerLink;

    @FindBy(xpath = "//*[@class='button auth__enter']")
    private WebElement authButton;

    @FindBy(className = "b-form__header")
    private WebElement regFormName;

    @FindBy(css = "input[name='login']")
    private WebElement authEmailInput;

    @FindBy(css = "input[name='password']")
    private WebElement authPasswordInput;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickToEnterAccountLink() {
        enterLink.click();
    }

    public void clickToRegistrationButton() {
        registerLink.click();
    }

    public WebElement getAuthEmailInput() {
        return authEmailInput;
    }

    public WebElement getAuthPasswordInput() {
        return authPasswordInput;
    }

    public WebElement getAuthButton() {
        return authButton;
    }

    public void clickGoToMailButton() {
        goToMailButton.click();
    }

}
