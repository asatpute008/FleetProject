package StepDefination;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import PageObjects.My_Load_Objects;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class My_Load {

	
	WebDriver driver;
	//Customer_onboarding login = new Customer_onboarding(driver);
	
	 Signin login = new Signin(driver);

	
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
		Thread.sleep(1500);
		main.Tap_on_my_load();
	}
	
	@And("^Open Load form$")
	public void Open_Load_Form() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(1500);
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
	
	@When("^Tap on submit button$")
	public void Submit_form() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.tap_on_Submit_button();
	}
	
	@When("^Tap on Cancel button$")
	public void Cancel_form() throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		Thread.sleep(500);
	    main.tap_on_cancel_button();
	}
	
	@Then("^Basic information successfully submited (.*)$")
	public void Verify_form(String verify_po) throws InterruptedException {
		My_Load_Objects main = new My_Load_Objects(login.driver);
		
		   Thread.sleep(5000);
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
	public void verify_PO_Number(String Error) {
		boolean value = false;
				try {
					login.driver.findElement(By.xpath("//div[text()='" +Error+"']")).isDisplayed();
					value = true;
				}catch(NoSuchElementException e) {
					value = false;
				}
		
		if(value == true) {
			System.out.println("Display the error response when user not provide po number ");
		}
	}
	
	@After
	public void AfterAll() {
		Signin Action = new Signin(login.driver);
		Action.close_window();
		
	}
	
		
	
}
