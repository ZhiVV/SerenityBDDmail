package com.github.zhivv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentOkPage extends BasePage {

  @FindBy(xpath = "//div[@class='message-sent__title']")
  private WebElement realSentMessage;

  public String checkMessage() {
    //  WebElement realSentMessage = getDriver().findElement(By.xpath("//div[@class='message-sent__title']"));
    String sentMessage = realSentMessage.getAttribute("innerText");
    return sentMessage;
  }
}
