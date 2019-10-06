package com.github.zhivv.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class MainPage extends BasePage {

  @FindBy(css = "[data-shortcut='n']")
  private WebElementFacade newLetterButton;

  @FindBy(xpath = "//textarea[@data-original-name='To']")
  private WebElement fieldTo;

  @FindBy(name = "Subject")
  private WebElement fieldSubject;

  @FindBy(xpath = "//iframe[contains(@id, 'composeEditor_ifr')]")
  private WebElement iframeEditor;

  @FindBy(id = "tinymce")
  private WebElement fieldText;

  @FindBy(css = "[data-shortcut='g,s']")
  private WebElement  directorySent;

  public void clickNewLetter() {
    newLetterButton.click();
  }

  public void sendEmail(String recipientEmail, String emailSubject, String emailText, String attachmentFile) {
    typeInto(fieldTo, recipientEmail);
    typeInto(fieldSubject, emailSubject);
    //раскомментировать если будет нужно вставлять текст письма
/*  getDriver().switchTo().frame(iframeEditor);
    typeInto(fieldText, emailText);
    getDriver().switchTo().defaultContent();*/
    File file = new File("src/test/resources/data/" + attachmentFile);
    getDriver().findElement(By.cssSelector("[name='Filedata']")).sendKeys(file.getAbsolutePath());
    getDriver().findElement(By.xpath("//div[@data-shortcut='ctrl+enter|command+enter']")).click();

  }

  public void openSentPage() {
    directorySent.click();
  }
}

//data-shortcut="g,s"
// <div class="message-sent__title">
//<span class="message-sent__info">v.zhichkin &lt;v.zhichkin@ya.ru&gt;</span>