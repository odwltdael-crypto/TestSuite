package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    public static WebDriver getDriver() {
    	System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
//        driver = new EdgeDriver();
        return new EdgeDriver();
    }
}