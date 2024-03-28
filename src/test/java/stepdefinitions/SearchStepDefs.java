package stepdefinitions;

import genericHelpers.NavBar;
import genericHelpers.WebElementHelpers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AboutUsPage;
import pages.CareersPage;
import pages.HomePage;

import java.time.Duration;

public class SearchStepDefs {

    private WebDriver driver;
    public HomePage homePage;
    public NavBar navBar;
    public CareersPage careersPage;
    public AboutUsPage aboutUsPage;
    public WebElementHelpers webElementHelpers;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("I navigate to the risk home page {string}")
    public void i_navigate_to_the_risk_home_page(String url) {
       driver.get(url);
    }
    @Given("I accept the cookies")
    public void i_accept_the_cookies() {
        homePage = new HomePage(driver);
        homePage.acceptAllCookies();
    }

    @When("I click the About Us page")
    public void iClickTheAboutUsPage() {
        navBar = new NavBar(driver);
        navBar.clickAboutUsLink();
    }

    @When("I open the Career page")
    public void i_open_the_career_page() {
        aboutUsPage = new AboutUsPage(driver);
        aboutUsPage.clickCareerLink();

    }
    @When("I click the search all link")
    public void i_click_the_search_all_link() {
        careersPage = new CareersPage(driver);
        webElementHelpers = new WebElementHelpers(driver);
        webElementHelpers.switchWindows();
        careersPage.clickSearchAllJobsButton();
    }
    @When("I search for {string} job")
    public void i_search_for_job(String text) {
        careersPage.getSearchField(text);
    }

    @Then("I see the number of jobs available displayed")
    public void i_see_the_number_of_jobs_available() {
        int  results = careersPage.getFilteredResults();
        Assert.assertTrue("There were " + results+" search results", results > 0);

    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();

    }



}
