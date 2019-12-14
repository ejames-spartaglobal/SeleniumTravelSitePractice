package com.spartaglobal.seleniumpractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.concurrent.TimeUnit;

public class Homepage {
    private WebDriver driver;
    private Actions actions;
    private String homepageURL = "https://www.phptravels.net/index.php";
    private By minimisePopUp = By.cssSelector("#widget-global-qx69dbdzvxb > div > div > div > div.lc-1dly1s8.e1ohfhv0 > div:nth-child(3) > button > svg");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public Homepage goToHomepage(){
        driver.manage().window().fullscreen();
        driver.navigate().to(homepageURL);
        return this;
    }

    public Homepage minimisePopup(){
        waitForElement();
        driver.findElement(minimisePopUp).click();
        return this;
    }

    public Homepage waitForElement(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public Homepage enterDestination(){
        waitForElement();
        driver.findElement(By.linkText("Search by Hotel or City Name")).sendKeys("London");
        return this;
    }

    public Homepage submitSearch(){
        driver.findElement(By.cssSelector("#hotels > div > div > form > div > div > div.col-md-2.col-xs-12.o1 > button")).submit();
        return this;
    }

    public Homepage clickBlogLink1(){
        driver.findElement(By.cssSelector("#MenuHorizon28_01 > div > div > div:nth-child(1) > div > a > div.image > img")).click();
        return this;
    }

    public Homepage clickBlogLink2(){
        driver.findElement(By.cssSelector("#MenuHorizon28_01 > div > div > div:nth-child(2) > div > a > div.image > img")).click();
        return this;
    }

    public Homepage clickBlogLink3(){
        driver.manage().window().fullscreen();
        driver.findElement(By.cssSelector("#MenuHorizon28_01 > div > div > div:nth-child(3) > div > a > div.image > img")).click();
        return this;
    }

    public Homepage selectCheckIn(){
        driver.findElement(By.cssSelector("#checkin")).click();
        driver.findElement(By.cssSelector("#datepickers-container > div:nth-child(1) > div > div > div.datepicker--cells.datepicker--cells-days > div:nth-child(29)")).click();
        return this;
    }//#checkout

    public Homepage selectCheckOut(){
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#datepickers-container > div:nth-child(2) > div > div > div.datepicker--cells.datepicker--cells-days > div:nth-child(31)")).click();
        return this;
    }
}
