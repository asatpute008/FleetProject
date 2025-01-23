
Feature: Title of your feature
  I want to use this template for my feature file

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
 When Tap on submit button 
 And Provide Shipper Name <Customer> 
 And Select Pickup Date <DATE>
 And Select Pickup Type FCFS

 Examples:
| ID 										|password |load_type            |Customer|POnumber|Quntity |Order_No |Shipping_Numbers|Type_Name     |DATE|
|hibaw76347@downlor.com |Pass@123 |FTL (Full Truckload) |NA      |1144		 |1				|23142    |2               |Fast Shipping |25  |