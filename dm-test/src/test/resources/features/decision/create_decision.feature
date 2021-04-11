Feature: Create decision

  Scenario: Create decision
    When I create a decision with name "fridge"
    Then the response is 201

    When I get the decision
    Then the response is 200
    And the decision name is "fridge"

  Scenario: Create decision with invalid name
    Given I plan to create a decision
    When I create the decision
    Then the response is 400

    When I create a decision with name ""
    Then the response is 400
