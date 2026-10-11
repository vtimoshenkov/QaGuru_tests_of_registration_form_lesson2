package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuccessfulRegistrationWithOnlyRequiredFields extends TestBase {

    @AfterEach
            void closemodal() {
        $("#closeLargeModal").click();
    }
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Lock");
        $("[id=userEmail]").setValue("test@test.com");
        $(byText("Male")).click();
        $("[id=userNumber]").setValue("8911449492");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__day.react-datepicker__day--016").click();
        $("[id=submit]").click();


        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Student Name " + "John Lock"));
        $(".table-responsive").shouldHave(text("Student Email " + "test@test.com"));
        $(".table-responsive").shouldHave(text("Gender " + "Male"));
        $(".table-responsive").shouldHave(text("Mobile " + "8911449492"));
        $(".table-responsive").shouldHave(text("Date of Birth " + "16 October,2026"));

    }
}
