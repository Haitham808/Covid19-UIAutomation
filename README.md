# Covid19_UI-Automation

Introduction
-  UI Automation framework for COVID19 challenge
Getting Started
- TODO: Guide users through getting your code up and running on their own system. In this section you can talk about:

Installation process
- To install - use one the following build & test commands


------ Software dependencies -------
- Maven - https://maven.apache.org/ 
- Java - https://www.oracle.com/java/technologies/javase-jdk8-downloads.html 



--------Command to run E2E scenario------------
- mvn clean test 


# cross browser testing

- you can specisfy which browser you want to test on by using "browser=  " in src/main/resources/properties/config.properties file
- for chrome browser, use : browser=chrome
- for Edge browser, use : browser=Edge
- for firefox browser, use : browser=firefox

# Github CI - [Github Actions]

- the pipeline is in place and will be triggered once there is a push to master branch or a pull request to master branch 
