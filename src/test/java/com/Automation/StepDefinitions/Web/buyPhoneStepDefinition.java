package com.Automation.StepDefinitions.Web;

import com.Automation.Pages.Web.buyPhoneActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class buyPhoneStepDefinition {
   private buyPhoneActions buyPhoneAction;

    public buyPhoneStepDefinition() {
        buyPhoneAction = new buyPhoneActions();
    }

    @Then("User Selects the Phone from the available list")
    public void userSelectsThePhoneFromTheAvailableList(DataTable table) {
        try{
            List<Map<String, String>> tableRows = table.asMaps();

            Assert.assertTrue(buyPhoneAction.choosePhone(tableRows.get(0).get("Model")));
        }catch(Exception e){

        }
    }

    @Then("User provides the Contact Information")
    public void userProvidesTheContactInformation(DataTable table) {
        try{
            List<Map<String, String>> tableRows = table.asMaps();
            tableRows.get(0).entrySet().stream().forEach(x->{
                Assert.assertTrue(buyPhoneAction.provideShippingInformation(x.getKey(),x.getValue()));
            });
            buyPhoneAction.clickContinueShipping();

        }catch(Exception e){

        }
    }

    @And("Validates the information present on screen")
    public void validatesTheInformationPresentOnScreen(DataTable table) {
        try{
            List<Map<String, String>> tableRows = table.asMaps();

            Assert.assertTrue(buyPhoneAction.shippingInformationVerification(tableRows));
            Assert.assertTrue(buyPhoneAction.validateFinalPrice());

        }catch(Exception e){

        }
    }
}
