#language: fr
Fonctionnalité:  Login test
  @emptyLogin
  Scénario: Tentative de connexion avec des champs vides
    Étant donné que je suis sur la page de connexion
    Quand je clique sur le bouton "Login" sans remplir les champs
    Alors je devrais voir les messages d'erreur correspondants


