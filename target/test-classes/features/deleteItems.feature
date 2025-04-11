# language: fr
Fonctionnalité: Éditer la quantité dans le panier d'achat (suppression d'éléments)
@delete
  Plan du Scénario: Supprimer des éléments du panier
    Étant donné que j'ai "<quantity>" casques noirs dans mon panier
    Quand je navigue vers mon panier
    Et je clique sur "Modifier" un produit
    Et je diminue la quantité à "<diminuatedquantity>" casques
    Alors je vois "<expectedquantity>" casques dans mon panier

    Exemples:
      | quantity | diminuatedquantity | expectedquantity |
      | 2        | 1                  | 1                |
      | 3        | 2                  | 2                |





