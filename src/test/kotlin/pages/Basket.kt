package pages

import TestBase
import com.codeborne.selenide.Condition.appear
import org.openqa.selenium.By
import java.time.Duration.ofSeconds

class Basket : TestBase() {

    //Заголовок карточки товара
    val textProductCard
        get() = getElement(By.xpath("//div[@class='inventory_details_name large_size']"))

    // Цена в карточке товара
    val priceProductCard
        get() = getElement(By.xpath("//div[@class='inventory_details_price']"))
}