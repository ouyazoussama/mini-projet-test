package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoryPage;
import pages.DetailsPages;
import pages.HomePage;

public class AddValidQuantituProduct {
    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();
    DetailsPages productDetailsPage = new DetailsPages();

    @Given("Je suis sur la page d'accueil")
    public void je_suis_sur_la_page_d_accueil() {

    }

    @When("Je navigue vers la catégorie des tablettes")
    public void je_navigue_vers_la_categorie_des_tablettes() {
        homePage.clickOnTabletsCategory();
    }

    @When("Je sélectionne un produit")
    public void je_selectionne_un_produit() {
        categoryPage.buy();
    }


    public AddValidQuantituProduct() {
    }

    @When("Je tente d'ajouter {int} articles au panier")
    public void je_tente_d_ajouter_15_articles_au_panier(int number ) {
        //String str = String.valueOf(number);
        productDetailsPage.setQuantity(number);
    }

    @When("Je clique sur valider")
    public void je_valide() {
        productDetailsPage.validate();
    }
    @Then("L'icône du panier doit afficher {int} comme nombre d'articles")
    public void je_devrais_voir_un_message_disant(int  number) {



        productDetailsPage.assertCartItemCountNumber(number);
    }


}
