Feature: Registration

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

