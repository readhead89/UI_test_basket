package tests

import constants.Login
import constants.Password
import io.qameta.allure.Epic
import io.qameta.allure.Step
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import pages.Authorization
import pages.ProductCard
import java.util.*

@Epic("Тестирование сайта")
@DisplayName("Карточки товара")
class SwagLabsTest : SwagLabsTestBaseTest() {
    @Test
    @DisplayName("Авторизация пользователем")
    fun testUserLogin() {
        Step("Открыть главную страницу")
        openLoginPage()

        Step("Ввести имя пользователя")
        Authorization().enterUserName(Login.standard_user.name)

        Step("Ввести пароль")
        Authorization().enterPassword(Password.secret_sauce.name)

        Step("Клик Login")
        Authorization().clickLogin()
    }

    @Test
    @DisplayName("Карточка товара")
    fun openCards() {
        Step("Открыть страницу и авторизоваться пользователем")
        openLoginPage()
        authUser()

        Step("Перейти в карточку товара и добавить товар в корзину")
        ProductCard().openProductCard()
        ProductCard().addGoodsInBasket()

        Step("Перейти в корзину")
        ProductCard().openBasket()
    }
}