package com.github.zhivv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentLettersPage extends BasePage {

  @FindBy(xpath = "//div[contains(@data-cache-key,'500000_undefined_false')]//div[@class='b-datalist__body']/div[1]//div[@class='b-datalist__item__addr']")
  private WebElement lastRealEmail;

  @FindBy(xpath = "//div[contains(@data-cache-key,'500000_undefined_false')]//div[@class='b-datalist__body']/div[1]//div[@class='b-datalist__item__subj']")
  private WebElement lastRealSubj;

  public String checkFirstMessageAddress() {
    String lastEmail = lastRealEmail.getAttribute("innerText");
    return lastEmail;
  }

  public String checkFirstMessageSubject() {
    String lastSubj = lastRealSubj.getAttribute("innerText");
    return lastSubj;
  }
}
