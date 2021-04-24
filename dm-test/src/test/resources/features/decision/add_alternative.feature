Feature: Add alternative

  Scenario: Add alternative to decision
    Given I create a decision with name "Oven"

    Given I plan to add an alternative
    And I set the alternative name to "Bosch MFK89"
    When I add the alternative
    Then the response is 201

    Given I plan to add an alternative
    And I set the alternative name to "Electrolux UXI87"
    When I add the alternative
    Then the response is 201

    When I get the decision
    Then the response is 200
    And the decision has 2 alternatives
    Given I peek at the alternative with name "Bosch MFK89"

  Scenario: Add alternative with invalid name
    Given I create a decision with name "Hood"

    Given I plan to add an alternative
    When I add the alternative
    Then the response is 400

    Given I plan to add an alternative
    And I set the alternative name to ""
    When I add the alternative
    Then the response is 400

  Scenario: Add alternative on not found decision
    And I use a nonexistent decision
    Given I plan to add an alternative
    And I set the alternative name to "Logitech MX50"
    When I add the alternative
    Then the response is 404

