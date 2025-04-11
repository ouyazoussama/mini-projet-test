Feature: Ajouter un produit au panier

  @validQuantity
  Scenario: Ajouter un article au panier avec une quantité valide
    Given Je suis sur la page d'accueil
    When Je navigue vers la catégorie des tablettes
    And Je sélectionne un produit
    And Je tente d'ajouter 5 articles au panier
    And Je clique sur valider
    Then L'icône du panier doit afficher 5 comme nombre d'articles

  @breakStock
  Scenario: Ajouter un article au panier avec une quantité supérieure au stock disponible
    Given Je suis sur la page d'accueil
    When Je navigue vers la catégorie des tablettes
    And Je sélectionne un produit
    And Je tente d'ajouter 15 articles au panier
    And  je clique sur valider
    Then Je devrais voir un message disant "Oops! We only have 10 in stock. We updated your order accordingly"

  @AddProduct
  Scenario Outline: [TEST AUTO] Ajout des produits
    Given l'utilisateur est sur la page "home"
    When  il clique sur la categorie choisie "<categorie>"
    And   il clique sur le produit choisie dans la categorie "<produit>"
    And   il clique sur le bouton "ADD TO CART"
    And   je clique sur l'icone de panier
    Then  je verifie que le produit est ajouté dans le panier "<produitLabel>"

    Examples:
      | categorie  | produit|produitLabel|
      | SPEAKERS   | Bose Soundlink Bluetooth Speaker III |BOSE SOUNDLINK BLUETOOTH SPEAKER III|
      | TABLETS    | HP ElitePad 1000 G2 Tablet |HP ELITEPAD 1000 G2 TABLET|
      | HEADPHONES | Beats Studio 2 Over-Ear Matte Black Headphones  |BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES|


