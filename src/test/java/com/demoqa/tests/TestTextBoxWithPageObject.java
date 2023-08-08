package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import com.demoqa.pages.TextBoxPage;

public class TestTextBoxWithPageObject extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setName("Mary Smith")
                .setEmail("smith@testtest.com")
                .setCurrentAddress("Apple street 11")
                .setPermanentAddress("Elm street 12")
                .clickSubmit()
                .checkOutput("Mary Smith",
                        "smith@testtest.com",
                        "Apple street 11",
                        "Elm street 12");

    }
}
