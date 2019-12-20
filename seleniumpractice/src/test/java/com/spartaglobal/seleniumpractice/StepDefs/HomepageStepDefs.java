package com.spartaglobal.seleniumpractice.StepDefs;

import com.spartaglobal.seleniumpractice.Pages.Homepage;
import com.spartaglobal.seleniumpractice.SeleniumConfig.SeleniumConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;

public class HomepageStepDefs {

    private static Homepage homepage;
    private static SeleniumConfig seleniumConfig;

    @BeforeClass
    public static void setup(){
        seleniumConfig = new SeleniumConfig("chrome","D:\\Docs\\Engineering43\\Engineering43\\chromedriver_win32\\chromedriver.exe");
        homepage = new Homepage(seleniumConfig.getDriver());
    }

    @Given("I am on the Homepage")
    public void i_am_on_the_Homepage() {
        homepage.goToHomepage();
    }

    @When("I enter the location into the location bar")
    public void i_enter_the_location_into_the_location_bar() {
        homepage.enterDestination();
    }

    @And("the Check-in date is entered")
    public void the_Check_in_date_is_entered() {
        homepage.selectCheckIn();
    }

    @And("the Check-out date is entered")
    public void the_Check_out_date_is_entered() {
        homepage.selectCheckOut().submitSearch();
    }

    @Then("I will be able to see the correct information")
    public void i_will_be_able_to_see_the_correct_information() {
        System.out.println(seleniumConfig.getDriver().getCurrentUrl());;
    }
}
