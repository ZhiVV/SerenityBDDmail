package com.github.zhivv.ui;

import com.github.zhivv.model.Category;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;

public class CategoryNavigationBar extends PageObject {
  public void selectCategory(Category category) {
    $("#gh-eb-Geo").click();
    $("#gh-eb-Geo-a-en").click();
    $("[data-hover-track=\"p2481888.m1382.l6435\"]").find(By.linkText(category.name())).click();

  }
}
