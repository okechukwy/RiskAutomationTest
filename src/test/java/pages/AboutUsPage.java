package pages;

import genericHelpers.WebElementHelpers;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class AboutUsPage {

    private WebDriver driver;
    public  WebElementHelpers webElementHelpers;;

    public static By CareersLinks = By.xpath("//div[@class='caption']");

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        this.webElementHelpers = new WebElementHelpers(driver);

    }

   public void clickCareerLink(){
        final List<WebElement> selectedElements = driver.findElements(CareersLinks);
        WebElement selectedElement = selectedElements.get(3);
        selectedElement.click();
    }



}
