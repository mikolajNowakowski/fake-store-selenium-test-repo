Feature: Performing operations on wish list

  @addingProductToWishList
  Scenario Outline:I want to add one product to wish list
    Given I am on the store home page
    When I click store button
    And I click on "<sportType>"
    And I open specific "<product>"
    Then I will be on product page
    When I add product to wish list
    And I go to the wish list
    Then I will be able to see added "<product>"

    Examples:
      | sportType      | product                                 |
      | Windsurfing    | Egipt – El Gouna                        |
      | Windsurfing    | Fuerteventura – Sotavento               |
      | Windsurfing    | Grecja – Limnos                         |
      | Windsurfing    | Windsurfing w Karpathos                 |
      | Windsurfing    | Windsurfing w Lanzarote (Costa Teguise) |
      | Windsurfing    | Wyspy Zielonego Przylądka – Sal         |
      | Wspinaczka     | Grań Kościelców                         |
      | Wspinaczka     | Wspinaczka Island Peak                  |
      | Wspinaczka     | Wspinaczka Via Ferraty                  |
      | Yoga i pilates | Wakacje z yogą w Kraju Kwitnącej Wiśni  |
      | Yoga i pilates | Wczasy relaksacyjne z yogą w Toskanii   |
      | Yoga i pilates | Yoga i pilates w Hiszpanii              |
      | Yoga i pilates | Yoga i pilates w Portugalii             |
      | Yoga i pilates | Zmień swoją sylwetkę! Yoga na Malcie    |
      | Żeglarstwo     | Kurs żeglarski na Mazurach              |
