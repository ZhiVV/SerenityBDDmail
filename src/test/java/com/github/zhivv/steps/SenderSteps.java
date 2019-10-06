package com.github.zhivv.steps;

import com.github.zhivv.pages.HomePage;
import com.github.zhivv.pages.MainPage;
import com.github.zhivv.pages.SentLettersPage;
import com.github.zhivv.pages.SentPage;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class SenderSteps {

    private HomePage homePage;
    private MainPage mainPage;
    private SentPage sentPage;
    private SentLettersPage sentLettersPage;

    @Step("Открывает в браузере начальную страницу Mail.ru")
    public void opens_home_page() {
        homePage.open();
    }

    @Step("Вводит логин")
    public void enter_login(String login) {
        homePage.enterLogin(login);
        homePage.clickNext();
    }

    @Step("Вводит пароль")
    public void enter_password(String password) {
        homePage.enterPass(password);
        homePage.clickEnter();
    }

    @Step("Отправляет новое письмо")
    public void create_letter(String recipientEmail, String emailSubject, String emailText, String attachmentFile) {
        mainPage.clickNewLetter();
        mainPage.sendEmail(recipientEmail, emailSubject, emailText, attachmentFile);
    }

//    @Step("Проверяет что письмо отправлено")
//    public void should_see_the_letter_sent() {
//        sentLettersPage.checkMessage();
//    }

    @Step("Проверяет что письмо есть в папке Отправленные")
    public void should_see_the_letter_in_the_sent_folder(String recipientEmail, String emailSubject, String attachmentFile) {
        mainPage.openSentPage();
        assertThat(sentLettersPage.checkFirstMessageAddress()).isEqualTo(recipientEmail);
        assertThat(sentLettersPage.checkFirstMessageSubject()).contains(emailSubject);
    }
}
