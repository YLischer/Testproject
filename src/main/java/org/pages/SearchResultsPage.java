package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private final WebDriver driver;
    private static WebDriverWait wait = null;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public static void waitWaterAppearence() {

    }

    public static void waitFurnitureAppearence() {

    }

    public static void searchAndAddFurniture() {
        // Ожидание появления поля поиска
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".v-input-search--default input")));

        // Вводим данные
        searchInput.sendKeys("Тумба");
        searchInput.submit();

        // Задержка 5 секунд перед добавлением товара в корзину
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при ожидании: " + e.getMessage());
        }

        // Ожидание добавления товара в корзину
        WebElement furnitureAddButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-price__button--without-margin-right[data-subdivisioncode='Т127']")));
        furnitureAddButton.click();
    }

    public static void waitCartAppearence() {
    }

    public void searchAndAddWater() {
        // Ожидание появления поля поиска
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".v-input-search--default input")));
        searchInput.clear(); // Очищаем поле перед вводом данных
        // Вводим данные
        searchInput.sendKeys("Вода 19л");
        searchInput.submit();

        // Задержка 5 секунд перед добавлением товара в корзину
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при ожидании: " + e.getMessage());
        }

        // Ожидание добавления товара в корзину
        WebElement waterAddButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-price__button--without-margin-right[data-subdivisioncode='Т42']")));
        waterAddButton.click();


    }
    public void waitFurnitureAppearence(int timeOut){
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-price__button--without-margin-right[data-subdivisioncode='Т127']")));
    }
    public void waitWaterAppearence(int timeOut){
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-input-search--default input")));
    }
}