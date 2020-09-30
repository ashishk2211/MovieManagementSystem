package com.cg.moviemanagement.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/viewBooking.feature", 
glue = {"com.cg.moviemanagement.stepdefinition"},tags = {"@ViewBooking,@BookingNotAvailable"},
plugin = {"pretty","html:target/cucumber-htmlrepo"})

public class TestRunner {


}

