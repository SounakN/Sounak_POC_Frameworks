package com.Automation.TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {

                "pretty",
                "html:build/reports/CucumberSpecificReport/Cucumbertestreport.html"
                , "json:build/reports/CucumberSpecificReport/CucumberJson/cucumber.json"
        },
        features = {"src/test/resources/Feature/Web"},

        glue = {"com/Automation/StepDefinitions/Web"},
        tags = "@SEOAutomation_Google_1"

)
public class TestRunner_Web {


}


