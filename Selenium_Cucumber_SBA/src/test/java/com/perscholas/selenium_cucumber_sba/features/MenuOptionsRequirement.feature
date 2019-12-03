Feature: The user adds an item to the cart

Scenario: The user adds an Evening dress to the cart
Given the user navigates to the store home page
When the user hovers over the "WOMEN" header
Then the submenu displays
When the user clicks on "Evening Dresses"
Then the page redirect to the "Evening Dress" page
When the user adds the "Printed Dress" to the cart
Then the page opens a frame
And the user clicks on the Continue Shopping button
When the user clicks on the Cart button2
Then the page redirect to the Cart page
