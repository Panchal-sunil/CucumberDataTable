package org.cucumber;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DataTable {

	WebDriver driver;
	@Given("user is in telecom homepage and add customer")
	public void user_is_in_telecom_homepage_and_add_customer() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mathaiah\\eclipse-workspace\\CucumberDataTable\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	
	}

	@When("user enter the all the cutomer details in the field")
	public void user_enter_the_all_the_cutomer_details_in_the_field(io.cucumber.datatable.DataTable values) throws InterruptedException {
		List<String> li = values.asList(String.class);
		
		//use for two dimensional "asLists"
	//	List<List<Object>> li = values.asLists(String.class);
		
		driver.findElement(By.xpath("//label[@for= 'done']")).click();
		
		//this is one dimensional List "asList"
		driver.findElement(By.id("fname")).sendKeys(li.get(0));
		driver.findElement(By.id("lname")).sendKeys(li.get(1));
		driver.findElement(By.id("email")).sendKeys(li.get(2));
		driver.findElement(By.id("message")).sendKeys(li.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(li.get(4));
		Thread.sleep(4000);
		
	/*	//this is two dimensional List "asLists"
		driver.findElement(By.id("fname")).sendKeys(li.get(0).get(0));
		driver.findElement(By.id("lname")).sendKeys(li.get(1).get(1));
		driver.findElement(By.id("email")).sendKeys(li.get(0).get(2));
		driver.findElement(By.id("message")).sendKeys(li.get(1).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(li.get(0).get(4));
		Thread.sleep(4000);
	*/		
	}

	@When("user clicks the submit button")
	public void user_clicks_the_submit_button() throws InterruptedException {
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click",driver.findElement(By.name("submit")));
		Thread.sleep(4000);
	
	}

	@Then("registration id will be generated")
	public void registration_id_will_be_generated() {
	
		String id = driver.getCurrentUrl();
		Assert.assertTrue(id.contains("uid"));
		
	}


}
