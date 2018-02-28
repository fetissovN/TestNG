package com.nick;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='mail-NestedList-Item-Name js-folders-item-name']")
    private WebElement inbox;

    @FindBy(className = "mail-NestedList-Item-Info-Extras")
    private WebElement mailCounter;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickInbox() {
        inbox.click();
    }

    public WebElement getMailCounter() {
        return mailCounter;
    }
}
