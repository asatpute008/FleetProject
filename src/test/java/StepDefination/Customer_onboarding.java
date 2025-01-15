package StepDefination;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjects.Base_class;
import PageObjects.Customer_objects;
import io.cucumber.java.en.*;

public class Customer_onboarding {
	WebDriver driver;
	
	public Customer_onboarding(WebDriver Ndriver) {
		this.driver=Ndriver;
	}
	
	public Customer_onboarding() {
		//No arguments
	}
	
	Signin login = new Signin(driver);
	String Company_name;
	String State ;
	
    @Given("^I am on dashboard(.*) and (.*)$")
    public void I_am_on_dashboard(String ID, String password) throws InterruptedException, AWTException, IOException {
    	login.I_have_login_panel();
    	login.i_provide_id_and_password(ID, password);
    	login.tap_on_submit_button();
    	login.user_should_be_logged_in();
    		
    }
    
	@When("^Open customer form$") 
	public void Open_customer_form() throws InterruptedException, IOException {
         Base_class base = new Base_class(login.driver);
		Customer_objects customer = new Customer_objects(login.driver);
		customer.click_on_customer_tab();
	    Thread.sleep(2000);
	    base.screen_shot("customerpage", "Customer");
    	customer.open_form();
		
	}
	
	
	@And("^Provide the company Details(.*) (.*) (.*) (.*)$")
	public void Provide_the_customer_Details(String C_name, String EIN, String rep_name, String website) throws InterruptedException, IOException {
		Company_name = C_name;
		Customer_objects Form = new Customer_objects(login.driver);
		Base_class base = new Base_class(login.driver);
		
		Form.Enter_Company_details(C_name, EIN, rep_name, website);
		Thread.sleep(1000);
		base.screen_shot("Company_details", "Customer");
		
		
	}
	
	@And("^Provide the company name(.*)$")
	public void Provide_the_company_name(String C_name) throws InterruptedException, IOException {
	    Company_name = C_name;
	    Customer_objects form = new  Customer_objects(login.driver);
	    
	    Thread.sleep(500);
	    form.Enter_Company_name(C_name);
	    Base_class base = new Base_class(login.driver);
		base.screen_shot("contactDetails", "Customer");
	    
		
	}
	
	@And("^Provide the contact Details(.*) (.*)$")
	public void Provide_the_contact_Details(String mobile, String email) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Form.Enter_Contact_Details(email, mobile);
		
		Base_class base = new Base_class(login.driver);
		base.screen_shot("contactDetails", "Customer");
	
	}
	
	@And("^Provide the alternate Details(.*) (.*)$")
	public void Provide_the_alternate_Details(String altmobile, String altemail) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Form.Enter_Alternate_Contact_Details(altemail, altmobile);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("AltDetails", "Customer");
	}
	
	@And("^Provide the Address Details(.*) (.*) (.*) (.*) (.*)$")
	public void Provide_the_address_Details(String Street, String City, String state, String post_code, String country) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		
		Form.Enter_address(Street, City, state, post_code, country);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("Address", "Customer");
		
	}
	
	@And("^Add_new_address_details(.*) (.*) (.*) (.*) (.*)$")
	public void Add_new_addrest_details(String Street, String City, String state, String post_code, String country) throws InterruptedException, IOException {
		 
		State = state;
		Customer_objects Form = new Customer_objects(login.driver);
		Form.New_Enter_address(Street, City, state, post_code, country);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("Address", "Customer");
	}
	
	@And("^Provide the bookvia with Email(.*)$")
	public void Provide_the_bookvia_email(String book_Email) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Form.Book_via_email(book_Email);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("viaEmail", "Customer");
		
	}
	
	@And("^Provide the bookvia with mobile(.*)$")
	public void Provide_the_bookvia_mobile(String book_phone) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Form.Book_via_Phone(book_phone);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("AltPhone", "Customer");
	}
	
	@And("^Provide the bookvia with website(.*)$")
	public void Provide_the_bookvia_website(String website) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Form.Book_via_Website(website);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("ViaWebsite", "Customer");
	}
	
	@And("^Provide the special_instructions(.*)$")
	public void Provide_the_special_instructions(String special_instruction) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		
		Form.Enter_special_instructions(special_instruction);
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("speciInstruction", "Customer");
		
	}
	
	@And("^Tap_On_Carrier_Tab$")
	public void tap_on_carrirer_Tab() throws InterruptedException {
		Thread.sleep(500);
		Customer_objects Form = new Customer_objects(login.driver);
		Form.Tap_Carrier_Tab();
	}
	
	@And("^Provide the Business hour(.*) (.*)$")
	public void Provide_the_business_hores(String startTime, String endTime) throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Form.bussines_hours(startTime,endTime);
		
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("BussinessHour", "Customer");
	}
	
	
	@When("^Submit the form$")
	public void Submit_the_form() throws InterruptedException, IOException {
		Customer_objects Form = new Customer_objects(login.driver);
		Thread.sleep(1000);
		Form.tap_customer_submit_button();
		
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("submitForm", "Customer");
	}
	
	@And("^Tap back button$")
	public void Tap_back_button() throws InterruptedException, IOException {
		Thread.sleep(500);
		login.driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[1]/div/div/button")).click();
		Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("submitForm", "Customer");
	}
	
	@When("^Add new address$")
	public void Add_ew_address() throws InterruptedException, IOException {
		Thread.sleep(500);
		Customer_objects Form = new  Customer_objects(login.driver);
		Form.add_new_address();
		 Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("NewAddress", "Customer");
	}
	
    @Then("^Verify_the_New_address$")
    public void Verify_the_New_address() throws InterruptedException, IOException {
    	Customer_objects Form = new  Customer_objects(login.driver);
		 Form.verify_the_new_address(State);
		 Thread.sleep(500);
		 Base_class base = new Base_class(login.driver);
		 base.screen_shot("Error", "Customer");
    }
    
	@Then("^Display Error response(.*)$")
	public void customerNot_added(String Error) throws InterruptedException, IOException {
		
		Customer_objects Form = new  Customer_objects(login.driver);
		 String Recived_value = Form.verify_mandatory_error(Error);
		 System.out.println(Recived_value);
		 Assert.assertEquals(Error, Recived_value);
		 Thread.sleep(500);
		Base_class base = new Base_class(login.driver);
		base.screen_shot("Error", "Customer");
		 
	}
	
	@Then("^customer successsfully added$")
	public void customer_successsfully_added() throws InterruptedException {
		Thread.sleep(1000);
		Customer_objects Form = new Customer_objects(login.driver);
	    String Result = Form.verify_customer_company_name(Company_name);
	    if(Result.equals("Available")) {
	    	System.out.println("Company successfully created");
	    }else {
	    	System.out.println("Company Not created ");
	    }
	    }
	
	
	@And ("^Close_Window$")
	public void close_window() {
		login.driver.quit();
	}
	
}
