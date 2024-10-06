Feature: Sauce Demo purchase

  Scenario Outline: Successful purchase
    Given "<user>" has an active account
    When "<user>" sends their valid credentials
    And "<user>" adds "<product_1>" and "<product_2>" to the cart
    And "<user>" views the cart and clicks on checkout
    And "<user>" completes the purchase with details "<first_name>", "<last_name>", "<postal_code>"
    And "<user>" completes the purchase flow by clicking on "<button_1>", "<button_2>"
    Then "<user>" should see the confirmation message "<confirmation_message>"

    Examples:
      | user          | product_1                | product_2             | first_name | last_name | postal_code | button_1 | button_2 | confirmation_message       |
      | standard_user | Sauce Labs Backpack      | Sauce Labs Bike Light | John       | Doe      | 12345       | Continue | Finish   | Thank you for your order!  |
