package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuccessfulRegistrationTest extends TestBase {

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
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $(byText("Music")).click();

        $("[id=uploadPicture]").uploadFromClasspath("image.png");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=state] input").setValue("NCR").pressEnter();
        $("[id=city] input").setValue("Delhi").pressEnter();
        $("[id=submit]").click();


        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Student Name " + "John Lock"));
        $(".table-responsive").shouldHave(text("Student Email " + "test@test.com"));
        $(".table-responsive").shouldHave(text("Gender " + "Male"));
        $(".table-responsive").shouldHave(text("Mobile " + "8911449492"));
        $(".table-responsive").shouldHave(text("Date of Birth " + "16 October,2026"));
        $(".table-responsive").shouldHave(text("Subjects " + "Maths"));
        $(".table-responsive").shouldHave(text("Hobbies " + "Music"));
        $(".table-responsive").shouldHave(text("Picture " + "image.png"));
        $(".table-responsive").shouldHave(text("Address " + "first address 1"));
        $(".table-responsive").shouldHave(text("State and City " + "NCR Delhi"));

    }
}
