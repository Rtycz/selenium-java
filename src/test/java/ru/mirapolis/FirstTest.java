package ru.mirapolis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.params.ParameterizedTest;

public class FirstTest extends WebDriverSettings{

    @ParameterizedTest
    @CsvSource({    "'1P73BP4Z',                'fominaelena'",
                    "'Q',                       '1P73BP4Z'",
                    "' ',                       '1P73BP4Z'",
                    "'<div> Example </div>',    '1P73BP4Z'",
                    "'fominaelena',             '1P73 BP4Z'",
                    "'fomina elena',            '1P73BP4Z'",
                    "'fominaelena',             '1P73bP4Z'",
                    "'fomina elena',            ' 1P73BP4Z'",
                    "'fomina elena',            '1P73BP4Z '",
                    "'fominaelena',             ' '",
                    "'',             ''"})
    void testSetNegative(String login, String password)
    {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        WebElement LoginField = driver.findElement(By.xpath("// input [@type='text']"));
        WebElement PasswordField = driver.findElement(By.xpath("// input [@type='password']"));
        WebElement EnterButton = driver.findElement(By.xpath("// button [@type='submit']"));

        LoginField.sendKeys(login);
        PasswordField.sendKeys(password);
        EnterButton.click();

        Assert.assertTrue(driver.switchTo().alert().getText().equals("Неверные данные для авторизации"));

        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://lmslite47vr.demo.mirapolis.ru/mira/Do?sign="));
    }

    @ParameterizedTest
    @CsvSource({"'fominaelena',             '1P73BP4Z'",
            "'Fominaelena',             '1P73BP4Z'",
            "'fominaelena ',             '1P73BP4Z'",
            "' fominaelena',             '1P73BP4Z'"})
    void testSetPositive(String login, String password)
    {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        WebElement LoginField = driver.findElement(By.xpath("// input [@type='text']"));
        WebElement PasswordField = driver.findElement(By.xpath("// input [@type='password']"));
        WebElement EnterButton = driver.findElement(By.xpath("// button [@type='submit']"));

        LoginField.sendKeys(login);
        PasswordField.sendKeys(password);
        EnterButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("// div[@class='avatar-full-name']")).getText().equals("Фомина Елена Сергеевна"));
    }

    @ParameterizedTest
    @CsvSource({"'asdasd'"})
    void testForgetPassword()
    {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        WebElement LinkForgetPassword = driver.findElement(By.xpath("// table [@class = 'links-container'] // div"));

        LinkForgetPassword.click();

        WebElement TitleForgetPassword = driver.findElement(By.xpath("//div [@class = 'info-title']"));

        Assert.assertTrue(TitleForgetPassword.getText().equals("Восстановление пароля"));
    }

    @ParameterizedTest
    @CsvSource({"'fominaelena',             '1P73BP4Z'"})
    void testShowPassword(String login, String password)
    {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        WebElement LoginField = driver.findElement(By.xpath("// input [@type='text']"));
        WebElement PasswordField = driver.findElement(By.xpath("// input [@type='password']"));
        WebElement ShowPassword = driver.findElement(By.xpath("// button [@class = 'mira-widget-login-button']"));

        LoginField.sendKeys(login);
        PasswordField.sendKeys(password);

        ShowPassword.click();

        Assert.assertTrue(PasswordField.getAttribute("type").equals("text"));
    }
}







