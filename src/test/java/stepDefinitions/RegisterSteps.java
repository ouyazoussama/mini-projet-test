package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.RegisterPage;

import static setup.SetUp.driver;

public class RegisterSteps {

    RegisterPage registerPage = new RegisterPage();

    @Given("je suis sur la page d'inscription")
    public void je_suis_sur_la_page_d_inscription() {

    }

    @When("je saisis l'identifiant {string}")
    public void je_saisis_l_identifiant(String username) {
        registerPage.enterUserName(username);
    }

    @And("je saisis l'email {string}")
    public void je_saisis_l_email(String email) {
        registerPage.enterEmail(email);
    }

    @And("je saisis le mot de passe {string}")
    public void je_saisis_le_mot_de_passe(String password) {
        registerPage.enterPassword(password);
    }

    @And("je confirme le mot de passe {string}")
    public void je_confirme_le_mot_de_passe(String confirmPassword) {
        registerPage.enterConfirmPassword(confirmPassword);
    }

    @And("j'accepte les conditions")
    public void j_accepte_les_conditions() {
        registerPage.clickAgreeToConditions();
    }

    @And("je clique sur le bouton Register")
    public void je_clique_sur_le_bouton_register() {
        registerPage.clickRegisterButton();
    }

    @Then("je devrais voir le message d'erreur {string}")
    public void je_devrais_voir_le_message_d_erreur(String expectedMessage) {
       String msg = registerPage.getErrorMessage();
        Assert.assertEquals(expectedMessage , msg);
    }
}
