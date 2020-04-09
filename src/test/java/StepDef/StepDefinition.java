package StepDef;

import PageObjects.CardResults;
import PageObjects.CheckOutPage;
import PageObjects.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StepDefinition {

    HomePage h = new HomePage();
    CheckOutPage cp=new CheckOutPage();
    CardResults cr=new CardResults();

    @Given("^User  will navigate to the Website$")
    public void user_will_navigate_to_the_Website() throws IOException {

        Base.getDriver();
        //Base.driver.get(Base.prop.getProperty("url"));

    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String arg1) throws InterruptedException {

        h.getSearch().sendKeys(arg1);
        Thread.sleep(3000);
    }

    @Then("^\"([^\"]*)\" result is displayed$")
    public void result_is_displayed(String arg1)  {

        Assert.assertTrue(h.getProductName().getText().contains(arg1));


    }


    @When("^User searched for \"([^\"]*)\" Vegetable$")
    public void user_searched_for_something_vegetable(String arg1) {
        h.getSearch().sendKeys(arg1);
    }


    @And("^Added items to the cart$")
    public void added_items_to_the_cart() throws InterruptedException {

        HomePage h = PageFactory.initElements(Base.driver, HomePage.class);
        Thread.sleep(3000);
        h.increment();
        Thread.sleep(3000);
        h.SetToCart();

    }

    @When("^User proceed to the checkOut Page$")
    public void user_proceed_to_the_checkOut_Page() {
        cp.getImage().click();
        cp.getProceedTocheckout().click();
    }


    @Then("^Verify selected \"([^\"]*)\" items are displayed in the Checkout Page$")
    public void verify_selected_items_are_displayed_in_the_Checkout_Page(String arg1)  {

        Assert.assertTrue(cr.getProduct().getText().contains(arg1));

    }
    @When("^User added more than one item to the cart$")
    public void user_added_more_than_one_item_to_the_cart() throws InterruptedException {

        String[] itemsNeeded = {"Brocolli - 1 Kg", "Cucumber - 1 Kg", "Beans - 1 Kg"};

        Thread.sleep(3000);
        List<WebElement> products = h.getSelects();

        for (int i = 0; i < products.size(); i++) {

            String name = products.get(i).getText();
            List itemNeededList = Arrays.asList(itemsNeeded);

            if (itemNeededList.contains(name)) {

                h.addCartLists().get(i).click();
            }

        }
    }

    @Then("^Verify selected items are displayed in the Checkout Page$")
    public void verify_selected_items_are_displayed_in_the_Checkout_Page()  {
            System.out.println("Hey");
    }
}
/*
Scenario: Add 2 or more items to the car and validate results
    Given User will navigate to the Website
    When User added more than one item to the cart
    Then User proceed to the checkout Page
    And Verify selected  items are displayed in the CheckOut Page
 */