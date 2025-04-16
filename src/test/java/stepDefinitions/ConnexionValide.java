package stepDefinitions;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import pages.Index;
import pages.Login;

public class ConnexionValide {
    Login login;
    Index index;
    public ConnexionValide() {
        login = new Login();
        index = new Index();
    }

    @Quand("je saisi mon username {string}")
    public void je_saisi_mon_username(String string) {
        login.insertUserName(string);
    }
    @Quand("je saisi mon password {string}")
    public void je_saisi_mon_password(String string) {
        login.insertPassword(string);
    }
    @Quand("je clique sur le boutton login")
    public void je_clique_sur_le_boutton_login() {
       login.clickLogin();
    }
    @Alors("l'application me redireger vers la page index")
    public void l_application_me_redireger_vers_la_page_index() {
        index.checkCurrentUrl();
    }

}
