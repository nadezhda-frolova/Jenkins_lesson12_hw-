package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress");


    @Step("Открываем форму регистрации студента")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("заполняем поле Имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("заполняем поле Фамилия")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("заполняем поле Почта")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    @Step("выбираем пол")
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }
    @Step("заполняем поле Телефон")
    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }
    @Step("заполняем поле Дата Рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    @Step("переходим на заполненную форму регистрации")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    @Step("верифицируем данные в заполненной форме регистрации")
    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResults(key, value);

        return this;
    }
    @Step("выбираем предмет")
    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    @Step("выбираем хобби из предложенного списка")
    public RegistrationPage hobbiesInput(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    @Step("загружаем файл")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    @Step("указываем текущий адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    @Step("выбираем штат из выпадающего списка")
    public RegistrationPage chooseState(String value) {
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText(value)).click();
        return this;
    }
    @Step("выбираем город из выпадающего списка")
    public RegistrationPage chooseCity(String value) {
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText(value)).click();
        return this;
    }
    @Step("нажимаем кнопку Submit")
    public RegistrationPage pressSubmit() {
        $("#submit").click();

        return this;
    }

}
