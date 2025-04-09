Feature: Recherche sur Google

  Scenario: Rechercher un mot-clé sur Google
    Given l'utilisateur est sur la page d'accueil de Google
    When il saisit "Selenium" dans la barre de recherche
    Then il doit voir des résultats contenant "Selenium"