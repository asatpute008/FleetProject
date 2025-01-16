package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Load_Objects {

	WebDriver Idriver;
	
	public My_Load_Objects(WebDriver Ldriver){
		Idriver = Ldriver;		
		PageFactory.initElements(Idriver, this);	
	}
	
	public My_Load_Objects() {
		//No arguments
	}
	
	@FindBy(xpath="//span[text()='My Load']")
	WebElement MY_Load_Sub_Menu;

	
	
	public void Tap_on_my_load(){
		MY_Load_Sub_Menu.click();
	}
	
	//Filter Tabs
	public void Tap_on_Filter_Tab(String Tab_name){
		Idriver.findElement(By.xpath("//div[text()='"+Tab_name+"']")).click();
	}
	
	//Create Load 
	public void Tap_on_create_load() {
		Idriver.findElement(By.xpath("//button[text()='Create Load']")).click();
	}
	
	//Transport type
		public void Select_Transport_Type(String transportType){
			Idriver.findElement(By.xpath("//div[text()='"+transportType+"']")).click();
		}
		
	//Select Bill to 
		public void Select_bill_To() {
			Idriver.findElement(By.xpath("//input[@class='m_8fb7ebe7 mantine-Input-input mantine-InputBase-input']"));
			
			List<WebElement> rows = Idriver.findElements(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option']"));
			
			if(rows.size()== 0) {
				System.out.println(rows.size()+ " - Rows not avaialable");
			}
		}
		
}
