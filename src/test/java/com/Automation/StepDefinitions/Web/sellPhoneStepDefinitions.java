package com.Automation.StepDefinitions.Web;

import com.Automation.Pages.Web.homepageActions;
import com.Automation.Pages.Web.sellPhoneActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

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
        try{
            List<Map<String, String>> tableRows = table.asMaps();
            Assert.assertTrue(sellPhoneActions.presenceOfHeader(tableRows.get(0).get("Header")));
            Assert.assertTrue(sellPhoneActions.choosePhoneModel(tableRows.get(0).get("Model")));
            Assert.assertTrue(sellPhoneActions.presenceOfHeader(tableRows.get(0).get("HeaderInside")));
            Assert.assertTrue(sellPhoneActions.chooseVariant(tableRows.get(0).get("Variant")));
            Assert.assertTrue(sellPhoneActions.presenceOfHeader(tableRows.get(0).get("HeaderAfterSelection")));
            Assert.assertTrue(sellPhoneActions.assertValuation(tableRows.get(0).get("Model"),tableRows.get(0).get("Variant")));
        }catch(Exception e){

        }


    }

}
