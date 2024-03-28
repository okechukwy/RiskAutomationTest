package pages;

import genericHelpers.WebElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AboutUsPage {

    private WebDriver driver;
    public  WebElementHelpers webElementHelpers;

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
