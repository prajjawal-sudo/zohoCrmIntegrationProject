Steps to execute test cases:

Pre-requisites:

> Ensure the correct login accounts are provided in testdata.xlsx file under test Data folder to prevent from failures

> Ensure the data matches with logged in user to prevent from failures in creation of lead, editing of lead, deletion of lead , filtering of lead , customization for lead.

> Zoho CRM only allows 20 signs in attempts in a day with a single credentials also after 14 attempts it starts showing the warning so ensure that you uses 2 test account with in 20 test cases with matched data.

1 - > How do you want to execute the test case in headless mode / without headless

 To use above feature, go to base test class under setup method pass true for headless and false for without headless.

2 - > How do you want execution parallel or without parallel 

To use above feature if you want parallel execution – on the root folder right click on parallel-execution.xml or execute each test case individually use testNg.xml file

3 - > How to run the test cases on git hub actions
I have already integrated with git hub action you can go to github repository and click on actions tab will find the maven.yaml file under the github work flows currently not recommended to execute from there as the unavailability of correct test data.

4 - > Recommended - > Run the suite in local machine using headless mode through parallel – execution.xml
