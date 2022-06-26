package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Address_Page {
    private WebDriver driver;
    private Wait wait;
    private By addressProceedToCheckout = By.name("processAddress");
    public Address_Page(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public Shipping_Page navigateToShippingPage(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addressProceedToCheckout)));
        driver.findElement(addressProceedToCheckout).click();
        return new Shipping_Page(driver);
    }
}
