package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#userName").setValue("Mary Smith");
        $("#userEmail").setValue("smith@testtest.com");
        $("#currentAddress").setValue("Apple street 11");
        $("#permanentAddress").setValue("Elm street 12");
        $("#submit").click();

        // $("#output").$("#name").shouldHave(text("Mary Smith"));
        $("#output #name").shouldHave(text("Mary Smith"));
        $("#output #email").shouldHave(text("smith@testtest.com"));
        $("#output #currentAddress").shouldHave(text("Apple street 11"));
        $("#output #permanentAddress").shouldHave(text("Elm street 12"));

    }
}
