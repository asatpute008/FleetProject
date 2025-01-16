package StepDefination;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import PageObjects.My_Load_Objects;
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
		My_Load_Objects Menu = new My_Load_Objects(login.driver);
		Thread.sleep(1000);
		Menu.Tap_on_my_load();		
		Thread.sleep(1000);
	    Menu.Tap_on_create_load();
	    Thread.sleep(1000);
	    Menu.Select_Transport_Type("FTL (Full Truckload)");
	    Thread.sleep(1000);
	    Menu.Select_Transport_Type("LTL (Less Than Truckload)");
	    Thread.sleep(1000);
	    Menu. Select_bill_To(null);
	    Thread.sleep(500);
	    Menu.Add_Multiple_PO_numbers("1124", 5);
	    Thread.sleep(500);
	    Menu.Delete_PO_number(5);
	    
	}
	
}
