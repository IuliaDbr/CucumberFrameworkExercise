Feature: Login into account
  Existing user should be able to login to account using correct credentials

  Scenario Outline: Login into account with credentials
    Given User navigates to "<url>"
    And User clicks on the login button
    And User enters the "<username>" username
    And User enters the "<password>" password
    When User clicks on the final login button
    Then User should be presented with the following prompt alert "<message>"

    Examples:
      | url                                 | username  | password     | message              |
      | http://www.webdriveruniversity.com/ | webdriver | webdriver    | validation failed    |
      | http://www.webdriveruniversity.com/ | webdriver | webdriver123 | validation succeeded |