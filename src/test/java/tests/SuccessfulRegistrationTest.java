package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SuccessfulRegistrationTest extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Lock");
        $("[id=userEmail]").setValue("test@test.com");
        $("[id=genterWrapper]").$(byText("Male")).click();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("John Lock"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8911449492"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("16 October,2026"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("first address 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

    }
    @Test
    void successfulRegistrationWithOnlyRequiredFields() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Lock");
        $("[id=userEmail]").setValue("test@test.com");
        $("[id=genterWrapper]").$(byText("Male")).click();
        $("[id=userNumber]").setValue("8911449492");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__day.react-datepicker__day--016").click();
        $("[id=submit]").scrollTo().click();


        $(".modal-content").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("John Lock"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8911449492"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("16 October,2026"));

    }
}
