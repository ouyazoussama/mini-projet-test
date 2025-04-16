#language: fr
Fonctionnalité: : test de connexion
  Scénario: test de connexion avec des identifiants valides
    Etant donné que je suis sur la page de connexion
    Quand je saisi mon username "Admin"
    Et je saisi mon password "admin123"
    Et je clique sur le boutton login
    Alors l'application me redireger vers la page index

  @emptyLogin
  Scénario: Tentative de connexion avec des champs vides
    Étant donné que je suis sur la page de connexion
    Quand je clique sur le bouton "Login" sans remplir les champs
    Alors je devrais voir les mes