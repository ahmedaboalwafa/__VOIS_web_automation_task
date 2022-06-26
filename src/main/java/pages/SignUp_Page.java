package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_Page {
    private WebDriver driver;
    private Wait<WebDriver> wait;
    private By mrRadio = By.xpath("//input[@id='id_gender1']");
    private By CFirstName = By.id("customer_firstname");
    private By CLastName = By.id("customer_lastname");
    private By generatePassword = By.id("passwd");
    private By day_BOD = By.id("days");
    private By month_BOD = By.id("months");
    private By years_BOD = By.id("years");
    private By company = By.id("company");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By state = By.id("id_state");
    private By postcode = By.id("postcode");
    private By country = By.id("id_country");
    private By additionalInfo = By.id("other");
    private By mobilePhone = By.id("phone_mobile");
    private By addressAliasFFR = By.id("alias");
    private By registerBTN = By.id("submitAccount");

    public SignUp_Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public MyAccount_Page signUp(String FirstName,String LastName,String Password,String Company, String Address,String City,
                                 String Postcode,String AdditionalInfo,String mobile,String AddressAliasFFR) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3));
        driver.findElement(mrRadio).click();
        driver.findElement(CFirstName).sendKeys(FirstName);
        driver.findElement(CLastName).sendKeys(LastName);
        driver.findElement(generatePassword).sendKeys(Password);
        Select days = new Select(driver.findElement(day_BOD));
        days.selectByValue("5");
        Select months = new Select(driver.findElement(month_BOD));
        months.selectByValue("5");
        Select years = new Select(driver.findElement(years_BOD));
        years.selectByValue("1996");
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address).sendKeys(Address);
        driver.findElement(city).sendKeys(City);
        Select states = new Select(driver.findElement(state));
        states.selectByValue("1");
        driver.findElement(postcode).sendKeys(Postcode);
        Select countries = new Select(driver.findElement(country));
        countries.selectByValue("21");
        driver.findElement(additionalInfo).sendKeys(AdditionalInfo);
        driver.findElement(mobilePhone).sendKeys(mobile);
        driver.findElement(addressAliasFFR).sendKeys(AddressAliasFFR);
        driver.findElement(registerBTN).click();

        return new MyAccount_Page(driver);
    }
}
