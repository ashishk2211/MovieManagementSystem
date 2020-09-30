Feature: View Booking in movie management

@ViewBooking
Scenario: View booking using contact number
Given User is on booking page
When User enter valid contact number
Then User get the booking details


@BookingNotAvailable
Scenario: View booking using invalid contact number
Given User is on booking page
When User enter wrong contact number
Then User get the message Booking Not Available.