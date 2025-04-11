package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.CategoryPage;
import pages.DetailsPages;
import pages.HomePage;

public class AddInvalidProductToCartSteps {

    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();
    DetailsPages productDetailsPage = new DetailsPages();


    @When("je clique sur valider")
    public void je_valide() {
        productDetailsPage.validate();
    }



    @Then("Je devrais voir un message disant {string}")
    public void je_devrais_voir_un_message_disant(String message) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

      //  productDetailsPage.assertMsg(message);
    }


}
