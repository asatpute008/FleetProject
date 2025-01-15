package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Load_Objects {

	WebDriver Idriver;
	
	public Load_Objects(WebDriver Ldriver){
		Idriver = Ldriver;		
		PageFactory.initElements(Idriver, this);	
	}
	
	public Load_Objects() {
		//No arguments
	}
	
	@FindBy(xpath="//span[text()='My Load']")
	WebElement MY_Load_Sub_Menu;

	public void Tap_on_my_load(){
		MY_Load_Sub_Menu.click();
	}
	
}
