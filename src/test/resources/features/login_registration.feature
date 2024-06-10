Feature: Store login and registration

  Background:
    Given I am on the store home page
    When I click on the MyAccount button
    Then I am on the login form page

  @registerSuccess
  Scenario Outline: I want to register and then log in with specified credentials
    When I provide "<email>" and "<password>" to register
    Then I am successfully logged in to my account "<email>"
    When I log out from my account
    And I log in with the same "<email>" and "<password>"
    Then I am successfully logged in to my account "<email>"

    Examples:
      | email                                           | password                   |
      | user1342wresd34sdfswddwee4344333231@example.com | password197887658756856345 |
      | use323wwserasd43ee433e441r2@example.com         | password2978345634563445   |
      | user233wersfdde65wer4344313@example.com         | password3978234523452345   |


  @alreadyRegisteredError
  Scenario Outline: I want to register twice with the same email
    When I provide "<email>" and "<password>" to register
    Then I am successfully logged in to my account "<email>"
    When I log out from my account
    And I provide "<email>" and "<password>" to register
    Then I get specified error message "<errorMessage>"
    And  I see only one error message



    Examples:
      | email                              | password                  | errorMessage                                                             |
      | flsdjhflkerrasdesdjf@example.com   | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhfleredswewksdjf@example.com  | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhflweasdrgreksdjf@example.com | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhfwerdasfrelksdjf@example.com | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
      | flsdjhfwerfdhrelksdjf@example.com  | passworsdfsdfsdfd1234*&^% | Błąd: Konto z Twoim adresem e-mail jest już zarejestrowane. Zaloguj się. |
