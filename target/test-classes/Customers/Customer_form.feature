
Feature: Customer Onboarding form

Scenario Outline: Add single customer with all details
Given I am on dashboard<ID> and <password>
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
|fokisaj290@edectus.com  | Fleet@123|Wallart    | 447788 | Sara_Sharma | www.royal.com | 9865768576 | royal@mail.com | 859889569 | alt@mail.com | Main_street001 | YK   | FL    | 987678   | USA     | royal.book.com | special_instruction_customer | 04:00     | 15:00   |


 Scenario Outline: Add single customer with company name and address
 Given I am on dashboard<ID> and <password>
 When Open customer form 
 And Provide the company name<Companyname>
 And Provide the Address Details<Street> <City> <State> <postCode> <country>
 When Submit the form
 And Tap back button
 Then customer successsfully added 
 And Close_Window
 
Examples:
| ID 										| password |Companyname| Street				  | City | State | postCode | country |
|fokisaj290@edectus.com | Fleet@123|Rocky_Steel| Main_street001 | YK   | FL    | 987678   | USA     |

 
 Scenario Outline: Add customer without company name
 Given I am on dashboard<ID> and <password>
 When Open customer form 
 And Provide the contact Details<mobile> <email>
 And Provide the Address Details<Street> <City> <State> <postCode> <country>
 When Submit the form
 Then Display Error response<Error>
 And Close_Window
 
 Examples:
| ID 										| password |Street				  | City | State | postCode | country | mobile		 | email			 	  |Error   									|
|fokisaj290@edectus.com | Fleet@123|Main_street001  | YK   | FL    | 987678   | USA     | 9865768576 | royal@mail.com |Company Name is required |

Scenario Outline: Add customer without Address
 Given I am on dashboard<ID> and <password>
 When Open customer form 
 And Provide the company name<Companyname>
 When Submit the form
 Then Display Error response<Error>
 Then Display Error response<Error1>
 Then Display Error response<Error2>
 Then Display Error response<Error3>
 Then Display Error response<Error4>
 And Close_Window
 
 Examples:
| ID 										| password |Companyname  |Error   					 |Error1   				 | Error2   					 |Error3  								|Error4  					  |
|fokisaj290@edectus.com | Fleet@123|Tea_Dist     |Street is required |City is required | Province is required|Postal Code is required |Country is required|

Scenario Outline: Add Extra address
Given I am on dashboard<ID> and <password>
When Open customer form 
And Provide the company Details<Companyname> <EIN> <rep_name> <website>
And Provide the Address Details<Street> <City> <State> <postCode> <country>
When Submit the form
When Add new address
And Add_new_address_details<Street> <City> <State> <postCode> <country>
When Submit the form
Then Verify_the_New_address
 And Close_Window

Examples:
| ID 										 | password |Companyname| EIN	   | rep_name		 | website       | Street		 			| City | State | postCode | country | BookEmail      | Instruction    					    | startTime | endTime |
|fokisaj290@edectus.com  | Fleet@123|RJ_Steel   | 447788 | Sara_Sharma | www.royal.com |Main_street001  | YK   | FL    | 987678   | USA     | royal.book.com | special_instruction_customer | 04:00     | 15:00   |
