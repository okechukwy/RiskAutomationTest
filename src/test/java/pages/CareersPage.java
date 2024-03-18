package pages;

import genericHelpers.WebElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CareersPage {

    private WebDriver driver;
    public WebElementHelpers webElementHelpers;;

    //Web Elements region
    public static By searchAllJobsSelector = By.xpath("//a[@class='score-button hidden-xs hidden-sm'][contains(text(), 'Search all jobs')]");

    public static By careerSearchField = By.xpath("//input[@class='search-box-input ais-search-box--input']");

    public static By searchFieldButton = By.xpath("//span[@class ='search-box-button-text']");

    public static By searchResult = By.xpath("//div[@class='ais-hits--item']");

    public CareersPage(WebDriver driver) {

        this.driver = driver;
        this.webElementHelpers = new WebElementHelpers(driver);
    }

    public void clickSearchAllJobsButton(){
        webElementHelpers.safeWaitToBeVisible(driver, searchAllJobsSelector, 5 );
        driver.findElement(searchAllJobsSelector).click();

    }

    public void getSearchField (final String keyWord){
        webElementHelpers.safeWaitToBeVisible(driver, careerSearchField, 5 );
        driver.findElement(careerSearchField).sendKeys(keyWord);
    }

    public int getFilteredResults(){
        List<WebElement> searchResults = driver.findElements(searchResult);
        return searchResults.size();
    }
}
