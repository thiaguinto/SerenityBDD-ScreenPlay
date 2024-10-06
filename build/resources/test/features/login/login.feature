Feature: Login into the application

  Scenario: Successful login
    Given  Sergey has an active account
    When he sends their valid credentials
    Then he shoulds have access to manage his account