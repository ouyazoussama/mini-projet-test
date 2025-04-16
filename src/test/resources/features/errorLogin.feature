#language: fr
Fonctionnalité: Connexion avec erreur

  @emptyLogin
  Scénario: Tentative de connexion avec des champs vides
    Étant donné que je suis sur la page de connexion
    Quand je clique sur le bouton "Login" sans remplir les champs
    Alors je devrais voir les messages d'erreur correspondants

  @AccessWithoutLogin
  Plan du Scénario:Tenter d’accéder directement à une page interne sans authentification
    Etant donné que je ne suis pas authentifié
    Quand j'essaye d'acceder a une page avec cet url "<url>"
    Alors le website me redirige vers la page de login
    Exemples:
      | url |
      |https://opensource-demo.orangehrmlive.com/web/dashboard/index|
      |https://opensource-demo.orangehrmlive.com/web/admin/viewSystemUsers|
