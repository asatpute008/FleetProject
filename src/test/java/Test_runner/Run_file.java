package Test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src\\test\\resources\\Customers\\Customer_form.feature","src\\test\\resources\\Login\\Login.feature"},
		glue = {"Customer_oboarding","Signin.java","StepDefination"},
		monochrome = true,
		plugin = {"pretty", "html: target/Result/report.html"}
	
		)
public class Run_file {

}
