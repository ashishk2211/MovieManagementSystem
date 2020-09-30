package com.cg.moviemanagement.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ViewBooking {
	
	WebDriver driver;
	
	@Given("^User is on booking page$")
	public void user_is_on_booking_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CyberTroN\\Documents\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/bookingDetails");
		driver.manage().window().maximize();

	}

	@When("^User enter valid contact number$")
	public void user_enter_valid_contact_number() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Enter your reg. contact']"))
		.sendKeys("8283037007");
	    driver.findElement(By.xpath("//input[@class='btn btn-info']")).click();
	   
	}

	@Then("^User get the booking details$")
	public void user_get_the_booking_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("Booking details exist");
	}
	
	@When("^User enter wrong contact number$")
	public void user_enter_wrong_contact_number() throws Throwable {
		System.out.println("Inside invalid credentials");
		driver.findElement(By.xpath("//input[@placeholder='Enter your reg. contact']"))
		.sendKeys("7905416100");
	    driver.findElement(By.xpath("//input[@class='btn btn-info']")).click();
		
	}

	@Then("^User get the message Booking Not Available\\.$")
	public void user_get_the_message_Booking_Not_Available() throws Throwable {
	   String errorMsg="Booking Not Available";
	   String actualMsg=driver.findElement(By.xpath("//p[contains(text(),'Booking Not Available')]")).getText();
	   Assert.assertEquals(actualMsg,errorMsg);
	   System.out.println("Booking Not Available");
	}


}
