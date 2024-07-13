package pages

import TestBase
import com.codeborne.selenide.Condition.*
import io.qameta.allure.Step
import org.openqa.selenium.By
import java.time.Duration.*

class Authorization : TestBase() {

    // Поле userName
    private val userNameInput
        get() = getElement(By.xpath("//input[@id='user-name']"))
            .shouldBe(appear, ofSeconds(3))

    // Поле Password
    private val password
        get() = getElement(By.xpath("//input[@id='password']"))
            .shouldBe(appear, ofSeconds(3))

    // Поле Login
    private val login
        get() = getElement(By.xpath("//input[@id='login-button']"))
            .shouldBe(appear, ofSeconds(3))

    @Step("Ввести логин")
    fun enterUserName(userName: String) {
        userNameInput.setValue(userName)
    }

    @Step("Ввести пароль")
    fun enterPassword(userPassword: String) {
        password.setValue(userPassword)
    }

    @Step("Клик логин")
    fun clickLogin() {
        login.click()
    }
}