package StepDefination;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Load_Objects;
import io.cucumber.java.en.*;

public class My_Load {

	
	WebDriver driver;
	//Customer_onboarding login = new Customer_onboarding(driver);
	
	 Customer_onboarding login;

	    public My_Load() {
	        // Initialize the WebDriver (e.g., ChromeDriver)
	        this.driver = new ChromeDriver();
	        this.login = new Customer_onboarding(driver);
	    }
	
	@Given("^Open dashboard(.*) and (.*)$")
	public void I_am_on_dashboard(String ID, String Password) throws InterruptedException, AWTException, IOException {
		
		login.I_am_on_dashboard(ID, Password);
	}
	
	@And("^Tap on My_load sub module$")
	public void Tap_on_My_load_sub_module() throws InterruptedException {
		Load_Objects Menu = new Load_Objects(login.driver);
		Thread.sleep(1000);
		Menu.Tap_on_my_load();
	}
	
}
