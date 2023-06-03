import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingUpZipCodeTest extends BaseTest {
    String zipCodeInputLocator = "zip_code";
    String continueButtonLocator = "[value=Continue]";
    String errorMessageLocator = "[class='error_message']";

    @Test
    public void zipCodeShouldAccept5Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");

    }

    @Test
    public void input4DigitsInTheZipCodeField() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void input6DigitsInTheZipCodeField() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void leaveZipCodeFieldEmpty() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void checkUserCanGoFromSignUpPageToRegistrationPageByClickingOnShoppingCart() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//td[3]/a")).click();
        String text1 = driver.findElement(By.cssSelector("[class='error_message']")).getText();
        Assert.assertEquals(text1, "Oops, error. You must log in", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void inputEmailInZipCodeField() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("shareLane@mail.ru");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void inputSpaceAnd4DigitsInZipCodeField() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys(" 1234");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void input4DigitsAndSpaceInZipCodeField() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234 ");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void input5UppercaseAndLowercaseLatinLettersInZipCodeField() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("DfgHj");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void input5UppercaseAndLowercaseCyrillicLettersInZipCodeField() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("АбвГд");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }

    @Test
    public void input5CharactersInZipCodeField() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("@!?**");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не совпадает или отсутствует");

    }
}
