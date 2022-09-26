package qa.annenko.pages;

import com.codeborne.selenide.SelenideElement;
import qa.annenko.pages.components.CalendarComponent;
import qa.annenko.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPages {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement GenderInput = $("#userEmail");
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();


    public PracticeFormPages openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPages setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages clearFirstName(String value) {
        firstNameInput.clear();

        return this;
    }

    public PracticeFormPages setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPages setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public PracticeFormPages setUserNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public PracticeFormPages setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPages checkRegistrationTable(String key, String value) {
        resultsTableComponent.checkTable(key, value);

        return this;
    }

    public PracticeFormPages checkTableVisible() {
        resultsTableComponent.checkTableVisible();

        return this;
    }
}
