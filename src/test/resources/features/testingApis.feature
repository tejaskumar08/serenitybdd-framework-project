Feature: Dummy Apis testing
  @Api
  Scenario: Retrieve a post by Id
    Given the user calls Get Posts Api with id 1
    Then the response should be 200
    And the response body should contain 1 and "Artificial Intelligence"