package com.Automation.StepDefinitions.Web;

import com.Automation.Pages.Web.SeoAutomationPage;
import com.Automation.Pages.Web.homepageActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

@Slf4j
public class homepageStepDefinitions {
    private homepageActions homepageActions;

    public homepageStepDefinitions() {
        homepageActions = new homepageActions();
    }


    @Given("User launches the {string} and verifies landing on homePage")
    public void userLaunchesTheAndVerifiesLandingOnHomePage(String url) {
        try {
            Assert.assertTrue(homepageActions.userLaunchesURL(url));
        } catch (Exception e) {
            log.info("Failed during URL launch and homepage verification");
        }
    }

    @Then("User can change the Location to {string}")
    public void userCanChangeTheLocationTo(String location) {
        try {
            Assert.assertTrue(homepageActions.userChangesLocation(location));
        } catch (Exception e) {
            log.info("Failed during choosing given Location :: " + location);
        }
    }

    @And("User chooses {string} from navigation Header")
    public void userChoosesFromNavigationHeader(String headerMenuChoice, DataTable table) {
        try {
            List<Map<String, String>> tableRows = table.asMaps();
            Assert.assertTrue(homepageActions.chooseHeader(headerMenuChoice));

            switch (headerMenuChoice) {
                case "Sell Phone":
                    Assert.assertTrue(homepageActions.sellPhone(tableRows.get(0).get("Type"), tableRows.get(0).get("Phone")));
                    break;
                case "Buy Phone":
                    Assert.assertTrue(homepageActions.buyPhone(tableRows.get(0).get("Type"), tableRows.get(0).get("Phone")));
                    break;

            }

        } catch (Exception e) {

        }
    }


    @And("User logs in with the Number {string} and OTP {string}")
    public void userLogsInWithTheNumberAndOTP(String phoneNumber, String OTP) {
        try{
            Assert.assertTrue(homepageActions.login(phoneNumber,OTP));
        }catch(Exception e){

        }
    }
}
