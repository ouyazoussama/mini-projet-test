package stepDefinitions;

import pages.Inscription;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonnéque;
import org.openqa.selenium.WebDriver;

public class signUpSteps {
    Inscription inscription;
    public signUpSteps() {
        inscription = new Inscription();
    }





    @Alors("un message d'erreur s'affiche indique que Votre adresse email n'est pas correctement formatée")
    public void unMessageErreurSafficheInqueQueVotreAdresseEmailNestPasCorrectementFormatée() {
        inscription.checkMessageErrorDisplayed();
    }


    @Quand("je saisis une adresse email avec format invalide {string}")
    public void jeSaisisUneAdresseEmailAvecFormatInvalide(String emailInvalide) {
        inscription.insertEmail(emailInvalide);

    }



    @Et("je saisi mon password {string}")
    public void jeSaisiMonPassword(String password) {
        inscription.insertPassword(password);
    }

    @Et("je saisi encore  le méme password {string}")
    public void jeSaisiEncoreLeMémePassword(String repeatedPassword) {
        inscription.insertRepeatedPassword(repeatedPassword);
    }

    @Et("le boutton <Enregistrer> doit etre desavctivé")
    public void leBouttonEnregistrerDoitEtreDesavctivé() {
        inscription.checkEnregistrerButtonDisable();
    }



    @Et("je saisis mon username {string}")
    public void jeSaisisMonUsername(String arg0) {
        inscription.insertUsename(arg0);
    }


}
