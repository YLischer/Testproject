import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.CartPage;
import org.pages.LoginPage;
import org.pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;

public class KomusTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito"); // Открываем Хром в режиме инкогнито
        options.addArguments("start-maximized");  // Открываем браузер в полноэкранном режиме

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS); // Ждем до 3 секунд пока элементы будут найдены
        driver.get("https://stage.komus.net/login"); // Переходим на страницу входа

        // Логинимся
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("necrolordix@mail.ru", "119270As");
        // Задержка 5 секунд перед добавлением товара в корзину
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при ожидании: " + e.getMessage());
        }
        // Поиск и добавление товаров
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.searchAndAddFurniture();
        searchResultsPage.searchAndAddWater();

        // Оформление заказа
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // Закрытие браузера
        // driver.quit();
    }
}