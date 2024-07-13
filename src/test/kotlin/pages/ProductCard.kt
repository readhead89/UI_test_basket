package pages

import TestBase
import com.codeborne.selenide.Condition.appear
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By
import java.time.Duration.ofSeconds
import java.util.Scanner

class ProductCard : TestBase() {

    // Карточка товара
    private val productCard
        get() = getElement(By.xpath("//div[@class='inventory_item_name ']"))
            .shouldBe(appear, ofSeconds(3))

    // Кнопка Добавить в корзину
    private val addToCart
        get() = getElement(By.xpath("//button[@id='add-to-cart']"))
           // .shouldBe(appear, ofSeconds(3))

    // Кнопка перейти в корзину
    private val openBasket
        get() = getElement(By.xpath("//div[@id='shopping_cart_container']"))
            .shouldBe(appear, ofSeconds(3))

    // Заголовок карточки товара
    private val textProductCard
        get() = getElement(By.xpath("//div[@class='inventory_item_name ']"))

    // Цена на карточке товара
    private val priceProductCard
        get() = getElement(By.xpath("//div[@class='inventory_item_price']"))

    // Все карточки товара
    private val allCard
        get() = getElements(By.xpath("//div[@class='inventory_item_name ']"))

    @Step("Открыть карточку товара")
    fun openProductCard() {
        productCard.click()
    }

    @Step("Добавить товар в корзину")
    fun addGoodsInBasket() {
        addToCart.click()
    }

    @Step("Открыть корзину товаров")
    fun openBasket() {
        openBasket.click()
    }

    @Step("Проверить то, что открывалась именно та карточка, которую выбрали по заголовку")
    fun checkOpenCardText() {
        Assertions.assertEquals(textProductCard, Basket().textProductCard)
    }

    @Step("Проверить то, что открывалась именно та карточка, которую выбрали по цене")
    fun checkOpenCardPrice() {
        Assertions.assertEquals(priceProductCard, Basket().priceProductCard)
    }
}

