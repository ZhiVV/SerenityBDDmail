package com.github.zhivv.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://e.mail.ru/login")
public class HomePage extends BasePage{

    @FindBy(name = "Login")
    WebElement inputLogin;

    @FindBy(name = "Password")
    WebElement inputPassword;

    @FindBy(css = "[data-test-id='next-button']")
    WebElementFacade nextButton;

    @FindBy(css = "[data-test-id='submit-button']")
    WebElementFacade submitButton;

    @FindBy(xpath = "//iframe[contains(@src, 'login')]")
    WebElementFacade iframeLogin;

    public void enterLogin(String login){
        getDriver().switchTo().frame(iframeLogin);
        inputLogin.clear();
        inputLogin.sendKeys(login);
    }

    public void enterPass(String password){
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void clickNext(){
        nextButton.click();
    }

    public void clickEnter(){
        submitButton.click();
        getDriver().switchTo().defaultContent();
    }

}
