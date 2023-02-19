package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillUserDataTest extends TestBase {
    Faker faker = new Faker();
    String userName = faker.name().firstName(),
            userSurname = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = "Female",
            userPhone = faker.phoneNumber().subscriberNumber(10),
            userBirthday = "04",
            userBirthMonth = "November",
            userBirthYear = "1984",
            subject = "Maths",
            hobbies = "Sports",
            picture = "batman.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    @Test
    @Tag("smoke")
    @Owner("nfrolova")
    @DisplayName("Заполнение формы регистрации студента и верификация данных")
      void successfulFillUserDataTest() {
        RegistrationPage steps = new RegistrationPage();

        steps.openPage();
        steps.setFirstName(userName);
        steps.setLastName(userSurname);
        steps.setEmail(userEmail);
        steps.setGender(userGender);
        steps.setPhone(userPhone);
        steps.setBirthDate(userBirthday, userBirthMonth, userBirthYear);
        steps.subjectsInput(subject);
        steps.hobbiesInput(hobbies);
        steps.uploadPicture(picture);
        steps.setCurrentAddress(currentAddress);
        steps.chooseState(state);
        steps.chooseCity(city);
        steps.pressSubmit();

        steps.verifyResultsModalAppears();
        steps.verifyResults("Student Name", userName + " " + userSurname);
        steps.verifyResults("Student Email", userEmail);
        steps.verifyResults("Gender", userGender);
        steps.verifyResults("Mobile", userPhone);
        steps.verifyResults("Date of Birth", userBirthday + " " + userBirthMonth + "," + userBirthYear);
        steps.verifyResults("Subjects", subject);
        steps.verifyResults("Hobbies", hobbies);
        steps.verifyResults("Picture", picture);
        steps.verifyResults("Address", currentAddress);
        steps.verifyResults("State and City", state + " " + city);

    }
}
