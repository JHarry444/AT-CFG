Feature: Shopping on a website
As a person
I want to browse items on a website
So that I can purchase the items I want

Scenario: Browse the items available on the website
Given I am on the 'Home' page
When I navigate to the 'Menu' page
Then I can browse a list of the available products.

Scenario: Add an item to the checkout
Given I am on the 'Menu' page
When I click the checkout button
Then I am taken to the 'Checkout' page
