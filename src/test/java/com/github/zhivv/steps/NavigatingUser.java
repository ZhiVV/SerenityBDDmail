package com.github.zhivv.steps;

import com.github.zhivv.model.Category;
import com.github.zhivv.ui.CategoryNavigationBar;
import com.github.zhivv.ui.CurrentPage;
import com.github.zhivv.ui.EbayHomePage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertThat;

//import static org.assertj.core.api.Assertions.assertThat;

public class NavigatingUser {

  EbayHomePage ebayHomePage;
  CurrentPage currentPage;
  CategoryNavigationBar categoryNavigationBar;

  @Step
  public void isOnTheHomePage() {
    ebayHomePage.open();
  }

  @Step
  public void shouldSeepageTitleContaining(String expectedTitle) {

    //assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);

  }

  @Step
  public void navigatesToCategory(Category category) {
    categoryNavigationBar.selectCategory(category);
  }
}
