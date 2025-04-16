package stepDefinitions;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import pages.Login;
import pages.NavigationPage;

public class AccessWithoutAuthentication {
    NavigationPage navigationPage ;
    Login loginPage;
    public AccessWithoutAuthentication() {
      navigationPage = new NavigationPage();
      loginPage = new Login();
    }
    @Etantdonnéque("je ne suis pas authentifié")
    public void je_ne_suis_pas_authentifié() {

    }

    @Quand("j'essaye d'acceder a une page avec cet url {string}")
    public void jEssayeDAccederAUnePageAvecCetUrl(String arg0) throws InterruptedException {
        navigationPage.navigateToPage(arg0);
        Thread.sleep(2000);
    }
    @Alors("le website me redirige vers la page de login")
    public void le_website_me_redirige_vers_la_page_de_login() {
     loginPage.assertCurrentUrl();
    }

}
