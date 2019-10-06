package com.github.zhivv.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://e.mail.ru/login")
public class HomePage extends BasePage {

  @FindBy(name = "Login")
  private WebElement inputLogin;

  @FindBy(name = "Password")
  private WebElement inputPassword;

  @FindBy(css = "[data-test-id='next-button']")
  private WebElementFacade nextButton;

  @FindBy(css = "[data-test-id='submit-button']")
  private WebElementFacade submitButton;

  @FindBy(xpath = "//iframe[contains(@src, 'login')]")
  private WebElementFacade iframeLogin;

  public void enterLogin(String login) {
    getDriver().switchTo().frame(iframeLogin);
    typeInto(inputLogin, login);
  }

  public void enterPass(String password) {
    typeInto(inputPassword, password);
  }

  public void clickNext() {
    nextButton.click();
  }

  public void clickEnter() {
    submitButton.click();
    getDriver().switchTo().defaultContent();
  }

}
