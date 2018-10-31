package com.RTB;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class settings {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        //Подключение chromedriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvpag\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        //Развернуть окно браузера во весь экран
        driver.manage().window().maximize();
        //открыть сайт
        driver.get("https://realtimeboard.com/");

        //Проверка на то, что открылась именно та страница которая нам необходима
        String titleIndexPage = driver.getTitle();
        Assert.assertTrue(titleIndexPage.equals("Online Whiteboard & Visual Collaboration Platform for Teams"));
        //Находим кнопку логина на странице
        WebElement loginPage = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        //Нажимаем на нее для перехода
        loginPage.click();
        //Проверим что переход осуществлен на страницу логина, путем проверки Title страницы
        String titleLoginPage = driver.getTitle();
        Assert.assertTrue(titleLoginPage.equals("Log in | RealtimeBoard"));
    }

    @After
    public void close() {

        driver.quit();
    }
}
