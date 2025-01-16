package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	
//PO number 
	@FindBy(xpath="//input[@placeholder='Enter PO Number']")
	WebElement PO_Number;
	
	@FindBy(xpath="//div/button[text()='Add Another PO Number']")
	WebElement Add_Another_Number;
	
	@FindBy(xpath="//div[@class='px-3 h-full flex items-center justify-center border-l border-border']")
	WebElement delete_Po_number;
	//"//div[@class='w-full flex flex-col gap-2']/div[2]/div"
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
		public void Select_bill_To(String Values) {
			
			Idriver.findElement(By.xpath("//input[@class='m_8fb7ebe7 mantine-Input-input mantine-InputBase-input']")).click();
			
			List<WebElement> rows = Idriver.findElements(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option']"));
				
			if(rows.size()== 0){
				System.out.println(rows.size()+ " - Rows not avaialable");
			}else if(Values != null) {
				Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option' and text()='"+Values+"']")).click();
				System.out.println("Find using value" + Values);
			}else if(rows.size()>0) {
				Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option']")).click();
				
				System.out.println("Add first 1");
			}else {
				System.out.println("Conditon not matched for select bill to ");
				
			}
		}
		
		public void Add_Single_PO_numbers(String PO_number) {
			
			PO_Number.sendKeys(PO_number);
		}
		
		public void Add_Multiple_PO_numbers(String PO_number, int PO_qnt) throws InterruptedException{
			PO_Number.sendKeys(PO_number);
			Thread.sleep(500);
			for(int i = 1; i< PO_qnt; i++){
				Thread.sleep(700);
				Actions tap = new Actions(Idriver);
				tap.moveToElement(Add_Another_Number).click().perform();
//				Add_Another_Number.click();
				Thread.sleep(500);
				PO_Number.sendKeys(PO_number +i);
			}
		}
		
		public void Delete_PO_number(int Delete_PO) throws InterruptedException {
			for(int i =0; i<Delete_PO; i++) {
				Thread.sleep(500);
				delete_Po_number.click();
			}
		}
}
