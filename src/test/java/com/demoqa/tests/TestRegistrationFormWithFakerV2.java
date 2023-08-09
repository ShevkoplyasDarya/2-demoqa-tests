package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;


public class TestRegistrationFormWithFakerV2 extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setSHobby(hobby)
                .uploadImage(image)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .checkResults(firstName,
                        lastName,
                        userEmail,
                        gender,
                        phoneNumber,
                        day,
                        month,
                        year,
                        subject,
                        hobby,
                        image,
                        currentAddress,
                        state,
                        city);

    }
}