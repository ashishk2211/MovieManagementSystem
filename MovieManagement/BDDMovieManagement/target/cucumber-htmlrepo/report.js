$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/viewBooking.feature");
formatter.feature({
  "line": 1,
  "name": "View Booking in movie management",
  "description": "",
  "id": "view-booking-in-movie-management",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "View booking using contact number",
  "description": "",
  "id": "view-booking-in-movie-management;view-booking-using-contact-number",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@ViewBooking"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on booking page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User enter valid contact number",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User get the booking details",
  "keyword": "Then "
});
formatter.match({
  "location": "ViewBooking.user_is_on_booking_page()"
});
formatter.result({
  "duration": 9156107000,
  "status": "passed"
});
formatter.match({
  "location": "ViewBooking.user_enter_valid_contact_number()"
});
formatter.result({
  "duration": 282070500,
  "status": "passed"
});
formatter.match({
  "location": "ViewBooking.user_get_the_booking_details()"
});
formatter.result({
  "duration": 149000,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "View booking using invalid contact number",
  "description": "",
  "id": "view-booking-in-movie-management;view-booking-using-invalid-contact-number",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@BookingNotAvailable"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "User is on booking page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User enter wrong contact number",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User get the message Booking Not Available.",
  "keyword": "Then "
});
formatter.match({
  "location": "ViewBooking.user_is_on_booking_page()"
});
formatter.result({
  "duration": 7092296000,
  "status": "passed"
});
formatter.match({
  "location": "ViewBooking.user_enter_wrong_contact_number()"
});
formatter.result({
  "duration": 348336200,
  "status": "passed"
});
formatter.match({
  "location": "ViewBooking.user_get_the_message_Booking_Not_Available()"
});
formatter.result({
  "duration": 63062900,
  "status": "passed"
});
});