package qa.annenko.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import qa.annenko.utils.Randoms;

public class TestBase {
    Faker faker = new Faker();
    Randoms randoms = new Randoms();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10,30)),
            month = String.valueOf(randoms.getRandomMonth()),
            year = String.valueOf(faker.number().numberBetween(1990,2022)),
            subject = "History",
            hobbie = "Reading",
            picture = "1.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x680";
        Configuration.holdBrowserOpen = true;
    }
}
