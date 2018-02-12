package Smartway;

import org.junit.AfterClass;
        import org.junit.Assert;
        import org.junit.BeforeClass;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olga\\IdeaProjects\\First-test\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru");
    }
    @Test
    public void userLogin() {
        WebElement InpitField = driver.findElement(By.id("text"));
        InpitField.sendKeys("погода пенза");
        WebElement Button = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        Button.click();
        WebElement FirstResult = driver.findElement(By.xpath("//*[@accesskey=\"1\"]"));
        String Pogoda = FirstResult.getText();
        Assert.assertEquals("Погода в Пензе", Pogoda);
    }
    @AfterClass
    public static void tearDown() {
                driver.quit();
    }
}