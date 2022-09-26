package qa.annenko.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import qa.annenko.pages.PracticeFormPages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestForPracticeFormWithPageObject {

    PracticeFormPages practiceFormPages = new PracticeFormPages();

    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x680";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void checkFieldsOfForm() {
        practiceFormPages.openPage()
                .setFirstName("Anna")
                .setLastName("Abramova")
                .setEmail("abramova@test.ru")
                .setGender("Female")
                .setUserNumber("9222365736")
                .setDateOfBirth("15", "October", "2009");

        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Img/1.png");
        $("#currentAddress").setValue("Test Current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
// Проверяем результат
        practiceFormPages.checkTableVisible()
                .checkRegistrationTable("test", "Anna Abramova");
        $(".modal-dialog").should(appear);
        $(".table-responsive").shouldHave(text("Anna Abramova"), text("abramova@test.ru"), text("Female"), text("9222365736"),
                text("History"), text("Test Current Address"), text("1.png"), text("Reading"), text("15 October,2009"), text("NCR Delhi"));
    }
}