package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsComponent {
    SelenideElement resultsTable = $(".table-responsive").$("tbody"),
            closeButton = $("#closeLargeModal");

    public void checkResults(String firstName, String lastName, String email, String gender,
                             String number, int day, String month, String year, String subject,
                             String hobby, String imageName, String address,
                             String state,String city) {
        resultsTable.shouldHave(text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(number),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobby),
                text(imageName),
                text(address),
                text(state + " " + city)
        );
        closeButton.scrollIntoView(true).click();
    }
}
