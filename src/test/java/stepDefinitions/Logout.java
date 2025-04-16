package stepDefinitions;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import pages.Index;
import pages.Login;

public class Logout {

    Index index = new Index();
    Login login = new Login();

    @Quand("je clique sur le bouton logout")
    public void je_clique_sur_le_bouton_logout() {
       index.clickLogoutButton();
    }
    @Alors("je dois être redirigé vers la page de login")
    public void je_dois_être_redirigé_vers_la_page_de_login() {
        login.assertCurrentUrl();
    }
}
