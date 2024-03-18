package genericHelpers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Optional;
import java.util.Set;

public class WebElementHelpers {

    public WebDriver driver;

    public WebElementHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement safeWaitToBeVisible(WebDriver driver, By locator, int timeInSecs){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecs));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        }
        catch (ElementNotInteractableException e)
        {
            return null;

        }

    }

    public WebElement safeWaitToBeClickable(WebDriver driver, By locator, int timeInSecs){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecs));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));

        }
        catch (ElementNotInteractableException e)
        {
            return null;

        }

    }

    public WebElement apply(WebDriver driver, final String selector) {
        return driver.findElement(By.cssSelector(selector));
    }

    public Optional<WebElement> waitUntilElementFoundByXPath(final String elementSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(elementSelector)));
        return Optional.ofNullable(apply(driver, elementSelector));
    }

    public void switchWindows(){
        Set<String> allHandles = driver.getWindowHandles();
        String currentWindowHandle = allHandles.iterator().next();
        allHandles.remove(allHandles.iterator().next());
        String lastHandle = allHandles.iterator().next();
        driver.switchTo().window(lastHandle);
    }
}
