package com.github.zhivv.features.navigation;

import com.github.zhivv.model.Category;
import com.github.zhivv.steps.NavigatingUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenBrowsingProductCategories {

  @Steps
  NavigatingUser mark;

  @Managed
  WebDriver browser;

  @Test
  public void shouldBeAbleToNavigateToTheMotorsCategory() {
    // Given
    mark.isOnTheHomePage();

    // When
    mark.navigatesToCategory(Category.Motors);

    // Then
    mark.shouldSeepageTitleContaining("New & used cars");
  }
}
