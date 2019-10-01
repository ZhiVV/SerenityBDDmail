package com.github.zhivv.features.send_mail;

import com.github.zhivv.steps.SenderSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SendMailToRecipientTest {

    @Managed(uniqueSession=true)
    WebDriver driver;

    @Steps
    SenderSteps mark;

    @Test
    public void send_email() throws Exception {
        // GIVEN
        mark.opens_home_page();
        mark.enter_login("@mail.ru");
        mark.enter_password("test");

        // WHEN
//        ListingItem selectedItem = mark.selects_listing(2);
//        mark.adds_current_listing_to_cart();

        // THEN
//        mark.should_see_item_in_cart(selectedItem);
//        mark.should_see_total_including_shipping_for(selectedItem);
    }
}

