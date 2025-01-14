package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_objects {
	
	WebDriver Idriver;
	
	public Login_objects(WebDriver rdriver) {
		
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

    public Login_objects() {
        // No-argument constructor
    }
    
	//Login Page 
	@FindBy(xpath = "//input[@type='email']")
	WebElement Email_Input_Box;
	
	@FindBy(xpath = "//label[text()='Email Address']")
	WebElement Email_Input_Box_text;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password_Input_Box;
	
	@FindBy(xpath = "//label[text()='Password']")
	WebElement Password_Input_Box_text;
	
	@FindBy(xpath = "//div[@class='cursor-pointer px-2']")
	WebElement Password_eye_icon;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement SignIn_button;
	
	@FindBy (xpath = "//h1[@class='text-textPrimary']")
	WebElement Login_Page_Title;
	
	@FindBy (xpath = "//p[@class='text-base font-normal text-textSecondary']")
	WebElement Login_Page_description;
	
	@FindBy (xpath = "//a[text()='Create Account']")
	WebElement Create_New_account_button;
	
	
	//Exclusive signin modal
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement exclusive_Signin_button;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement exclusive_Cancel_button;
	
	@FindBy(xpath = "//h2[@class='mb-2']")
	WebElement exclusive_Title_text;
	
	@FindBy(xpath = "//p[@class='text-textSecondary']")
	WebElement exclusive_description_text;
	
	public void enterEmail(String Email) {
		Email_Input_Box.sendKeys(Email);
	}
	
	public boolean get_email_text(String Email_text) {
		
	    boolean validate_email_text = Email_Input_Box_text.isDisplayed();    	    
	    Assert.assertEquals(Email_Input_Box_text.getText(), Email_text);	    
		return validate_email_text;
	}
	
	
	public void enterPassword(String password) {
		Password_Input_Box.sendKeys(password);
	}
	
	public boolean get_password_text(String password_text) {
	    boolean validate_password_text = Password_Input_Box_text.isDisplayed();    	    
	    Assert.assertEquals(Password_Input_Box_text.getText(), password_text);	    
		return validate_password_text;
	}
	
	public void tap_eye_icon() {    
		Password_eye_icon.click();
	}
	
	public void tap_Create_new_account() {    
	    Create_New_account_button.click();
	}
	
	
	public void Tap_signIn_button() {
		SignIn_button.click();
	}
	
	public void Tap_exclusiv_signin_button() {
		exclusive_Signin_button.click();;
	}
	
	public void Tap_exclusiv_cancel_button() {
		exclusive_Cancel_button.click();
	}
	
	public boolean Excluxive_modal_title(String Title) {
		
		boolean Get_title = exclusive_Title_text.isDisplayed();
		
		Assert.assertEquals(exclusive_Title_text.getText(), Title);
		return Get_title;
	}
	
     public boolean Excluxive_modal_description(String Description) {
		
		boolean Get_description = exclusive_Title_text.isDisplayed();
		
		Assert.assertEquals(exclusive_description_text.getText(), Description);
		return Get_description;
	}
}
