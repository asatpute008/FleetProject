package PageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_objects {
	
	WebDriver Idriver;
	
	public Customer_objects(WebDriver cdriver) {
		
		Idriver = cdriver;
		
		PageFactory.initElements(cdriver, this);
	}
	
	
	@FindBy(xpath = "//span[text()='Customers' and @class='whitespace-nowrap overflow-hidden flex-1']")
	WebElement Menu_customer_Tab;
	
	@FindBy(xpath = "//html/body/main/div/div[2]/div[2]/div/div[1]/div/div/div/div[2]/button")
	WebElement Onboarding_button;

	//Company Details
	@FindBy (xpath = "//input[@name='companyName' and @placeholder='Enter Customer Name']")
	WebElement company_name_field;
	
	@FindBy (xpath = "//div[@class='h-full overflow-x-hidden overflow-y-scroll relative grow p-6']//input[@name='companyName' and @placeholder='Enter Customer Name']")
	WebElement New_company_name_field;
	
	@FindBy (xpath = "//input[@placeholder='Enter EIN Number']")
	WebElement EIN_field;
	
	@FindBy (xpath = "//input[@placeholder='Enter Representative Name']")
	WebElement Representetive_name_field;
	
	@FindBy (xpath = "//input[@placeholder='Enter Website']")
	WebElement Enter_website_field;
	
	//Contact Details
	@FindBy (xpath = "//input[@placeholder='Enter Email']")
	WebElement Enter_Email_field;
	
	@FindBy (xpath = "//input[@placeholder='Enter Alternative Email']")
	WebElement Enter_Alternative_Email_field;
	
	@FindBy (xpath = "//input[@placeholder='Enter Phone Number']")
	WebElement Enter_Phone_number_field;
	
	@FindBy (xpath = "//input[@placeholder='Enter Alternative Phone Number']")
	WebElement Enter_Alternate_Phone_number_field;
	
	@FindBy (xpath = "//input[@placeholder='Select Book via']")
	WebElement Enter_Book_Via_field;
	
	@FindBy (xpath = "//div[@class='m_92253aa5 mantine-Select-option m_390b5f4' and @value='Email']")
	WebElement Enter_Book_Via_Email_field;
	
	@FindBy (xpath = "//div[@class='m_92253aa5 mantine-Select-option m_390b5f4' and @value='Phone']")
	WebElement Enter_Book_Via_Phone_field;
	
	@FindBy (xpath = "//div[@class='m_92253aa5 mantine-Select-option m_390b5f4' and @value='Phone']")
	WebElement Enter_Book_Via_Website_field;

	@FindBy (xpath = "//input[@placeholder='Enter Book Via']")
	WebElement Book_Via_field;
	
	//Address
	@FindBy (xpath = "//input[@placeholder='Enter street name']")
	WebElement Enter_Street;
	@FindBy (xpath = "//div[@class='h-full overflow-x-hidden overflow-y-scroll relative grow p-6']//input[@placeholder='Enter street name']")
	WebElement Enter_New_Street;
	
	@FindBy (xpath = "//input[@placeholder='City']")
	WebElement Enter_City;
	@FindBy (xpath = "//div[@class='h-full overflow-x-hidden overflow-y-scroll relative grow p-6']//input[@placeholder='City']")
	WebElement Enter_New_City;
	
	@FindBy (xpath = "//input[@placeholder='Province/State']")
	WebElement Enter_State;
	@FindBy (xpath = "//div[@class='h-full overflow-x-hidden overflow-y-scroll relative grow p-6']//input[@placeholder='Province/State']")
	WebElement Enter_New_State;
	
	@FindBy (xpath = "//input[@placeholder='Postal Code/Zip Code']")
	WebElement Enter_post_code;
	@FindBy (xpath = "//div[@class='h-full overflow-x-hidden overflow-y-scroll relative grow p-6']//input[@placeholder='Postal Code/Zip Code']")
	WebElement Enter_New_post_code;

	@FindBy (xpath = "//input[@placeholder='Country']")
	WebElement Enter_Country;
	@FindBy (xpath = "//div[@class='h-full overflow-x-hidden overflow-y-scroll relative grow p-6']//input[@placeholder='Country']")
	WebElement Enter_New_Country;
	
	
	//Special Instructions
	@FindBy (xpath = "//textarea[@placeholder='Enter special instructions for this customer...']")
	WebElement Enter_Special_instruction;
	
	//Business Hours 
	@FindBy (xpath="//div[@class='w-10 h-5 p-[3px] shadow-inner rounded-full flex justify-end bg-primary  items-center']")
	WebElement Day_toggle;
	
	@FindBy (xpath="//input[@class='m_8fb7ebe7 mantine-Input-input mantine-Select-input' and @placeholder='Select...' and @id='mantine-79gaijvxa']")
	WebElement StartTime;
	
	@FindBy (xpath="//input[@class='m_8fb7ebe7 mantine-Input-input mantine-Select-input' and @placeholder='Select...' and @id='mantine-3zntdecar']")
	WebElement EndTime;
	
	@FindBy (xpath="//button[text()='Submit']")
	WebElement Submit_button;
	
	//Add New Address
    @FindBy (xpath="/html/body/main/div/div[2]/div[2]/div/div[1]/div/div/div/div[2]/button[1]")
    WebElement Add_New_Address_Button;
    
    //Carrier Tab
    @FindBy (xpath="//button[@class='flex-1 relative px-6 py-1.5 text-base font-semibold rounded-md transition-colors duration-200 text-white/70 hover:text-white']")
    
    WebElement Carrier_Tab;
	
	public void click_on_customer_tab() {
		Assert.assertEquals( Menu_customer_Tab.getText(), "Customers");
		Menu_customer_Tab.click();	
	}
	
	public void open_form() {
		
	  Assert.assertEquals("Onboard Customer", Onboarding_button.getText());
      Onboarding_button.click();
	}
	
	public void Enter_Company_details(String comapny_name, String EIN, String rep_name, String website) throws InterruptedException {
		 Thread.sleep(1000);
		 company_name_field.sendKeys(comapny_name);	 
		 EIN_field.sendKeys(EIN);
		 Representetive_name_field.sendKeys(rep_name);
		 Enter_website_field.sendKeys(website);
		 
	}
	
	public void Enter_Company_name(String comapny_name) throws InterruptedException {
		 Thread.sleep(1000);
		 company_name_field.sendKeys(comapny_name);	 	 
	}
	
	public void Enter_Contact_Details(String Email_address, String Phone_number) throws InterruptedException {
		 Thread.sleep(1000);
		 Enter_Email_field.sendKeys(Email_address);
		 Enter_Phone_number_field.sendKeys(Phone_number);
		 
	}
	
	public void Enter_Alternate_Contact_Details(String Email_address, String Phone_number) throws InterruptedException {
		 Thread.sleep(1000);
		 Enter_Alternative_Email_field.sendKeys(Email_address);
		 Enter_Alternate_Phone_number_field.sendKeys(Phone_number);
		 
	}
	
	public void Book_via_email(String Book_Email) throws InterruptedException {
		
		Enter_Book_Via_field.click();
		Thread.sleep(1000);
		Enter_Book_Via_Email_field.click();
		Thread.sleep(1000);
		Book_Via_field.sendKeys(Book_Email);
	}
	
	public void Book_via_Phone(String Book_Phone) throws InterruptedException {
		
		Enter_Book_Via_field.click();
		Thread.sleep(1000);
		Enter_Book_Via_Email_field.click();
		Thread.sleep(1000);
		Book_Via_field.sendKeys(Book_Phone);
		
	}
   public void Book_via_Website(String Book_Website) throws InterruptedException {
		
		Enter_Book_Via_field.click();
		Thread.sleep(1000);
		Enter_Book_Via_Email_field.click();
		Thread.sleep(1000);
		Book_Via_field.sendKeys(Book_Website);
	}
	
   public void Enter_address(String Street, String City, String State, String Post_code, String Country) {
	   Enter_Street.sendKeys(Street);
	   Enter_City.sendKeys(City);
	   Enter_State.sendKeys(State);
	   Enter_post_code.sendKeys(Post_code);
	   Enter_Country.sendKeys(Country);
   }
   
   public void New_Enter_address(String Street, String City, String State, String Post_code, String Country) {
	   Enter_New_Street.sendKeys(Street);
	   Enter_New_City.sendKeys(City);
	   Enter_New_State.sendKeys(State);
	   Enter_New_post_code.sendKeys(Post_code);
	   Enter_New_Country.sendKeys(Country);
   }
   
   public void Enter_special_instructions(String paragraph) throws InterruptedException{
	   
	   Thread.sleep(1000);
	   Enter_Special_instruction.sendKeys(paragraph);
   }
   
   //Submit Button
   public void tap_customer_submit_button() {		  
		  Submit_button.click();
	  }
   
   //Business hourse 
   public void bussines_hours(String start_time, String end_time) throws InterruptedException {
	   Thread.sleep(1000);
	  try { WebElement element = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[1]/div[1]/div/div/div[2]"));
	   Actions actions = new Actions(Idriver);
	   actions.moveToElement(element).click().perform();
	   Thread.sleep(500);
	   
	   WebElement element2 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/div/div/input"));
	   actions.moveToElement(element2).click().perform();
	   element2.sendKeys(start_time);
	   Thread.sleep(500);
	   Idriver.findElement(By.xpath("//span[text()='"+start_time+"']")).click(); 
	   
	   Thread.sleep(500);
	   
	   WebElement element3 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[1]/div[2]/div/div[3]/div/div/div/input"));
	   actions.moveToElement(element3).click().perform();
	   element3.click();
	   Thread.sleep(500);
	   
	   if(end_time.equals("00:00")||end_time.equals("24:00")) {
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[1]/span")).click(); 
	   }else if(end_time.equals("01:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[2]/span")).click(); 
	   }else if(end_time.equals("02:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[3]/span")).click(); 
	   }else if(end_time.equals("03:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[4]/span")).click(); 
	   }else if(end_time.equals("04:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[5]/span")).click(); 
	   }else if(end_time.equals("05:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[6]/span")).click(); 
	   }else if(end_time.equals("06:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[7]/span")).click(); 
	   }else if(end_time.equals("07:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[8]/span")).click(); 
	   }else if(end_time.equals("08:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[9]/span")).click(); 
	   }else if(end_time.equals("09:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[10]/span")).click(); 
	   }else if(end_time.equals("10:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[11]/span")).click(); 
	   }else if(end_time.equals("11:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[12]/span")).click(); 
	   }else if(end_time.equals("12:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[13]/span")).click(); 
	   }else if(end_time.equals("13:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[14]/span")).click(); 
	   }else if(end_time.equals("14:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[15]/span")).click(); 
	   }else if(end_time.equals("15:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[16]/span")).click(); 
	   }else if(end_time.equals("16:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[17]/span")).click(); 
	   }else if(end_time.equals("17:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[18]/span")).click(); 
	   }else if(end_time.equals("18:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[19]/span")).click(); 
	   }else if(end_time.equals("19:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[20]/span")).click(); 
	   }else if(end_time.equals("20:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[21]/span")).click(); 
	   }else if(end_time.equals("21:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[22]/span")).click(); 
	   }else if(end_time.equals("22:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[23]/span")).click(); 
	   }else if(end_time.equals("23:00")){
		   Idriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/div[24]/span")).click(); 
	   }else {
		   System.out.println("Data not matched");
	   }
   	   	Thread.sleep(1000);
   	   	
   	   	WebElement element4 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]"));
   	   	actions.moveToElement(element4).click().perform();
   	 
   	   	WebElement element5 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[3]/div[1]/div/div/div[2]"));
	   	actions.moveToElement(element5).click().perform();
	   	
	   	WebElement element6 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[4]/div[1]/div/div/div[2]"));
	   	actions.moveToElement(element6).click().perform();
	   	
	   	WebElement element7 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[5]/div[1]/div/div/div[2]"));
	   	actions.moveToElement(element7).click().perform();
	   	
	   	WebElement element8 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[6]/div[1]/div/div/div[2]"));
	   	actions.moveToElement(element8).click().perform();

	   	WebElement element9 = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[5]/div/div[2]/div/div/div[7]/div[1]/div/div/div[2]"));
	   	actions.moveToElement(element9).click().perform();
		Thread.sleep(2000);
	  }catch(NoSuchElementException e) {
		  
		  System.out.println("Element not found");
	  } 
	  
   		}
   
   public String verify_customer_company_name(String expectedCompanyName) {
	    // Find all rows in the table
	    List<WebElement> rows = Idriver.findElements(By.xpath("//table[@class='w-full text-sm text-left rtl:text-right text-textSecondary']/tbody/tr"));

	    // Initialize the return status
	    String returnStatus = "NotAvailable"; // Default status

	    // Loop through the rows
	    for (int i = 1; i <= rows.size(); i++) { // Start from 1 as per XPath indexing
	        // Get the company name from the second column
	        String actualCompanyName = Idriver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr["+i+"]/td[2]/div")).getText();
	        
	        String[] resultArray = actualCompanyName.split("\n");
             System.out.println("actual name: "+ resultArray[1]);
	        // Check if it matches the expected company name
	        if (resultArray[1].equals(expectedCompanyName)) {
	            returnStatus = "Available";
	            break; // Exit the loop once the match is found
	        }
	    }

	    // Return the status
	    return returnStatus;
	}
   
   public String verify_the_new_address(String expectedState) {
	    // Find all rows in the table
	    List<WebElement> rows = Idriver.findElements(By.xpath("//table[@class='w-full text-sm text-left rtl:text-right text-textSecondary']/tbody/tr"));

	    // Initialize the return status
	    String returnStatus = "NotAvailable"; // Default status

	    // Loop through the rows
	    for (int i = 1; i <= rows.size(); i++) { // Start from 1 as per XPath indexing
	        // Get the company name from the second column
	        String actualCompanyName = Idriver.findElement(By.xpath("//table[@class='w-full text-sm text-left rtl:text-right text-textSecondary']/tbody/tr["+i+"]/td[5]")).getText();
	        
	        // Check if it matches the expected company name
	        if (actualCompanyName.equals(expectedState)) {
	            returnStatus = "Available";
	            break; // Exit the loop once the match is found
	        }
	    }

	    // Return the status
	    return returnStatus;
	}

    public String verify_mandatory_error(String action) {
    	
    	String status = Idriver.findElement(By.xpath("//div[@class='text-danger text-xs font-medium px-1' and text()='"+action+"']")).getText();
    	
    	return status;
    }
    
    public void add_new_address() {
    	Add_New_Address_Button.click();
    }
	  
    public void Tap_Carrier_Tab() {
    	Carrier_Tab.click();;
    }
	
}
