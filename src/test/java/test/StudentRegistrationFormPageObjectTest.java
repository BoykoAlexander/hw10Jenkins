package test;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class StudentRegistrationFormPageObjectTest extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  void fillFormTest() {
    //filling out the form
    registrationPage.openPage()
            .inputFirstName("Alex")
            .inputLastName("Boyko")
            .inputEmeil("boyko@yandex.ru")
            .putGender("Male") //Female | Male | Other
            .inputPhoneNumber("9999999999");
    registrationPage.calendarComponent.setDate();
    registrationPage.inputSubjects("English")
            .selectHobbies("Music")
            //.uploadFileFromForm("driver.jpg")
            .inputCurrentAdress("South Park")
            .selectStateInCheckbox("Uttar Pradesh")
            .selectCityInCheckbox("Merrut")
            .clickButtonSubmit();

    //Check assertion
    registrationPage.checkResultTable("Student Name", "Alex Boyko")
            .checkResultTable("Student Email", "boyko@yandex.ru")
            .checkResultTable("Gender", "Male")
            .checkResultTable("Mobile", "9999999999")
            .checkResultTable("Date of Birth", "23 May,1994")
            .checkResultTable("Subjects", "English")
            .checkResultTable("Hobbies", "Music")
            //.checkResultTable("Picture", "driver.jpg")
            .checkResultTable("Address", "South Park")
            .checkResultTable("State and City", "Uttar Pradesh Merrut");
  }
}
