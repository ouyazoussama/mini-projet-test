package stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Index;

import java.util.ArrayList;
import java.util.List;

public class VerifyNavigationNavbar {
    Index index = new Index();

    @Quand("la page est chargée")
    public void la_page_est_chargée() {

    }
    @Alors("l'élément {string} doit être surligné")
    public void l_élément_doit_être_surligné(String string) {
        index.assertHomeIsHighlighted(string);
    }





    @Alors("les éléments de la barre latérale doivent apparaître dans l'ordre suivant :")
        public void rightOrder(DataTable dataTable){
            List<String> expected = dataTable.asList();
            List<WebElement> navbarElements = index.getNavbarElemtsList();
            List<String> actual = new ArrayList<>();
            for(WebElement webElement : navbarElements){
                actual.add(webElement.getText());
            }

            Assert.assertEquals(expected , actual , "les elements sont pas en ordre" );
        }

    int fullWidth = 0;
    @Quand("je clique sur la flèche pour réduire la barre de navigation")
    public void jeCliqueSurLaFlèchePourRéduireLaBarreDeNavigation() {
        fullWidth  = index.returnWidth();
        System.out.println(fullWidth);
        index.clickToggleButton();
    }

    @Alors("la barre de navigation devrait être réduite")
    public void laBarreDeNavigationDevraitÊtreRéduite() {
       // System.out.println(index.isNavbarToggled());
        Assert.assertTrue(index.isNavbarToggled());
        int minWidth = index.returnWidth();
        System.out.println(minWidth);

        Assert.assertTrue(fullWidth> minWidth);
    }
}
