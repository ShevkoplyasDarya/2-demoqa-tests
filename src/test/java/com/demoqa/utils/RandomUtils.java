package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {

    public static String
            firstName = getRandomFirstName(),
    //firstName = getFunnyFirstName(),
    //firstName = getHPName(),
    lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            phoneNumber = getRandomPhone(),
            currentAddress = getRandomAddress(),
            gender = getRandomGender(),
            month = getRandomMonth(),
            year = getRandomYear(),
            hobby = getRandomHobby(),
            subject = getRandomSubject(),
            state = getRandomState(),
            city = getRandomCity(state),
            image = "cat.jpg";
    public static int day = getRandomDay();

    Faker faker = new Faker(new Locale("EN"));

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getFunnyFirstName() {
        return new Faker().funnyName().name();
    }

    public static String getHPName() {
        return new Faker().harryPotter().character();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomPhone() {
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getRandomAddress() {

        return new Faker().address().fullAddress();
    }

    public static int getRandomDay() {
        return new Faker().number().numberBetween(10, 28);
    }

    public static String getRandomGender() {
        String[] genders = {"Female", "Male", "Other"};
        return new Faker().options().option(genders);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return new Faker().options().option(months);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Economics", "English", "Commerce", "Computer Science", "Physics",
                "Maths", "Hindi", "History", "Social Studies"};
        return new Faker().options().option(subjects);
    }

    public static String getRandomState() {
        String[] states = {"Rajasthan", "NCR", "Uttar Pradesh", "Haryana"};
        return new Faker().options().option(states);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana": {
                String[] city = {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan": {
                String[] city = {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }
        }
        return null;
    }

    public static String getRandomYear() {
        return new Faker().random().nextInt(1900, 2023).toString();
    }

}
