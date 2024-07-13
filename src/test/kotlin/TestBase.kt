import com.codeborne.selenide.Browsers.EDGE
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.impl.CollectionSource
import constants.Login
import constants.Password
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.Authorization
import java.time.Duration


open class TestBase {

    fun openLoginPage() {
        Configuration.browser = EDGE
        open("https://www.saucedemo.com/")
        webdriver().driver().webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10))
    }

    fun authUser() {
        Step("Открыть главную страницу")
        openLoginPage()

        Step("Ввести имя пользователя")
        Authorization().enterUserName(Login.standard_user.name)

        Step("Ввести пароль")
        Authorization().enterPassword(Password.secret_sauce.name)

        Step("Клик Login")
        Authorization().clickLogin()
    }

    fun getElement(selector: By): SelenideElement = `$`(selector)
    fun getElements(selector: By.ByXPath): ElementsCollection = `$$`(selector)
    fun getElements(selector: By): ElementsCollection = `$$`(selector)

}