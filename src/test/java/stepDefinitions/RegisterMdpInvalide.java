package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;



public class RegisterMdpInvalide {

    RegisterPage RegisterPage;
    HomePage homePage = new HomePage();
    public RegisterMdpInvalide()
    {
        RegisterPage=new RegisterPage();
    }

    @Given("l'utilisateur est sur la page Register")
    public void lUtilisateurEstSurLaPageRegister() {

        homePage.clickSignIn();
        homePage.clickRegister();
    }
    @When("il remplit le champ Username avec {string}")
    public void ilRemplitLeChampUsernameAvec(String username) {
        RegisterPage.enterUserName(username);
    }

    @And("il remplit le champ email avec {string}")
    public void ilRemplitLeChampEmailAvec(String email) {
        RegisterPage.enterEmail(email);
    }

    @And("il remplit le champ mot de passe avec {string}")
    public void ilRemplitLeChampMotDePasseAvec(String mdp) {

        RegisterPage.enterPassword(mdp);
    }

    @And("il remplit le champ Confirmation du mot de passe avec {string}")
    public void ilRemplitLeChampConfirmationDuMotDePasseAvec(String confPwd) {
        RegisterPage.enterConfirmPassword(confPwd);
    }

    @Then("le message d'erreur affiché doit être {string}")
    public void leMessageDErreurAffichéDoitÊtre(String mssgErreur) {

        RegisterPage.verifierMssdErreur(mssgErreur);
    }


}
