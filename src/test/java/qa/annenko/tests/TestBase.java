package qa.annenko.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static qa.annenko.utils.RandomUtils.getRandomString;

public class TestBase {

    static String firstName = getRandomString(10),
            lastName = "Abramova",
            email = "abramova@test.ru",
            phone = "9222365736",
            day = "15",
            month = "October",
            year = "2009";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x680";
        Configuration.holdBrowserOpen = true;
    }
}
