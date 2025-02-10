package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void proceedToCheckout() {
        try {
            WebElement targetButtonGoToCart = driver.findElement(By.cssSelector("[href='/cart/?from=top']"));
            Thread.sleep(9000); // Пауза на 9 секунд для загрузки страницы корзины
            targetButtonGoToCart.click();

            // Ожидание появления первой кнопки продолжения
            WebElement checkoutFirstStepButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".v-button__control--primary[data-v-f4e85be2='']")));
            checkoutFirstStepButton.click();

            // Ожидание появления второй кнопки продолжения
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Продолжить']")));
            continueButton.click();

            // Ожидание появления выбора адреса
            WebElement addressSelectionButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".radio__title--static.radio__title--white-space-normal")));
            addressSelectionButton.click();

            // Продолжение после выбора адреса
            WebElement continueFirstButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Продолжить']")));
            continueFirstButton.click();

            // Выбор способа оплаты
            WebElement paymentMethodButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"paymentForm\"]/div/div[3]/div/div[3]/label")));
            paymentMethodButton.click();

            // Продолжение после выбора способа оплаты
            WebElement continueSecondButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Продолжить']")));
            continueSecondButton.click();

            // Выбираем рандомную дату доставки
            List<WebElement> selectElementDayDelivery = driver.findElements(By.cssSelector("[class$='day']"));
            int countDayDelivery = selectElementDayDelivery.size();
            Random rnd = new Random(); // Создаем объект класса Random
            int randomindex5 = rnd.nextInt(0, countDayDelivery);
            selectElementDayDelivery.get(randomindex5).click();

            // Отказ от сборки мебели
            WebElement furnitureAssemblyRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"deliveryProperties\"]/div[3]/span/div/div/div[2]/div[1]/div[2]/label")));
            furnitureAssemblyRadioButton.click();

            // Продолжение после отказа от сборки мебели
            WebElement fifthStepContinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"deliveryProperties\"]/div[3]/div[3]/button[2]")));
            fifthStepContinueButton.click();

            // Завершение оформления заказа
            WebElement finalStepContinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-subHeader\"]/div[3]/div/div/form/div/div[8]/button[2]")));
            finalStepContinueButton.click();
        } catch (Exception e) {
            System.out.println("Ошибка при оформлении заказа: " + e.getMessage());
        }
    }
}