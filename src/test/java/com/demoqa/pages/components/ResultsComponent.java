package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsComponent {
    SelenideElement resultsTable = $(".table-responsive").$("tbody"),
            closeButton = $("#closeLargeModal");

    public void checkResults(String name, String email, String gender,
                             String number, String birthDate, String subject,
                             String hobby, String imageName, String address,
                             String stateCity) {
        resultsTable.shouldHave(text(name),
                text(email),
                text(gender),
                text(number),
                text(birthDate),
                text(subject),
                text(hobby),
                text(imageName),
                text(address),
                text(stateCity)
        );
        closeButton.scrollIntoView(true).click();
    }
}
