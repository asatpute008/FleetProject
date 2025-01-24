
Feature: Create load in broker 

 Scenario Outline: create Load with basic information 
 Given Open dashboard<ID> and <password>
 And Tap on My_load sub module
 And Open Load form 
 And Provide load and transport type <load_type>
 #Note - Load type "FTL (Full Truckload)", "LTL (Less Than Truckload)"
 And Provide billing details <Customer> 
 #Note - provide the "NA" to proved 1st no. customer in list , Provide company name to select perticular customer but customer should be available in list
 And Provide multiples_Po_number <POnumber> <Quntity>
 And Provide order_number <Order_No>
 And Provide shipping type <Shipping_Numbers>
# And Provide perticuler shipping <Type_Name>
 When Tap on submit button 
 #When Tap on Cancel button
 Then Basic information successfully submited <POnumber>
 

 Examples:
| ID 										| password |load_type            |Customer|POnumber|Quntity |Order_No |Shipping_Numbers|Type_Name     |
|asatpute008@gmail.com  | Pass@123|FTL (Full Truckload) |NA      |1144		 |1				|23142    |2               |Fast Shipping |



Scenario Outline: User should not submit the basic info withot PO number
Given Open dashboard<ID> and <password>
 And Tap on My_load sub module
 And Open Load form 
 And Provide load and transport type <load_type>
 And Provide billing details <Customer> 
 And Provide multiples_Po_number <POnumber> <Quntity>
 And Delete_Po_number <DeletePO>
 And Provide order_number <Order_No>
 And Provide perticuler shipping <Type_Name>
 When Tap on submit button 
 #When Tap on Cancel button
 Then Display the error response on PO number <ERROR>
 
 
 Examples:
| ID 										| password |load_type            |Customer|POnumber|Quntity |Order_No |Type_Name     |DeletePO|ERROR    						|
|asatpute008@gmail.com  | Pass@123|FTL (Full Truckload) |NA      |1144		 |1				|23142    |Fast Shipping |1				|PO Number is required|
 