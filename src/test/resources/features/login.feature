#language: fr
Fonctionnalité: : test de connexion

  Contexte:
    Etant donné que je suis sur la page de connexion
    Quand je saisi mon username "Admin"
    Et je saisi mon password "admin123"
    Et je clique sur le boutton login
  @ValidLogin
  Scénario: test de connexion avec des identifiants valides

    Alors l'application me redireger vers la page index

  @logout
  Scénario: Déconnexion
    Quand je clique sur le bouton logout
    Alors je dois être redirigé vers la page de login

