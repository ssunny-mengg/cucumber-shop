Feature: Cut Stock
  As a customer
  I want to buy products

  Background:
    Given the store is ready to service customers
    And a product "Bread" with price 20.50 and stock of 5 exists
    And a product "Jam" with price 80.00 and stock of 10 exists
    And a product "Butter" with price 100.00 and stock of 20 exists

  Scenario: Cut stock
    When I buy "Butter" with quantity 10
    Then total should be 1000.00
    Then quantity remaining in stock of "Butter" should be 10

  Scenario Outline: Cut stock in table
    When I buy <product> with quantity <quantity>
    Then <product> stock should be <quantity_in_stock>
    Examples:
      | product       | quantity      | quantity_in_stock     |
      | "Bread"       | 1             | 4                     |
      | "Jam"         | 2             | 8                     |
      | "Butter"      | 10            | 10                    |