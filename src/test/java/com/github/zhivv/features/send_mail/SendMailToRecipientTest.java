package com.github.zhivv.features.send_mail;

import com.github.zhivv.steps.SenderSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/data/dataset.csv", separator=';')
public class SendMailToRecipientTest {

    private String userLogin;
    private String userPassword;
    private String recipientEmail;
    private String emailSubject;
    private String emailText;
    private String attachmentFile;

    public void setUserLogin(String userLogin){
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    @Managed(uniqueSession=true)
    WebDriver driver;

    @Steps
    SenderSteps mark;

    @Test
    public void send_email() throws Exception {
        // GIVEN
        mark.opens_home_page();
        mark.enter_login(userLogin);
        mark.enter_password(userPassword);

        // WHEN
        mark.create_letter(recipientEmail);

        // THEN
        mark.should_see_the_letter_sent();
        mark.should_see_the_letter_in_the_sent_folder();
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public void setAttachmentFile(String attachmentFile) {
        this.attachmentFile = attachmentFile;
    }
}

