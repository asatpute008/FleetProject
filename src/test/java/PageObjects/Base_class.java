package PageObjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_class {
	
	public WebDriver Idriver;
	
	public Base_class(WebDriver rdriver) {
		Idriver = rdriver;	
		PageFactory.initElements( rdriver, this);
	}
	
	public String baseURL = "https://fleet-manager-development.vercel.app/auth/sign-in";
	public String Dashboard_Link = "https://fleet-manager-development.vercel.app/admin/onboarding/broker/load-tender";	
	
	public void open_chrome(){
		Idriver.get("https://fleet-manager-development.vercel.app/sign");	
	}	
	
	public void screen_shot(String Filename, String folderName) throws IOException {
		//Take screen shot 
//		File scr_img = ((TakesScreenshot) Idriver).getScreenshotAs(OutputType.FILE);
//
//		// create file name 
//		String date_time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//		String create_image_name = Filename + date_time + ".png";
//		
//		File  destination = new File("C:\\Users\\Aniket Satpute\\eclipse-workspace\\FleetProject\\target\\Result\\screen_shot\\"+folderName+"\\"+create_image_name);
//		destination.getParentFile().mkdirs();
//		Files.copy(scr_img, destination);
//		
		System.out.println("screen shot class not taking");
		
	}
	
	public void close_window() {
		 if (Idriver != null) {
	            Idriver.quit();
	            System.out.println("WebDriver quit successfully.");
	        } else {
	            System.out.println("WebDriver instance is null. Cannot quit.");
	        }
	}
	
}
