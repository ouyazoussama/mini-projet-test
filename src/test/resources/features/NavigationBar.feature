#language: fr
Fonctionnalité: Barre latérale de navigation
  Contexte:
    Etant donné que je suis sur la page de connexion
    Quand je saisi mon username "Admin"
    Et je saisi mon password "admin123"
    Et je clique sur le boutton login

@HomeHighlight
  Scénario: L'élément "Home" est surligné au chargement de la page
    Quand la page est chargée
    Alors l'élément "Dashboard" doit être surligné

  @navbarIsToggled
  Scénario: le navbar se reduit en clickant sur bouton
  Quand je clique sur la flèche pour réduire la barre de navigation
  Alors la barre de navigation devrait être réduite

@RightOrderOfElements
  Scénario: L’ordre des éléments dans la barre latérale est correct
    Quand la page est chargée
    Alors les éléments de la barre latérale doivent apparaître dans l'ordre suivant :
      | Admin        |
      | PIM          |
      | Leave        |
      | Time         |
      | Recruitment  |
      | My Info      |
      | Performance  |
      | Dashboard    |
      | Directory    |
      | Maintenance  |
      | Claim        |
      | Buzz         |
