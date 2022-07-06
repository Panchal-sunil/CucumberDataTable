@tag
Feature: To create the teleocm id
  
  @tag1
  Scenario: To validate telicom add a customer functionality
    Given user is in telecom homepage and add customer 
    When user enter the all the cutomer details in the field
    |sunil|p|sunil@gmail.com|karnataka|00000000|
   #|manish|varma|verma@gmail.com|Hyderabad|7845129630| #this line is use for asLists
    And user clicks the submit button
    Then registration id will be generated

 