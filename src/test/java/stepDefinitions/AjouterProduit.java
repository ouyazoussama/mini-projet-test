package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class AjouterProduit {

    HomePage HomePage;
    CategoryPage productsPage;
    DetailsPages productDetailPage;
    ShoppingCart cardPage;

    public AjouterProduit()
    {
        HomePage=new HomePage();
        productsPage=new CategoryPage();
        productDetailPage=new DetailsPages();
        cardPage=new ShoppingCart();
    }

    @Given("l'utilisateur est sur la page \"home\"")
     public void lUtilisateurEstSurLaPage() {

    }
    @When("il clique sur la categorie choisie {string}")
    public void il_clique_sur_la_categorie_choisie(String categorie) {

        HomePage.cliquerSurCategorie(categorie);
    }
    @And("il clique sur le produit choisie dans la categorie {string}")
    public void il_clique_sur_le_produit_choisie_dans_la_categorie(String produit) {
            productsPage.cliquerSurProduit(produit);
    }
    @And("il clique sur le bouton {string}")
    public void il_clique_sur_le_bouton(String string) {
          productDetailPage.validate();
    }
    @And("je clique sur l'icone de panier")
    public void je_clique_sur_l_icone_de_panier() {
        productDetailPage.goToShoppingCart();

    }

    @Then("je verifie que le produit est ajouté dans le panier {string}")
    public void jeVerifieQueLeProduitEstAjoutéDansLePanier(String productLabel) {
        cardPage.verifierProductName(productLabel);
    }
}
