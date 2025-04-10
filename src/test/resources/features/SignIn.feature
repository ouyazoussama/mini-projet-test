Feature: User Registration

  As a customer,
  I want to sign up to the application,
  So that I have an account created with my personal information that I can use to login to the application.

  Background:
    Given I am on the homepage of Advantage Online Shopping
    And I click on the "User" icon in the top navigation bar
    And I click on "Create new account"

  Scenario Outline: Successful account creation
    When I fill in the "Username" field with "<username>"
    And I fill in the "Email" field with "<email>"
    And I fill in the "Password" field with "<password>"
    And I fill in the "Confirm Password" field with "<confirm_password>"
    And I fill in the "First Name" field with "<first_name>"
    And I fill in the "Last Name" field with "<last_name>"
    And I fill in the "Phone Number" field with "<phone_number>"
    And I select "<country>" from the "Country" dropdown
    And I fill in the "City" field with "<city>"
    And I fill in the "Address" field with "<address>"
    And I fill in the "State / Province / Region" field with "<state>"
    And I fill in the "Postal Code" field with "<postal_code>"
    And I check the "I agree to the terms and conditions" checkbox
    And I click on the "Register" button
    Then I should be redirected to the homepage
    And I should see my username "<username>" in the top navigation bar
    And I choose a category "Speakers"
    And I choose a product
    And I add a product to the cart
    And I enter on the "Cart" icon in the top navigation bar
    And I remove all items from the cart

    Examples:
      | username        | email             | password   | confirm_password | first_name | last_name | phone_number | country | city   | address         | state   | postal_code |
      | alex_22         | alex7@gmail.com   | 12345Az    | 12345Az          | Alex       | Lavar      | 0600123456  | Marocco | Rabat  | 123 Rue rabat   | Rabat   | 10000       |
