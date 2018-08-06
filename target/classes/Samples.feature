Feature:Login into Webmail
Scenario: we open the url and enter the credentials
Given website url
When we enter the credentials
Then we get logged in

Scenario:Successfull logout
When we click on logout button
Then we get successfull logout