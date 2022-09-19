package com.Automation.StepDefinitions.Web;

import com.Automation.Pages.Web.orderDetailsActions;
import com.Automation.Pages.Web.sellPhoneActions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class orderDetailsStepDefinition {

    private orderDetailsActions orderDetailsActions;

    public orderDetailsStepDefinition() {
        orderDetailsActions = new orderDetailsActions();
    }


    @Then("continue with Order Details")
    public void continueWithOrderDetails(DataTable table) {
        try{
            List<Map<String, String>> tableRows = table.asMaps();
            Assert.assertTrue(orderDetailsActions.orderDetailsFromOrderConfirmation(tableRows.get(0).get("activity"),tableRows.get(0).get("reason"),tableRows.get(0).get("cancel")));
        }catch(Exception e){

        }
    }


}
