package PageObjects;

import java.awt.Desktop.Action;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	//Order number 
	@FindBy(xpath="//input[@placeholder='Enter Customer Order Number']")
	WebElement Order_number;

	//Cancle and submit button  
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement Cancle_button;

	@FindBy(xpath="//button[text()='Save & Continue']")
	WebElement Submit_button;

	//Time Line
	@FindBy(xpath="//div[text()='Basic Information']")
	WebElement Basic_information_tab;

	public void Tap_on_my_load() throws InterruptedException{
		Idriver.findElement(By.xpath("//span[text()='Broker']")).click();
		Thread.sleep(500);
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
	public String Select_bill_To(String Values) throws InterruptedException {
		String CustName = null;
		Thread.sleep(1000);
		Idriver.findElement(By.xpath("//input[@class='m_8fb7ebe7 mantine-Input-input mantine-InputBase-input']")).click();

		List<WebElement> rows = Idriver.findElements(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option']"));

		if(rows.size()== 0){
			System.out.println(rows.size()+ " - Rows not avaialable");
		}
		else if(!Values.equals("NA")) {
			String customerName = Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option' and text()='"+Values+"']")).getText();
			Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option' and text()='"+Values+"']")).click();
			System.out.println("Find using value" + Values);
			
			CustName = customerName;
		}
		else if(rows.size()>0) {
			
			String customerName = Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option']")).getText().trim();
			Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Combobox-option']")).click();
			System.out.println("Shipper Name = "+ customerName);
			CustName = customerName;		
		}else {
			System.out.println("Conditon not matched for select bill to ");

		}

		return CustName;
	}

	public void Add_Single_PO_numbers(String PO_number) {

		PO_Number.sendKeys(PO_number);
	}

	public void Add_Multiple_PO_numbers(String PO_number, int PO_qnt) throws InterruptedException{
		PO_Number.sendKeys(PO_number);

		Actions tap = new Actions(Idriver);
		tap.moveToElement(Add_Another_Number).click().perform();
		Thread.sleep(500);
		for(int i = 1; i< PO_qnt; i++){
			Thread.sleep(500);
			PO_Number.sendKeys(PO_number +i);
			Thread.sleep(700);
			tap.moveToElement(Add_Another_Number).click().perform();
			//				Add_Another_Number.click();

		}
	}

	public void Delete_PO_number(int Delete_PO) throws InterruptedException {
		for(int i =0; i<Delete_PO; i++) {
			Thread.sleep(500);
			delete_Po_number.click();
		}
	}

	public void Enter_Order_Number(String Recive_number) {
		Order_number.sendKeys(Recive_number);
	}

	public void Enter_shipping_parameters(int numberOfShipping) {

		Random random = new Random();
		List<String> shippingTypes = Arrays.asList("Fast Shipping", "ELD Tracking", "Hazardous Commodity","Exclusive Use", "Food Grade Trailer", "CTPAT", "Bonded", "Oversized","Overweight");

		for(int i =0; i< numberOfShipping; i++) {

			int number = random.nextInt(shippingTypes.size());

			WebElement check_box = Idriver.findElement(By.xpath("//label[text()='"+shippingTypes.get(number)+"']"));
			Actions taps = new Actions(Idriver);
			taps.moveToElement(check_box).click().perform();
		}

	}


	public void tap_shipping_parameters(String name) {
		WebElement check_box = Idriver.findElement(By.xpath("//label[text()='"+name+"']"));
		Actions taps = new Actions(Idriver);
		taps.moveToElement(check_box).click().perform();
	}


	public void tap_on_cancel_button() {

		Cancle_button.click();
	}

	public void tap_on_Submit_button() {

		Submit_button.click();
	}

	public void tap_on_basic_info() {
		Actions taps = new Actions(Idriver);
		taps.moveToElement(Basic_information_tab).click().perform();
	}

	public boolean verify_PO_number(String verify) {
		boolean return_value = false;
		try{
			boolean check = Idriver.findElement(By.xpath("//input[@value='"+verify+"']")).isDisplayed();
			return_value = check;
		}catch(NoSuchElementException e){
			return_value = false;
		}
		return return_value;
	}

	public void pickupDate(int Date) throws InterruptedException {

		Thread.sleep(500);
		Idriver.findElement(By.xpath("//span[@class='text-textPlaceholder']")).click();
		Thread.sleep(500);
		Idriver.findElement(By.xpath("//button[@name='next-month']")).click();
		Thread.sleep(500);
		Idriver.findElement(By.xpath("//button[text()='"+Date+"']")).click();
		Thread.sleep(500);
	}

	public void FCFS(String PickupTime, String DeliveryTime) throws InterruptedException {
		Thread.sleep(500);
		WebElement Radio =Idriver.findElement(By.xpath("//button[@id='r1' and @value='FIRST COME FIRST SERVE']"));
		Actions tap = new Actions(Idriver);
		tap.moveToElement(Radio).click().perform();

		Thread.sleep(500);		
		//			Idriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/section/div/div/div/div/div[2]/div[2]/div[1]/tbody/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/div[14]/div[2]/div[1]/input")).sendKeys(PickupTime);
		//			Thread.sleep(500);		
		//			Idriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/section/div/div/div/div/div[2]/div[2]/div[1]/tbody/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/div[15]/div[2]/div[1]/input")).sendKeys(DeliveryTime);
		//			Thread.sleep(500);	
	}

	public void commodity() throws InterruptedException {

		Thread.sleep(500);	
		Actions tap = new Actions(Idriver);
		WebElement commo = Idriver.findElement(By.xpath("//div[@class='w-full md:w-8/12']/div/div[2]/div/div[2]/div/div/input"));
		tap.moveToElement(commo).click().perform();
		Thread.sleep(500);	
		List<WebElement> commlist = Idriver.findElements(By.xpath("//div[@class='max-w-7xl w-full']/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div"));

		Random random = new Random();
		int num = random.nextInt(commlist.size());
		int compair = 0;
		while(compair < 1) {
			if(num >0 ) {	
				Idriver.findElement(By.xpath("//div[@class='max-w-7xl w-full']/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div["+num+"]")).click();
				Thread.sleep(500);
				compair++;
			}else {
				System.out.println("Not allow = "+ num);
			}
		}
	}

	public void pickupWeight() throws InterruptedException {		
		Thread.sleep(700);
		Idriver.findElement(By.xpath("//input[@placeholder='Enter Weight']")).click();
		Idriver.findElement(By.xpath("//input[@placeholder='Enter Weight']")).sendKeys("120");
		Thread.sleep(500);
	}

	public void Pallets() throws InterruptedException {

		Thread.sleep(500);	
		Actions tap = new Actions(Idriver);
		WebElement commo = Idriver.findElement(By.xpath("//div[@class='w-full md:w-8/12']/div/div[4]/div[2]/div/input"));
		tap.moveToElement(commo).click().perform();
		Thread.sleep(500);	

		List<String> palletList = Arrays.asList("Automotive(48x45)", "Beverage(36x36)", "Beverage, Shingles, Packaged Paper(48x36)", "Chemicals and Beverages(48x42)",
				"Dairy(40x40)", "Drums and Chemical(44x44)", "Drums(48x48)", "Grocery(40x48)", "Half Pallets(40x24)","Half Pallets(48x20)",
				"Military 1/2 ISO container, fits 36 standard doors(35x45.5)", "Military, Cement(48x40)", "Retail(48x20)", "Standard(42x42)",
				"Standard(48x40)","Standard(48x48)", "Telecommunications, Paint(42x42)");

		List<String> feetList = Arrays.asList("Automotive(48x45)", "Beverage(36x36)", "Beverage, Shingles, Packaged Paper(48x36)", "Chemicals and Beverages(48x42)",
				"Dairy(40x40)", "Drums and Chemical(44x44)", "Drums(48x48)", "Grocery(40x48)", "Half Pallets(40x24)","Half Pallets(48x20)",
				"Military 1/2 ISO container, fits 36 standard doors(35x45.5)", "Military, Cement(48x40)", "Retail(48x20)", "Standard(42x42)",
				"Standard(48x40)","Standard(48x48)", "Telecommunications, Paint(42x42)");
		Random random = new Random();
		int num = random.nextInt(palletList.size());			
		Idriver.findElement(By.xpath("//div[@class='m_92253aa5 mantine-Select-option m_390b5f4']/span[text()='"+palletList.get(num)+"']")).click();
		Thread.sleep(500);

	}

	public void PalletsNumber() throws InterruptedException {
		Thread.sleep(500);
		Idriver.findElement(By.xpath("//input[@placeholder='Enter Number of pallets']")).sendKeys("2");
		Thread.sleep(500);
	}

	public void UnitsNumber() throws InterruptedException {
		Thread.sleep(500);
		Idriver.findElement(By.xpath("//input[@placeholder='1000']")).sendKeys("2");
		Thread.sleep(500);
	}

	public void commodityInstruction() throws InterruptedException {
		Thread.sleep(500);
		Idriver.findElement(By.xpath("//textarea[@placeholder='Enter any special loading or handling instructions']")).sendKeys("Handle Carefully");
		Thread.sleep(500);
	}

	public void Equipments() throws InterruptedException {

		Thread.sleep(500);	
		Actions tap = new Actions(Idriver);
		WebElement commo = Idriver.findElement(By.xpath("//div[@class='w-full md:w-8/12']/div/div[11]/div/div[2]/div/div/input"));
		tap.moveToElement(commo).click().perform();
		Thread.sleep(500);	
		List<WebElement> commlist = Idriver.findElements(By.xpath("//div[@class='w-full md:w-8/12']/div/div[11]/div/div[2]/div[2]/div/div"));

		Random random = new Random();
		int num = random.nextInt(commlist.size());
		int compair = 0;
		while(compair < 6) {
			if(num >0 ) {	
				Idriver.findElement(By.xpath("//div[@class='w-full md:w-8/12']/div/div[11]/div/div[2]/div[2]/div/div["+num+"]")).click();
				Thread.sleep(500);
				compair = compair + 6;
			}else {
				System.out.println("Not allow = "+ num);
				compair ++;
			}
		}

	}

	public void Temprature() throws InterruptedException {
		Thread.sleep(500);
		Idriver.findElement(By.xpath("//input[@placeholder='Select temperature range']")).sendKeys("2530");
		Thread.sleep(500);
	}

	public void SubmitPickup() throws InterruptedException {
		Thread.sleep(500);
		Actions tap = new Actions(Idriver);
		WebElement sumit = Idriver.findElement(By.xpath("//button[text()='Save']"));
		tap.moveToElement(sumit).click().perform();
		Thread.sleep(500);
	}

}
