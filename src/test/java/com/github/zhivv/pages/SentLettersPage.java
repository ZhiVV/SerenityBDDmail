package com.github.zhivv.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentLettersPage extends BasePage{

  @FindBy(css = "div.b-nav__item_active a[href='/messages/sent/']")
  WebElementFacade sentLinkActive;

  @FindBy(xpath = "//div[@class='b-datalist__body']/div[1]//div[@class='b-datalist__item__addr']")
  private WebElement lastRealEmail;

  public String checkFirstMessageAddress() {
    WebElement lastRealEmail2 = getDriver().findElement(By.xpath("//div[contains(@data-cache-key,'500000_undefined_false')]//div[@class='b-datalist__body']/div[1]//div[@class='b-datalist__item__addr']"));
    String lastEmail = lastRealEmail2.getAttribute("innerText");
    return lastEmail;
  }

  public String checkFirstMessageSubject() {
    WebElement lastRealSubj = getDriver().findElement(By.xpath("//div[contains(@data-cache-key,'500000_undefined_false')]//div[@class='b-datalist__body']/div[1]//div[@class='b-datalist__item__subj']"));
    String lastSubj = lastRealSubj.getAttribute("innerText");
    return lastSubj;
  }
}
