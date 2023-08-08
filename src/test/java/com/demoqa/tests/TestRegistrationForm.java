package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @AfterEach
    void afterAll() {
        Selenide.closeWebDriver();
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //removes banners and footers
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Kate");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("katesmith@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9212313427");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue("A").pressEnter();
        $("#subjectsInput").setValue("B").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        //upload image
        //$("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        $("#uploadPicture").uploadFromClasspath("cat.jpg");

        $("#currentAddress").setValue("Elm street, 10").pressEnter();
        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        //submitted form
        $(".table-responsive").
                $("tbody").shouldHave(text("Kate Smith"),
                        text("katesmith@gmail.com"),
                        text("Female"),
                        text("9212313427"),
                        text("16 October,1990"),
                        text("Maths, Biology"),
                        text("Reading"),
                        text("cat.jpg"),
                        text("Elm street, 10"),
                        text("Rajasthan Jaipur")
                );
        $("#closeLargeModal").scrollIntoView(true).click();

    }
}