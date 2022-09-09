# Selenium with Cucumber BDD Framework

## Table of Contents

* [Introduction](#Introduction)
* [Prerequisites](#Prerequisites)
* [Installation](#Installation)
* [Usage](#Usage)

## Introduction

This is Cucumber based BDD Framework targeted to handle Web and Native Mobile Applications.

## Prerequisites

This section details any and all prerequisites in order for the application to be run.

### Tools
Below tools/dependencies are required to be installed in the machine from where automation scripts would be triggered-

1. IntelliJ IDEA
2. JAVA
3. Cucumber
4. Selenium Webdriver
5. Gradle


## Installation

The installation section details steps that need to be taken in order to properly install the application.

1. Installation step 1

> Open the project in IntelliJ Idea (Or Eclipse)

This global installation is required in order for the application to function properly.

2. Installation step 2

> Build your gradle project (Go to gradle tab and build the project)


## Usage

•	Clone this repo

•	Open the framework in IntelliJ Idea

•	Build your gradle project (Go to gradle tab and build the project)

•	Open the build.gradle file

• Run test by:
    
    Run test by:
    
    a. Run the Test Runner file under Test Runner in your Project     
    b. In Terminal(Mandatory fields, whcih actually choose sthe Runner file), run 
    "gradle clean test   -DEnv={'STG','DEV','UAT'} -DSuite={'Web','mWeb','Native'} -DApp={'Marketing','Learn','Live','Growth'}        
    
    Thus this helps choosing the Test Runner Class the project should choose and Run::
    Test Runner naming convention --> TestRunner_{Suite}_{App} under the test Runner folder            
    1. **Each Test runner for Suite 'Web'**  -                    
     a. Should point to the folder of their APP's Feature file under 'Web' in **feature tag**                     
     b. The **glue** should point to the Stepdef folder of 'Web'            
    2. **Each Test runner for Suite 'mWeb'**  - {Currently our mWeb Stack and Native can Run only in Browserstack}
     a. Should point to the folder of their APP's Feature file under 'Web' in **feature tag**                     
     b. The **glue** should point to the Stepdef folder of 'mWeb'
    3. **Each Test runner for Suite 'Native'**  -                   
     a. Should point to the folder of their APP's Feature file under 'Mobile' in **feature tag**                    
     b. The **glue** should point to the Stepdef folder of 'Mobile'    
     c. Env --> is to choose the Environment you want to run your project, based on which the folder of Config files would be read    
     d. Suite --> Determines the Suite you want to run, Web, mWeb or Mobile    
     e. App --> The name of the Application, based on which your test runner would run.    
     f. In Browser Properties or Parameters
      . Choose the Driver {chrome, firefox,Browserstack, edge} from Browser properties                           
      . Choose Incognito to be true or false        
      . Choose Start Maximized to be true or false        
      . Choose IsRemote to be false, when you intend to run it in your local Browser without the Grid Initialization            
      . Browserstack works with IsRemote False only.        
      . if IsRemote is True, then we have to do a setup of Docker:(For now EDGE wont work with isRemote True)            
       . Install Docker in your system            
       . In docker terminal, go till the Directory of the Repo of your Code, which has a Docker Compose YAML file.            
       . Run the command, "docker-compose up -d" , to start spin off the Docker setup for Selenium grid, with 2 available instances of Firefox and 2 of Chrome.            
       . CHoose your browser from properties and other configs, Run with the same Gradle Run command with Envr, Suite and App name in parameters to run it in Docker.            
       . Download, VNC Viewer, and add                
        . 127.0.0.1:5900 --> as one remote machine where you can see the runs triggered on Chrome browser                  
        . 127.0.0.1:5901 --> as one remote machine where you can see the runs triggered on Firefox browser    
      g. In Mobile Properties or Parameters
        . Driver_mobile here you provide Android_Native(For Native driver initiation), Android_Web(For mWeb browser initiaion)
        .If Driver is Android_Web or Android_Native then default values(Non Browserstack - Put your own Local device)
          .Mobile_device_android =Choose your local machine Android Device
          .Browser_mobile_android=Choose the browser name
          .Mobile_app_name_android =App ID (Ex: 5.2.46.apk)

        .If Driver is IOS_Web or IOS_Native then default values(Non Browserstack - Put your own Local device)
          .Mobile_device_ios   =   Choose your local machine IOS Device
          .Browser_mobile_ios  =   Choose the browser name
          .Mobile_app_name_ios =   App ID (upGrad.app)
      
    6. If You have to run Anything in browserstack(BrowserstackConfigs.properties)
     1. os_version_mobile is to be chosen for whichi IOS or Android version         
     2. Mobile_device is to be chosen for which Device you want your test to run       
     3. Browser_mobile gives you the choice for choosing the browser {for now we can give 'Samsung' or 'Chrome' when it comes to android device & for IOS it takes Safari by default}
     4. Browserstack_switch, needs to be true for running things in Browserstack
     5. Browserstack_local, needs to be true if you want the Local network to be replicated in Browserstack.
     6. You dont have to give any Browser for Web run in Browserstack, as whatever Driver you have choosen in Browser.config properties, in Browserstack it runs in that browser itself

    7. Healthcheck - Introduced on 26-04-2022
        We have added a health check functionality in each of the test runner as a part of the Before class. There we do API calls based on which the Health of the respective APIs are checked before we initiate our suite.
            a. The API which runs for Learn, Live, Teach and Marketing as present in APIHealthcheckMapping.json under TestData folder under resource
            b. People can new API in that to make that run too in the healthcheck for a particular APP
            c. If new API are added which didnot existed earlier, then under Resources in the Data config undr Respective folder (Taking example of STG), open APIConfig_STG and add the API URI and the End point as and in the way theother API URI and end points have been added with the proper nomenclature.
                Ex from STG -> [API name]-Base-URI-[Envr Name] --> Example-->  Auth-Base-URI-STG
                            -> [API name]-Endpoints-[Envr Name] --> Example--> Auth-Endpoints-STG
    8.ZAP Security Scan - Added on 16-05-22
       We had added an option to execute security scan with help of ZAP tool
         Download ZAP from https://www.zaproxy.org/download/ and extract the zip for local execution 
         Run command ./zap.sh -daemon -host 127.0.0.1 -port 8090 -config api.addrs.addr.regex=true -config api.disablekey=true
         a.In order to run ZAP Scan passively with test pass Scan="passive"
         b.In order to run ZAP Scan with active mode along with test pass Scan="active"
         c.In order to run ZAP Scan both passively and actively with test pass Scan="all"
         d.In order to run ZAP Scan after each scenatrio with test pass ScanLevel="scenario"
         e.In order to run ZAP Scan after each step with test pass ScanLevel="step"
         f.In order to fail test with checking Limit on security alerts override TotalRiskLimit value in params 

•Reporting::
    In Under Build --> Reports --> CucumberSpecificReport --> cucumber-html-reports--> Find the newly generated Report with the name 


## Execution on Jenkins

For running on Jenkins follow the below steps: 
* Hit below URL: https://jenkins.upgrad.dev/job/Automated%20Testing/job/cucumber-jvm-core/
* Build with use-case specific parameters. 


## branching structure
* Master : stable branch for prodution
* Develop : development branch with all latest changes
* Feature : feature/<name> , for new addiions to repo
* BugFix : bugfix/<name> , for fixing bugs
* Release : release/<name> , for doing regression testing before merging to master

### Develpment Flow
* Takeout Feature branch from develop
* Ensure in commit messeges you pass the jira id [Example "ETA-1 : this is commit"]
* Feature branch -> Raise PR to Develop for review [ensure you have checked close after merge in PR ]
* Please also add a link for jenkins run with your branch on PR description 
* Wait for review ,ensure all review comments are closed to get them merged to develop
* Take out release branch and raise PR to master for regression testing
* Post merge ,back merge master to develop and also rebase feature branches to ensure everyone has latest changes
