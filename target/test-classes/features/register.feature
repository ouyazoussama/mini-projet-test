Feature: Registration

  # Scénario d'inscription avec identifiant existant
  @register
  Scenario: Inscription avec un identifiant déjà existant
    Given je suis sur la page d'inscription
    When je saisis l'identifiant "testuser"
    And je saisis l'email "testuser@example.com"
    And je saisis le mot de passe "Test@1234"
    And je confirme le mot de passe "Test@1234"
    And j'accepte les conditions
    And je clique sur le bouton Register
    Then je devrais voir le message d'erreur "User name already exists"

  # Scénarios de création de compte avec mot de passe invalide
  @register1
  Scenario Outline: Créer un compte avec un mot de passe invalide
    Given l'utilisateur est sur la page Register
    When il remplit le champ Username avec "<Username>"
    And il remplit le champ email avec "<email>"
    And il remplit le champ mot de passe avec "<mdps>"
    And il remplit le champ Confirmation du mot de passe avec "<ConfirmPwd>"
    Then le message d'erreur affiché doit être "<mssgErreur>"

    Examples:
      | Username | email                       | mdps             | ConfirmPwd       | mssgErreur                     |
      | jamila   | durand.jean75@gmail.com     | 123              | 123              | Use 4 character or longer      |
      | hajar    | hajar-5857@yopmail.com      | AZERTY123456789  | AZERTY123456789  | Use maximum 12 character       |
      | marie    | marie-9317@yopmail.com      | 123456           | 123456           | One lower letter required      |
      | marie    | marie-9317@yopmail.com      | haj123456        | haj123456        | One upper letter required      |
      | marie    | marie-9317@yopmail.com      | Azertty          | Azertty          | One number required            |

  # Scénarios de format d'email invalide
  @mailInvalid
  Scenario Outline: Inscription avec un format d'email erroné
    Given je suis sur la page d'inscription
    And je saisis mon username "<username>"
    When je saisis une adresse email avec format invalide "<email>"
    And je saisi mon password "<password>"
    And je saisi encore  le méme password "<repeatedPassword>"
    Then un message d'erreur s'affiche indique que Votre adresse email n'est pas correctement formatée
    And le boutton <Enregistrer> doit etre desavctivé

    Examples:
      | email            | username    | password    | repeatedPassword |
      | test@            | houdaifa1   | Abcde@123   | Abcde@123        |
      | test@@example    | Houdaifa12  | Abcde@1234  | Abcde@1234       |
      | test@example.    | Houdaifa123 | Abcde@12345 | Abcde@12345      |
      | @example.com     | Houdaifa1234| Abcde@123456| Abcde@123456     |
      | test@.com        | Houdaifa987 | Abcd@1234567| Abcd@1234567     |
