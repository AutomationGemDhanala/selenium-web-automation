@AmazonProductSearch
Feature: Search for TOP two products from each specified products

  Scenario Outline: Search the products from Amazon and store top two products by cost into CSV
    Given Navigate to amazon website for product search
    When Enter the '<productNameForSearch>' for search box
    And Click on search button for each product
    And Select the sort by price descending order
    Then Retrieve all products with '<productNameForSearch>' and stored in '<csvFile>' file
    And Sort and store top two product for each product results in '<csvFile>' file

    Examples:
      | productNameForSearch  | csvFile                    |
      | "Bluetooth headset"   | src/test/resources/SC1.csv |
      | "34 inch LED monitor" | src/test/resources/SC2.csv |
      | "USB c dock"          | src/test/resources/SC3.csv |
      | "Smart watch"         | src/test/resources/SC4.csv |
