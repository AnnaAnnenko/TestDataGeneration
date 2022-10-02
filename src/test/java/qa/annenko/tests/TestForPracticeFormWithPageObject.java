package qa.annenko.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.annenko.pages.PracticeFormPages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

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
                .setDateOfBirth("15", "October", "2009")
                .setSubjectInput("History")
                .setHobbieInput("Reading")
                .uploadPicture("Img/1.png")
                .setCurrentAddressInput("Test Current Address")
                .setStateInput("NCR").setCityInput("Delhi")
                .clickSubmit();
// Проверяем результат
        practiceFormPages.checkTableVisible()
                .checkRegistrationTable("Student Name", "Anna Abramova")
                .checkRegistrationTable("Student Email", "abramova@test.ru")
                .checkRegistrationTable("Gender", "Female")
                .checkRegistrationTable("Mobile", "9222365736")
                .checkRegistrationTable("Subjects", "History")
                .checkRegistrationTable("Address", "Test Current Address")
                .checkRegistrationTable("Picture", "1.png")
                .checkRegistrationTable("Hobbies", "Reading")
                .checkRegistrationTable("Date of Birth", "15 October,2009")
                .checkRegistrationTable("State and City", "NCR Delhi");
    }
}