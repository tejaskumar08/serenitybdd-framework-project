Feature: Home page verification
    @Web @SmokeWeb
    Scenario: User home page sections
        Given the user open browser
        When user verify each section in home page
        Then the user will be products page
#
#    @Api @SmokeApi
#    Scenario: Get User API
#        Given the user calls the Get User api with id 1
#        Then the response should be 200
#        And the response should contain user id 1