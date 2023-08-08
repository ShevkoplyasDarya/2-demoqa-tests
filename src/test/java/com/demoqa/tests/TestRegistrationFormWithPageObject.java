package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class TestRegistrationFormWithPageObject extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Kate")
                .setLastName("Smith")
                .setEmail("katesmith@gmail.com")
                .setGender("Female")
                .setNumber("9212313427")
                .setBirthDate("16", "October", "1990")
                .setSubject("Maths")
                .setSHobby("Reading")
                .uploadImage("cat.jpg")
                .setAddress("Elm street, 10")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .clickSubmit()
                .checkResults("Kate Smith",
                        "katesmith@gmail.com",
                        "Female",
                        "9212313427",
                        "16 October,1990",
                        "Maths",
                        "Reading",
                        "cat.jpg",
                        "Elm street, 10",
                        "Rajasthan Jaipur");

    }
}