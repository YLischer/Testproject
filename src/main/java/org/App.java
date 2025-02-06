/*package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

import java.util.concurrent.TimeUnit;
import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito"); //открываем хром в инкогнито
        //options.addArguments("--headless");
        options.addArguments("start-maximized");  //открывваем браузер в полном окне

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Ждем до 10 сек пока элементы будут найдены
        driver.get("https://stage.komus.net//login"); //куда логинимся
        WebElement emailLoginInput = driver.findElement(By.name("username"));
        emailLoginInput.click();
        emailLoginInput.sendKeys("necrolordix@mail.ru");
        WebElement passLoginInput = driver.findElement(By.xpath("//*[@name='password'][@placeholder='Пароль']"));
        passLoginInput.click();
        passLoginInput.sendKeys("119270As");
        passLoginInput.submit(); //после логина и пароля авториховываемся
        Thread.sleep(1000); // Пауза на 1 секунду
        String s = ".v-input-search--default input"; // Добавляем уточнение, что ищем именно input внутри блока
        WebElement searchInputFurniture = driver.findElement(By.cssSelector(s)); // Используем переменную s
        searchInputFurniture.clear(); // Очищаем поле перед вводом данных
        searchInputFurniture.sendKeys("Шкаф");
        searchInputFurniture.submit(); //ищем мебель
        Thread.sleep(3000); // Пауза на 3 секунды для загрузки страницы результатов поиска
        WebElement targetButtonFurniture = driver.findElement(By.cssSelector(".product-price__button--without-margin-right[data-subdivisioncode='Т127']"));
        targetButtonFurniture.click(); // Добавляем мебельв  корзину
        Thread.sleep(1000); // Пауза на 1 секунду
        String s1 = ".v-input-search--default input"; // Добавляем уточнение, что ищем именно input внутри блока
        WebElement searchInputWater = driver.findElement(By.cssSelector(s1)); // Используем переменную s
        searchInputWater.clear(); // Очищаем поле перед вводом данных
        searchInputWater.sendKeys("Вода 19л");
        searchInputWater.submit(); //изем воду
        Thread.sleep(3000); // Пауза на 3 секунды для загрузки страницы результатов поиска
        WebElement targetButtonWater = driver.findElement(By.cssSelector(".product-price__button--without-margin-right[data-subdivisioncode='Т42']"));
        targetButtonWater.click(); // Добавляем воду в корзину
        WebElement targetButtonGoToCart = driver.findElement(By.cssSelector("[href='/cart/?from=top']"));
        Thread.sleep(3000); // Пауза на 3 секунды для загрузки страницы корзины
        targetButtonGoToCart.click();
        WebElement targetButtonGoToCheckoutfirststep = driver.findElement(By.cssSelector(".v-button__control--primary[data-v-f4e85be2='']"));
        targetButtonGoToCheckoutfirststep.click();
        WebElement targetButtonGoToCheckoutsecondstep = driver.findElement(By.cssSelector("[value='Продолжить']"));
        targetButtonGoToCheckoutsecondstep.click();
        WebElement targetButtonAdress = driver.findElement(By.cssSelector(".radio__title--static.radio__title--white-space-normal"));
        targetButtonAdress.click(); //выбирает конкретный адрес доставки(при перезагрузке стенда выделение с адреса убирается)
        WebElement targetButtonGoToCheckoutthirdstep = driver.findElement(By.cssSelector("[value='Продолжить']"));
        targetButtonGoToCheckoutthirdstep.click();
        WebElement targetButtonpaymentsmathod = driver.findElement(By.xpath("//*[@id=\"paymentForm\"]/div/div[3]/div/div[3]/label"));
        targetButtonpaymentsmathod.click();//выбираем тип оплаты наличными
        WebElement targetButtonGoToCheckoutfourthstep = driver.findElement(By.cssSelector("[value='Продолжить']"));
        targetButtonGoToCheckoutfourthstep.click();
        Thread.sleep(7000);
        // Выбираем рандомную дату доставки
        List<WebElement> selectElementDayDelivery = driver.findElements(By.cssSelector("[class$='day']"));
        int countDayDelivery = selectElementDayDelivery.size();
        Random rnd = new Random(); // Создаем объект класса Random
        int randomindex5 = rnd.nextInt(0, countDayDelivery);
        selectElementDayDelivery.get(randomindex5).click();
        WebElement targetButtonradiofurniture = driver.findElement(By.xpath("//*[@id=\"deliveryProperties\"]/div[3]/span/div/div/div[2]/div[1]/div[2]/label"));
        targetButtonradiofurniture.click(); //отказывваемся от сборки мебели
        WebElement targetButtonGoToCheckoutfifthstep = driver.findElement(By.xpath("//*[@id=\"deliveryProperties\"]/div[3]/div[3]/button[2]"));
        targetButtonGoToCheckoutfifthstep.click();
        WebElement targetButtonGoToCheckoutfinalstep = driver.findElement(By.xpath("//*[@id=\"top-subHeader\"]/div[3]/div/div/form/div/div[8]/button[2]"));
        targetButtonGoToCheckoutfinalstep.click();
        //driver.quit();//закрываем браузер
    }
}*/