package com.nick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    private static final String AUTH_FORM_EMAIL = "testOTS@tut.by";
    private static final String AUTH_FORM_PASSWORD = "012345678";

    private WebDriver driver;

    private MainPage mainPage;

    private MailPage mailPage;

    private RegistrationPage registrationPage;

    @FindBy(css = "span[class='_nb-button-content']")
    private WebElement yandexAuthButton;

    @FindBy(xpath = "//button[@class='passport-Button' and contains (@type, 'submit')]")
    private WebElement submitYandex;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","D:/geckodriver.exe");
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        mailPage = new MailPage(driver);
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver,this);
    }


    public void goToMainPage(){
        driver.get("https://www.tut.by/");

    }

    @org.testng.annotations.Test
    public void createAccount() {
        goToMainPage();
        mainPage.clickToEnterAccountLink();
        mainPage.getAuthEmailInput().sendKeys(AUTH_FORM_EMAIL);
        mainPage.getAuthPasswordInput().sendKeys(AUTH_FORM_PASSWORD);
        mainPage.getAuthButton().click();
        mainPage.clickGoToMailButton();
        if (driver.getCurrentUrl().equals("https://mail.yandex.by/#inbox")){
            List<WebElement> elements = driver.findElements(By.className("_nb-button-content"));
            WebElement loginYandex = elements.get(1);
            loginYandex.click();
            List<WebElement> fields = driver.findElements(By.className("passport-Input-Controller"));
            fields.get(0).sendKeys(AUTH_FORM_EMAIL);
            fields.get(1).sendKeys(AUTH_FORM_PASSWORD);
            submitYandex.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = mailPage.getMailCounter().getText();
        String[] strings = text.split(" ");
        String result = text;
        if (strings.length > 2){
            String allInbox = strings[2];
            result = allInbox;
        }
        Assert.assertTrue(result != null, "Failed to find counter.");
        System.out.println("There are " + result + " mails in inbox.");
    }

    @AfterClass
    public void tearDown() {
        if (driver!=null){
            driver.quit();
        }
    }
}
