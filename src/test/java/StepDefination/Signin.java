package StepDefination;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import PageObjects.Base_class;
import PageObjects.Login_objects;
import io.cucumber.java.en.*;

public class Signin {


	WebDriver driver;
	public Signin(WebDriver cdriver) {
		this.driver = cdriver;		
		PageFactory.initElements( cdriver, this);
	}
	ChromeOptions options = new ChromeOptions();
	

    public Signin() {
        // No-argument constructor
    }
    
	@SuppressWarnings("deprecation")
	@Given("^I have login panel-test$")	
	public void I_have_login_panel() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aniket Satpute\\eclipse-workspace\\FleetProject\\src\\test\\resources\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		options.setHeadless(false); // Disable headless mode
		driver = new ChromeDriver(options);

		Base_class chrom = new Base_class(driver);
		chrom.open_chrome();
		driver.manage().window().maximize();

	}
	
	

	@When("^I provide (.*) and (.*)-test$")
	public void i_provide_id_and_password(String ID, String password) {

		Login_objects  login = new Login_objects(driver);
		login.enterEmail(ID);
		login.enterPassword(password);
	}
	
	

	@And("^Tap on submit button-test$")
	public void tap_on_submit_button() throws InterruptedException {

		Login_objects  login = new Login_objects(driver);
		login.Tap_signIn_button();
		Thread.sleep(5000);		
	}
	
	

	@Then("^User should be logged in-test$")
	public void user_should_be_logged_in() throws AWTException, InterruptedException, IOException {

		Base_class Base_details = new Base_class(driver);
		String site = Base_details.Dashboard_Link;
		String login_page = Base_details.baseURL;
		String actual_site = driver.getCurrentUrl();

		System.out.println(actual_site);
		if(actual_site.equals(site)) {
			System.out.println("successfully logged in");				
			Base_details.screen_shot("Login", "Signing");
			
		}else {
			if(actual_site.equals(login_page)) {
				
				Login_objects login = new Login_objects(driver);
				
				boolean modal_text;
				try {
					// Locate the element and check if it's displayed
					modal_text = login.Excluxive_modal_title("Single Device Sign In");
				} catch (NoSuchElementException e) {
					// Element not found; modal_text remains false
					modal_text = false;
				}

				if(modal_text == true) {

					login.Tap_exclusiv_signin_button();
					Thread.sleep(3000);					
					Base_details.screen_shot("Login", "Signing");

				}else{
					System.out.println("Faild to logged in");
					Base_details.screen_shot("Fail", "Signing");				
				}

			}else {

				System.out.println("Faild to logged in");
				Base_details.screen_shot("Fail", "Signing");			
			}
		}

	}
	
	@And("^Close Window$")
	public void close_window() {
		Base_class Base_details = new Base_class(driver);
		Base_details.close_window();
	}

}
