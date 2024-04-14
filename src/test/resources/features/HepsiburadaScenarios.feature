Feature: Hepsiburada Mobile Scenarios

  Background:
    Given Click "close.toastAdvertButton" close advert button
    And Click "close.advertButton" close advert button

  Scenario: Scenario 1
    When Click "homepage.myAccount" element
    And Click "myAccount.login" element
    And Wait for given seconds 1
    And Fill "input.email" field with "melisaycatest@gmail.com"
    And Fill "input.password" field with "MinikTest5"
    And Click "myAccount.loginButton" element
    And Wait for given seconds 1
    Then Check equality of element text "assert.successLoginText" and with text "Hepsiburada"

  Scenario: Scenario 2
    When Click "input.searchbar" element
    And Fill "input.searchbar" field with "Lenovo"
    And Wait for given seconds 1
    And Enter keyboard
    And Click "categories.filterButton" element
    And Click "filter.priceAreaButton" element
    And Wait for given seconds 1
    And Fill "input.filter.minPrice" field with "8000"
    And Fill "input.filter.maxPrice" field with "20000"
    And Click "filter.applyButton" element
    And Wait for given seconds 1
    And Click "filter.getAllProduct" element
    And Wait for given seconds 1
    And Click "product.firstProduct" element
    And Wait for given seconds 1
    Then Check equality of element text "assert.addToBasketText" and with text "Sepete ekle"

