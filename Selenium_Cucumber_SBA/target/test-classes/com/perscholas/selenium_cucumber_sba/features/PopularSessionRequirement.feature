Feature: The user adds items to cart and views cart

Scenario: The user adds items to the shopping cart
Given the user navigates to the My Store page
When the user add items to the shopping cart
Then the page opens an adding frame
When the user clicks on the Cart button
Then the user is redirected to the Order - My Store page