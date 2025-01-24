
Feature: Carrier Customer Onboarding 

 Scenario Outline: In Carrier Add single customer with company name and address
 Given I am on dashboard<ID> and <password>
 And Tap_On_Carrier_Tab
 When Open customer form 
 And Provide the company name<Companyname>
 And Provide the Address Details<Street> <City> <State> <postCode> <country>
 When Submit the form
 And Tap back button
 Then customer successsfully added 
 And Close_Window
 
Examples:
| ID 										| password |Companyname| Street				  | City | State | postCode | country |
|asatpute008@gmail.com  | Pass@123 |Random     | Main_street001 | YK   | FL    | 987678   | USA     |


Scenario Outline: In Carrier Add single customer with all details
Given I am on dashboard<ID> and <password>
And Tap_On_Carrier_Tab
When Open customer form 
And Provide the company Details<Companyname> <EIN> <rep_name> <website>
And Provide the contact Details<mobile> <email>
And Provide the alternate Details<altmobile> <altemail>
And Provide the Address Details<Street> <City> <State> <postCode> <country>
And Provide the bookvia with Email<BookEmail>
And Provide the special_instructions<Instruction>
And Provide the Business hour<startTime> <endTime>
When Submit the form
And Tap back button
Then customer successsfully added 
And Close_Window

Examples:
| ID 								     | password |Companyname| EIN	   | rep_name		 | website       | mobile		  | email			 	   | altmobile | altemail     | Street				 | City | State | postCode | country | BookEmail      | Instruction    					     | startTime | endTime |
|asatpute008@gmail.com   | Pass@123 |Random     | 447788 | Sara_Sharma | www.royal.com | 9865768576 | royal@mail.com | 859889569 | alt@mail.com | Main_street001 | YK   | FL    | 987678   | USA     | royal.book.com | special_instruction_customer | 04:00     | 15:00   |
