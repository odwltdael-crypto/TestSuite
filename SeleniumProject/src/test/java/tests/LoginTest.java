package tests;

import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.LoginPage;
import pages.HomePage;
import utils.WebDriverFactory;
import org.testng.Assert;

public class LoginTest {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver = WebDriverFactory.getDriver();
//        driver.get("https://practice.qabrains.com/");
		driver.get("http://localhost:8080/");
		driver.manage().window().maximize();
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
	}

//    @Test(dataProvider = "loginData")
//    public void testLogin(String username, String password, String expectedWelcome) {
//        loginPage.login(username, password);
//        String welcomeText = homePage.getWelcomeMessage();
//        Assert.assertEquals(welcomeText, expectedWelcome, "Logout");
//        driver.findElement(By.xpath("//*[text()='Drag and Drop List']")).click();
//    }

	@Test // (dataProvider = "loginData")
	public void testLogin() {

		List<WebElement> urls = driver.findElements(By.tagName("a"));
		urls.stream().map(WebElement::getText).forEach(System.out::println);

		for (WebElement link : urls) {

			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}

			verifyLink(url);
		}

//        loginPage.login(username, password);
//        String welcomeText = homePage.getWelcomeMessage();
//        Assert.assertEquals(welcomeText, expectedWelcome, "Logout");
//        driver.findElement(By.xpath("//*[text()='Drag and Drop List']")).click();
	}

//    @DataProvider
//    public Object[][] loginData() {
//        return new Object[][] {
//            {"qa_testers@qabrains.com", "Password123", "Welcome user1!"},
////            {"user2", "pass2", "Welcome user2!"},
//        };
//    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) driver.quit();
//    }

	public static void verifyLink(String urlLink) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URI(urlLink).toURL().openConnection();
//            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode >= 200 && responseCode < 400) {
				System.out.println(urlLink + " - Working");
			} else {
				System.out.println(urlLink + " - Broken");
			}

		} catch (Exception e) {
			System.out.println(urlLink + " - Invalid URL");
		}
	}
}