package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeRegistrationTests extends TestBase {

    @Test
    void registrationWithoutSurename() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("John");
        $("[id=userEmail]").setValue("test@test.com");
        $("[id=genterWrapper]").$(byText("Male")).click();
        $("[id=userNumber]").setValue("8911449492");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__day.react-datepicker__day--016").click();
        $("[id=submit]").scrollTo().click();

        $(".modal-content").shouldNot(exist);


    }

    @Test
    void registrationWhithEmptyFields() {
        open("/automation-practice-form");
        $("[id=submit]").scrollTo().click();

        $(".modal-content").shouldNot(exist);


    }
    @Test
    void registrationWithoutGender() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Lock");
        $("[id=userEmail]").setValue("test@test.com");
        $("[id=userNumber]").setValue("8911449492");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__day.react-datepicker__day--016").click();
        $("[id=submit]").scrollTo().click();

        $(".modal-content").shouldNot(exist);
    }
}
