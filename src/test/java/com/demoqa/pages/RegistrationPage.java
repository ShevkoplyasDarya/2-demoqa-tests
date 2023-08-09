package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    //elements of the page
    CalendarComponent calendar = new CalendarComponent();
    ResultsComponent result = new ResultsComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropdown = $("#stateCity-wrapper").$(byText("Select State")),
            stateNameSelector = $("#stateCity-wrapper"),
            cityDropdown = $("#stateCity-wrapper").$(byText("Select City")),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        emailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setBirthDate(int day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setSHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage uploadImage(String image) {
        pictureInput.uploadFromClasspath(image);

        return this;
    }

    public RegistrationPage setAddress(String currentAddress) {
        addressInput.setValue(currentAddress).pressEnter();

        return this;
    }

    public RegistrationPage setState(String state) {
        stateDropdown.scrollIntoView(true).click();
        stateNameSelector.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityDropdown.scrollIntoView(true).click();
        stateNameSelector.$(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResults(String firstName, String lastName, String email, String gender,
                                         String number, int day, String month, String year,  String subject, String hobby,
                                         String imageName, String address, String state, String city)
    {
        result.checkResults(firstName, lastName, email, gender,
                number, day, month, year,  subject, hobby,
                imageName, address, state, city);

        return this;
    }


}
