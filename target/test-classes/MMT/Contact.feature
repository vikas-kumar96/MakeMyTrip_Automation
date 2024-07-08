
@tag
Feature: MMT Scenarios

  @tag1
  Scenario: Validate the MakeMyTrip Page
    Given  Navigate to makemytrip.com
    And Click on hotels
    And Enter location Munnar, Date 28 July to 31 July, Room 1, Adult 2 and apply
    When Price per night max 5000/-
    And Click on search
    And Validate that the result is visible a. List the hotel's name
    When Filter result a. breakfast include b. Rating 3.5+ c. room view = mountain view
    And Select Hotel Blanket Hotel & Spa Munnar
    And Add guest details and click on Pay now
    Then Validate payment page is visible a. Validate hotel name b. Validate booking dates
    

  #@tag2
  #Scenario Outline: Validate the contact us page
    #Given User has landed on Sparsh website in chrome
    #When user enters "<firstname>","<lastname>","<email>","<phone>"
    #And selects hospital and for general enquiry
    #Then a message is displayed after successful form filling
#
    #Examples: 
      #| firstname  | lastname  | email              | phone     |
      #| john       |  smith    | vk@gmail.com       |9736672340 |
      #| karan      |  johar    | vk12@gmail.com     |9137878128 |
      #| vikas      |  kumar    | vk123@gmail.com    |9137878458 |
