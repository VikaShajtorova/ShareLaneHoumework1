import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingUpZipCodeTest {
    @Test

    public void zipCodeShouldAccept5Digits() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");


        driver.findElement(By.name("zip_code"));
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");


        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();


        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isDisplayed = registerButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");


        driver.quit();

    }

    @Test
    public void enter4DigitsInTheZip_codeField() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");


        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");


        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();


        WebElement errorMessage = driver.findElement(By.cssSelector("[class=error_message]"));
        String text = errorMessage.getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");


        driver.quit();

    }

    @Test
    public void fillInTheRegistrationFieldsWithValidData() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isDisplayed = registerButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Dima");

        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Petrov");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("sssss@gmail.ru");

        WebElement passwordInput = driver.findElement(By.xpath("//input [@name='password1']"));
        passwordInput.sendKeys("88888");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input [@name='password2']"));
        confirmPasswordInput.sendKeys("88888");

        WebElement registerButtonInput = driver.findElement(By.cssSelector("[value=\"Register\"]"));
        registerButtonInput.click();

        WebElement registrationMessage = driver.findElement(By.xpath("//span[@class='confirmation_message']"));
        String text1 = registrationMessage.getText();
        Assert.assertEquals(text1, "Account is created!", "Пользователь не зарегистрировался");

        driver.quit();


    }

}
