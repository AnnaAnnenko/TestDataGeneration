package qa.annenko.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import qa.annenko.pages.PracticeFormPages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestForPracticeFormWithTestData extends TestBase {

    PracticeFormPages practiceFormPages = new PracticeFormPages();

    @Test
    public void checkFieldsOfForm() {
        practiceFormPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(day, month, year)
                .setSubjectInput(subject)
                .setHobbieInput(hobbie)
                .uploadPicture(picture)
                .setCurrentAddressInput(address)
                .setStateInput(state).setCityInput(city)
                .clickSubmit();
// Проверяем результат
        practiceFormPages.checkTableVisible()
                .checkRegistrationTable("Student Name", firstName + " " + lastName)
                .checkRegistrationTable("Student Email", email)
                .checkRegistrationTable("Gender", gender)
                .checkRegistrationTable("Mobile", phone)
                .checkRegistrationTable("Subjects", subject)
                .checkRegistrationTable("Address", address)
                .checkRegistrationTable("Picture", picture)
                .checkRegistrationTable("Hobbies", hobbie)
                .checkRegistrationTable("Date of Birth", day + " " + month + "," + year)
                .checkRegistrationTable("State and City", state + " " + city);
    }
}