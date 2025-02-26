package Test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src\\test\\resources\\Customers\\Customer_form.feature",
				    "src\\test\\resources\\Login\\Login.feature",
				    "src\\test\\resources\\Customers\\Carrier_Customer_Onboarding.feature",
					"src\\test\\resources\\Create_Load\\Create_Load.feature"},
		glue = {"Customer_oboarding.java","Signin.java", "My_Load.java", "StepDefination"},
		monochrome = true,
		plugin = {"pretty", "html: target/Result/report.html"}
	
		)
public class Run_file {

}
