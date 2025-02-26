package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public void login(String username, String password) {
        WebElement emailLoginInput = driver.findElement(By.name("username"));
        emailLoginInput.click();
        emailLoginInput.sendKeys(username);

        WebElement passLoginInput = driver.findElement(By.xpath("//*[@name='password'][@placeholder='Пароль']"));
        passLoginInput.click();
        passLoginInput.sendKeys(password);
        passLoginInput.submit();


    }
    public void waitMenuAppearence(int timeOut){
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-main-page\"]/div/div[2]/div/a[1]")));
    }
}