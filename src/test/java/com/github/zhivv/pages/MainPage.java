package com.github.zhivv.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class MainPage extends BasePage {

  @FindBy(css = "[data-shortcut='n']")
  WebElementFacade newLetterButton;

  @FindBy(xpath = "//textarea[@data-original-name='To']")
  WebElement fieldTo;

  @FindBy(name = "Subject")
  WebElement fieldSubject;

  @FindBy(xpath = "//iframe[contains(@id, 'composeEditor_ifr')]")
  WebElement iframeEditor;

  @FindBy(id = "tinymce")
  WebElement fieldText;

  public void clickNewLetter() {
    newLetterButton.click();
  }

  public void sendEmail(String recipientEmail) {
    fieldTo.clear();
    fieldTo.sendKeys(recipientEmail);
    fieldSubject.clear();
    fieldSubject.sendKeys("test letter");
    //TODO: написать  кликалку по поп-ап "Вы уверены что отправляете пустое письмо, затем код с телом письма закомментировать
    getDriver().switchTo().frame(iframeEditor);
    fieldText.clear();
    fieldText.sendKeys("Hello, world!");
    getDriver().switchTo().defaultContent();
    File file = new File("src/test/resources/data/attach.png");
    getDriver().findElement(By.cssSelector("[name='Filedata']")).sendKeys(file.getAbsolutePath());
    getDriver().findElement(By.xpath("//div[@data-shortcut='ctrl+enter|command+enter']")).click();
  }

  public void openSentPage() {
  }
}

//data-shortcut="g,s"
// <div class="message-sent__title">
//<span class="message-sent__info">v.zhichkin &lt;v.zhichkin@ya.ru&gt;</span>