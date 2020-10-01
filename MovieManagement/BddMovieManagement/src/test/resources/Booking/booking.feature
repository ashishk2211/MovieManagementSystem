Feature: booking feature in movie management application

Scenario: Invalid user name
Given user is on booking page
When user enters invalid username
Then displays 'Please enter valid username'

Scenario: Invalid contact number
Given user is on booking page
When user enters invalid contact number
Then displays 'Please enter 10 digit contact number'

Scenario: Empty number of tickets
Given user is on booking page
When user leaves the field empty
Then displays 'Please enter required no.of tickets'

Scenario: Valid Booking Details
Given user is on booking page
When user enters valid details
Then displays 'Booking Successfully Completed'