import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\veyse\\chromedriver\\win64-134.0.6998.36\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void login() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }

    @Test(priority = 2)
    public void addToCart() {
        WebElement product = driver.findElement(By.xpath("//div[@class='inventory_item'][1]//button"));
        product.click();
    }

    @Test(priority = 3)
    public void proceedToCheckout() {
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}