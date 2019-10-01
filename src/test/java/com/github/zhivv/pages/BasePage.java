package com.github.zhivv.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject {

  public BasePage(WebDriver driver) {
    super(driver);
  }

  public BasePage() {
    super();
  }

}
