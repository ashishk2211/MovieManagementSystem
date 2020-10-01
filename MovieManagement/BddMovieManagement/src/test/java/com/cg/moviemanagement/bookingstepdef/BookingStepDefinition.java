package com.cg.moviemanagement.bookingstepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingStepDefinition {
	
WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\capg\\BDD Material\\chrome driver\\SeleniumExample\\mydriver\\chromedriver.exe" );
		
		driver= new ChromeDriver();
	}
	
	@Given("^user is on booking page$")
	public void user_is_on_booking_page() throws Throwable {
		driver.get("C:\\html\\booking.html");
	    
	}

	@When("^user enters invalid username$")
	public void user_enters_invalid_username() throws Throwable {
		WebElement userName=driver.findElement(By.name("bookForm.userName"));
	    WebElement submitBtn=driver.findElement(By.className("btn"));
	    userName.sendKeys("");
	    submitBtn.click();
		
	  }

	@Then("^displays 'Please enter valid username'$")
	public void displays_Please_enter_valid_username() throws Throwable {
		String expectedMessage="";
		WebElement msg=driver.findElement(By.name("bookForm.userName"));
		String actualMessage= msg.getText();
		Assert.assertEquals(expectedMessage,actualMessage);
		
	    
	}

	@When("^user enters invalid contact number$")
	public void user_enters_invalid_contact_number() throws Throwable {
		WebElement userName=driver.findElement(By.name("bookForm.userName"));
		WebElement contact= driver.findElement(By.name("bookForm.contact"));
	    WebElement submitBtn=driver.findElement(By.className("btn"));
	    userName.sendKeys("Arushi");
	    contact.sendKeys("");
	    submitBtn.click();
		
	    
	}

	@Then("^displays 'Please enter (\\d+) digit contact number'$")
	public void displays_Please_enter_digit_contact_number(int arg1) throws Throwable {
		String expectedMessage= "";
		WebElement msg= driver.findElement(By.name("bookForm.contact"));
		String actualMessage=msg.getText();
		Assert.assertEquals(expectedMessage,actualMessage);
	    
	}
	@When("^user leaves the field empty$")
	public void user_leaves_the_field_empty() throws Throwable {
		WebElement userName=driver.findElement(By.name("bookForm.userName"));
		WebElement contact= driver.findElement(By.name("bookForm.contact"));
		WebElement tickets= driver.findElement(By.name("bookForm.tkts"));
	    WebElement submitBtn=driver.findElement(By.className("btn"));
	    userName.sendKeys("Arushi");
	    contact.sendKeys("8728925856");
	    tickets.sendKeys("");
	    submitBtn.click();
		
	    
	}

	@Then("^displays 'Please enter required no\\.of tickets'$")
	public void displays_Please_enter_required_no_of_tickets() throws Throwable {
		String expectedMessage="";
		WebElement msg=driver.findElement(By.name("bookForm.tkts"));
		String actualMessage=msg.getText();
		Assert.assertEquals(expectedMessage,actualMessage);
		
	    
	}

	@When("^user enters valid details$")
	public void user_enters_valid_details() throws Throwable {
		WebElement userName=driver.findElement(By.name("bookForm.userName"));
		WebElement contact= driver.findElement(By.name("bookForm.contact"));
		WebElement tickets=driver.findElement(By.name("bookForm.tkts"));
	    WebElement submitBtn=driver.findElement(By.className("btn"));
	    tickets.sendKeys("2");
	    
	}

	@Then("^displays 'Booking Successfully Completed'$")
	public void displays_Booking_Successfully_Completed() throws Throwable {
		driver.get("C:\\html\\success.html");
		driver.close();
	   
	}

}



