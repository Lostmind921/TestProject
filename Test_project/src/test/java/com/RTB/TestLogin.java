package com.RTB;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestLogin extends settings {

    @Test
    public void noData() {
        System.out.println("Start noData");
        //Тест - Проверка логина без данных на странице
        //Найти кнопку log in
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        //Клик по кнопке
        loginButton.click();
        //Поиск сообщения об ошибке и вывод его консоль
        String ErrorMassage = driver.findElement(By.cssSelector(".signup__error")).getText();
        System.out.println(ErrorMassage);

        //Окончание теста
        System.out.println("Stop noData");
    }


    @Test
    public void testEmail() {

        System.out.println("Start testEmail");
        //Тест - Ввод данных только в поле логина
        //Находим элемент на странице для ввода email
        WebElement workEmail = driver.findElement(By.id("email"));
        //Вводим не корректные данные в поле логина
        workEmail.sendKeys("134");

        //Найти кнопку log in
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //Находим текст об ошибке на странице
        WebElement ErrorPass = driver.findElement(By.cssSelector(".signup__error-item"));
        if (driver.getPageSource().contains("Please enter your password")) {
            System.out.println("Не введен пароль"); //Если сообщение об ошибки находится на странице выводим в консоль
        }
        else
        {
            System.out.println("Сообщение отсутствует или не корректно"); //Если сообщения об ошибке нет на странице выводим в консоль
        }
        System.out.println("Stop testEmail");
    }


    @Test
    public void testPass() {
        System.out.println("Start testPass");
        //Тест - Ввод данных только в поле Пароля
        //Находим на странице элемент для ввода пароля
        WebElement pass = driver.findElement(By.id("password"));
        //Вводим не корректные данные в поле пароля
        pass.sendKeys("134");

        //Найти кнопку log in
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //Находим текст об ошибке на странице
        WebElement ErrorPass = driver.findElement(By.cssSelector(".signup__error-item"));
        if (driver.getPageSource().contains("Please enter your email address")) {
            System.out.println("Не введен email"); //Если сообщение об ошибки находится на странице выводим в консоль
        }
        else
        {
            System.out.println("Сообщение отсутствует или не корректно");//Если сообщения об ошибке нет на странице выводим в консоль
        }
        System.out.println("Stop testPass");
    }

    @Test
    public void correctMailandPass() {
        System.out.println("Start correctMailandPass");
        //Тест - Корректные логин и пароль
        WebElement workEmail = driver.findElement(By.id("email"));
        //Вводим корректные данные в поле логина
        workEmail.sendKeys("h3978590@nwytg.net");
        //Находим на странице элемент для ввода пароля
        WebElement pass = driver.findElement(By.id("password"));
        //Вводим корректные данные в поле пароля
        pass.sendKeys("Test12345678");

        //Найти кнопку log in
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //Проверка после логина, обновилась ли страница на Home Page
        String homePage  = driver.getTitle();
        Assert.assertTrue(homePage.equals("RealtimeBoard | Online Whiteboard for Visual Collaboration"));
        System.out.println("Открыта страница Home Page");

        System.out.println("Stop correctMailandPass");
    }
}
