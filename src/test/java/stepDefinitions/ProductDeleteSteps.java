package stepDefinitions;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonnéque;
import pages.CategoryPage;
import pages.DetailsPages;
import pages.HomePage;
import pages.ShoppingCart;

public class ProductDeleteSteps {

    HomePage home = new HomePage();
    CategoryPage productPage = new CategoryPage();
    DetailsPages productDetails = new DetailsPages();
    ShoppingCart shoppingCart = new ShoppingCart();

    @Étantdonnéque("j'ai {string} casques noirs dans mon panier")
    public void jAiCasquesNoirsDansMonPanier(String quantite) {
        home.clickHeadphoneBox();
        int quantity = (int) Integer.parseInt(quantite);

        productPage.addBlackHeadphones();

        for (int i = 0; i < quantity; i++) {
            productDetails.increment();
        }

        productDetails.validate();
    }

    @Quand("je navigue vers mon panier")
    public void jeNavigueVersMonPanier() throws InterruptedException {
        productDetails.goToShoppingCart();
    }

    @Et("je clique sur \"Modifier\" un produit")
    public void jeCliqueSurModifierPourUnProduit() throws InterruptedException {
        Thread.sleep(10000);
        shoppingCart.editQuantity();
        System.out.println("button clique -> sur \"Modifier\" un produit");
    }

    @Et("je diminue la quantité à {string} casques")
    public void jeDiminueLaQuantitéÀCasques(String diminuated_quantity) throws InterruptedException {
        int quantité_a_diminuer = (int) Integer.parseInt(diminuated_quantity);
        for (int i = 0; i < quantité_a_diminuer; i++) {
            productDetails.decreaseQuantity();
            System.out.println("button clique -> sur \"decrease\" un produit");
            Thread.sleep(5000);
        }
        productDetails.validate();
    }

    @Alors("je vois {string} casques dans mon panier")
    public void jeVoisCasquesDansMonPanier(String expected_quantity) throws InterruptedException {
        //productDetails.shoppingCartUpdated(expected_quantity);
    }
}
