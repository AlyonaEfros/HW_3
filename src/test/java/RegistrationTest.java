import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        $("#firstName").setValue("Alyona");
        $("#lastName").setValue("Efros");
        $("#userEmail").setValue("Alyona@F.ru");
        $("#userNumber").setValue("3478585434");
        $("#genterWrapper").$("[for='gender-radio-3']").click();
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").$("[value='5']").click();
        $(".react-datepicker__year-dropdown-container").$("[value='1999']").click();
        $(".react-datepicker__day.react-datepicker__day--029").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("pictures/cat.jpg");
        $("#currentAddress").setValue("my address");
        $("#state").click();
        $("#stateCity-wrapper").$("#react-select-3-option-2").click();
        $("#city").click();
        $("#stateCity-wrapper").$("#react-select-4-option-1").click();
        $("#submit").click();

        $(".modal-content").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alyona"));
        $(".modal-body").shouldHave(text("Alyona@F.ru"));
        $(".modal-body").shouldHave(text("Other"));
        $(".modal-body").shouldHave(text("3478585434"));
        $(".modal-body").shouldHave(text("29 June,1999"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Reading"));

    }

}