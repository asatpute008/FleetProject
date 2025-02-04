package StepDefination;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObjects.Base_class;
import PageObjects.My_Load_Objects;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class My_Load {

	
	public static WebDriver driver;
	//Customer_onboarding login = new Customer_onboarding(driver);
	
	 Signin login = new Signin(driver);
     String PickupCustomer;
	
	@Given("^Open dashboard(.*) and (.*)$")
	public void I_am_on_dashboard(String ID, String Password) throws InterruptedException, AWTException, IOException {
		login.I_have_login_panel();
    	login.i_provide_id_and_password(ID, Password);
    	login.tap_on_submit_button();
    	login.user_should_be_logged_in();
	}
	
	@And("^Tap on My_load sub module$")
	public void Tap_on_My_load_sub_module() throws InterruptedException {	
		My_Load_Objects main = new My_Load_Objects(login.driver);
		
		Thread.sleep(2000);
		main.Tap_on_my_load();
	}
	
	@And("^Open Load form$")
	public void Open_Load_Form() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(2000);
	    main.Tap_on_create_load();
	}
	
	@And("^Provide load and transport type (.*)$")
	public void Provide_transport_type(String load_type) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(1000);
	    main.Select_Transport_Type(load_type);
	}
	
	@And("^Provide billing details (.*)$")
	public void Provide_billing_details(String Bill_value) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(1000);
	    main. Select_bill_To(Bill_value);
	}
	
	@And("^Delete_Po_number (.*)$")
	public void Provide_Po_number(String Ponumber) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		
	    Thread.sleep(500);
	    main.Delete_PO_number(4);
	    
	}
	
	@And("^Provide multiples_Po_number (.*) (.*)$")
	public void Provide_multiples_Po_number(String Ponumber, int NoOfPO ) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.Add_Multiple_PO_numbers(Ponumber, NoOfPO);
	}
	
	@And("^Provide order_number (.*)$")
	public void Provide_order_number(String OrderNumber) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.Enter_Order_Number(OrderNumber);
	}
	
	@And("^Provide shipping type (.*)$")
	public void Provide_shipping_type(int number) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.Enter_shipping_parameters(number);
	}
	
	@And("^Provide perticuler shipping (.*)$")
	public void Provide_shipping_type(String Name) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.tap_shipping_parameters(Name);
	}
	
	@And("^Select Pickup Date (.*)$")
	public void Provide_pickupDate(int DATE) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.pickupDate( DATE);
		
	}
	
	@When("^Tap on submit button$")
	public void Submit_form() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.tap_on_Submit_button();
	    Thread.sleep(5000);
	}
	
	@When("^Tap on Cancel button$")
	public void Cancel_form() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.tap_on_cancel_button();
	}
	
	@And("^Provide Shipper Name (.*)$")
	public void Provide_Shipper_Name(String Bill_value) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(1000);
	    String Customer = main.Select_bill_To(Bill_value);
		PickupCustomer = Customer;
	}
	
	@And("^Select Pickup Type FCFS$")
	public void Provide_FCFS() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.FCFS("07", "11");
		Thread.sleep(500);
	}
	
	@And("^Provide Comodity$")
	public void Provide_Comodity() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.commodity();		
	}
	
	@And("^Provide Weight$")
	public void Provide_Weight() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.pickupWeight();
		
	}
	
	@And("^Provide Pallets$")
	public void Provide_Pallets() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.Pallets();
		
	}
	
	@And("^Provide Pallets Number$")
	public void Provide_PalletsNumber() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.PalletsNumber();
		
	}
	
	@And("^Provide Units Number$")
	public void Provide_UnitsNumber() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.UnitsNumber();
	}
	
	@And("^Provide commodity instruction$")
	public void Provide_commInstruction() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.commodityInstruction();
	}
	
	@And("^Provide Equipments$")
	public void Provide_Equipments() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.Equipments();
	}
	
	@And("^Provide Temprature$")
	public void Provide_Temprature() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.Temprature();
	}
	
	@And("^Submit Pickup$")
	public void submitPickup() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		main.SubmitPickup();
	}
	
	@Then("^Basic information successfully submited (.*)$")
	public void Verify_form(String verify_po) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		
		    main.tap_on_basic_info();
		    Thread.sleep(500);
		    boolean verify = main.verify_PO_number(verify_po);
		    
		    if(verify == true) {
		    	System.out.println("Basic Information successfully submited");
		    }else {
		    	System.out.println("Basic information not submitted");
		    } 
		
	}
	
	@Then("^Display the error response on PO number (.*)$")
	public void verify_PO_Number(String Error) throws InterruptedException {
		boolean value = false;
				try {
					 Thread.sleep(500);
					 value = login.driver.findElement(By.xpath("//div[text()='" +Error+"']")).isDisplayed();
					
				}catch(NoSuchElementException e) {
					value = false;
				}
		
		if(value == true) {
			System.out.println("Display the error response when user not provide po number ");
		}
	}
	
	@Then("^Verify Pickup$")
	public void VerifyPickup() {
		
		String Actual_Name = login.driver.findElement(By.xpath("//div[@class='border border-border rounded-lg overflow-hidden  ']/div/div/div/div/div[2]/div")).getText();
		
		Assert.assertEquals(Actual_Name, PickupCustomer, "Pickup customer name does not match!");
		
	}
	
//	@After
//	public void AfterAll() {
//		
//		if (login.driver != null) { // Ensure WebDriver is initialized
//            Base_class actions = new Base_class(login.driver);
//            actions.close_window(); // Close the browser
//        } else {
//            System.out.println("WebDriver is null. Nothing to close.");
//        }
//		
//	}
//	
		
	
}
