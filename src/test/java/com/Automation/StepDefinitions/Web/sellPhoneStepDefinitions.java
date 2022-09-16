package com.Automation.StepDefinitions.Web;

import com.Automation.Pages.Web.sellPhoneActions;
import com.Automation.driver.BasicConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class sellPhoneStepDefinitions {
    private sellPhoneActions sellPhoneActions;

    public sellPhoneStepDefinitions() {
        sellPhoneActions = new sellPhoneActions();
    }


    @Then("User Selects the Phone Model and variant")
    public void userSelectsThePhoneModelAndVariant(DataTable table) {
        try {
            List<Map<String, String>> tableRows = table.asMaps();
            Assert.assertTrue(sellPhoneActions.presenceOfHeader_h1(tableRows.get(0).get("Header")));
            Assert.assertTrue(sellPhoneActions.choosePhoneModel(tableRows.get(0).get("Model")));
            Assert.assertTrue(sellPhoneActions.presenceOfHeader_h1(tableRows.get(0).get("HeaderInside")));
            Assert.assertTrue(sellPhoneActions.chooseVariant(tableRows.get(0).get("Variant")));
            Assert.assertTrue(sellPhoneActions.presenceOfHeader_h1(tableRows.get(0).get("HeaderAfterSelection")));
            //Assert.assertTrue(sellPhoneActions.assertValuation(tableRows.get(0).get("Model"), tableRows.get(0).get("Variant")));
        } catch (Exception e) {

        }


    }

    @And("User gets Exact Value by answering Questionnaires")
    public void userGetsExactValueByAnsweringQuestionnaires(DataTable table) {
        try {
            List<Map<String, String>> tableRows = table.asMaps();
            Assert.assertTrue(sellPhoneActions.buttonClicks(BasicConstants.GETEXACTVALUE, true));
            Assert.assertTrue(sellPhoneActions.buttonClicks(BasicConstants.GOTIT, true));
            Map<String, String> questionAndAnswers = new LinkedHashMap<>();
            tableRows.stream().forEach(x -> {
                questionAndAnswers.put(x.get("Questions"), x.get("Answers"));
            });
            questionAndAnswers.keySet().stream().forEach(x -> {
                Assert.assertTrue(sellPhoneActions.questionAndAnswers(x, questionAndAnswers.get(x)));
            });


            Assert.assertTrue(sellPhoneActions.buttonClicks(BasicConstants.CONTINUE, true));
        } catch (Exception e) {

        }

    }

    @Then("User checks all those available options for the Phone")
    public void userChecksAllThoseAvailableOptionsForThePhone() {
        try {
            sellPhoneActions.chooseAvailableAccessories("Select screen/body defects that are applicable!");
            sellPhoneActions.chooseAvailableAccessories("Tell us more about your device screen defects");
            sellPhoneActions.chooseAvailableAccessories("Functional or Physical Problems");
            sellPhoneActions.chooseAvailableAccessories("Do you have the following?");
            sellPhoneActions.sellNowButtonClick();
        } catch (Exception e) {

        }
    }

    @Then("User provides the Contact Information for selling")
    public void userProvidesTheContactInformationForSelling(DataTable table) {
        try {
            List<Map<String, String>> tableRows = table.asMaps();
            Assert.assertTrue(sellPhoneActions.pickUpInformation(tableRows.get(0).get("days"),tableRows.get(0).get("slots"),
                    tableRows.get(0).get("paymentMethod"),tableRows.get(0).get("furtherActivity")));

        }catch(Exception e){

        }
    }

}
