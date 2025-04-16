package stepDefinitions;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonnéque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Login;

public class LoginWithEmptyRequiredFields {

    private static final Logger log = LoggerFactory.getLogger(LoginWithEmptyRequiredFields.class);
    Login loginPage = new Login();

    public LoginWithEmptyRequiredFields(){

    }



    @Étantdonnéque("je suis sur la page de connexion")
    public void je_suis_sur_la_page_de_connexion() {


    }
    @Quand("je clique sur le bouton {string} sans remplir les champs")
    public void je_clique_sur_le_bouton_sans_remplir_les_champs(String string) {
       loginPage.clickLogin();
    }
    @Alors("je devrais voir les messages d'erreur correspondants")
    public void je_devrais_voir_les_messages_d_erreur_correspondants() {
       loginPage.getUsernameErrorMessage();
       loginPage.getPasswordErrorMessage();
    }



}
