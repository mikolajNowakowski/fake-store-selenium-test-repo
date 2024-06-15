Feature: Cart operations

@productRemovalFromCart
  Scenario Outline: I want to add product to cart and remove it
    Given I am on the store home page
    When I click store button
    And I click on "<sportType>"
    And I add product in specific "<productName>" to cart
    And I go to cart
    Then I will be able to see "<productName>" windsurfing in my cart
    When I delete added product from the cart "<productName>"
    Then I will see announcement about empty cart
    And I will see which product was deleted "<productName>"

    Examples:
      | sportType   | productName      |
      | Windsurfing | Egipt – El Gouna |
