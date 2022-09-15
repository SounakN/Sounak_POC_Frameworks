package com.Automation.Pages.Web;

import com.Automation.driver.BasicConstants;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.ActionMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import javax.swing.*;

public class orderDetailsActions {
    private WebDriver driver;
    private commonActions commonActions = new commonActions();
    public orderDetailsActions() {
        driver = WebBrowser.getDriver();
    }


    //Constant String
    String radiobuttonforReason = "//span[text()='%s']/preceding-sibling::span//input[@type='radio']";


    By pickUpRequested = By.xpath("//div[text()='Pickup Requested']");
    By cancelOrder = By.xpath("//*[text()='Cancel Order'][1]");
    By reasonForCancellation = By.xpath("//span[text()='Reason for cancellation']");
    By pickUpCancelled = By.xpath("//div[text()='Pickup Cancelled']");

    public boolean orderDetailsFromOrderConfirmation(String activity, String reason){
        try{
            ActionMethods.ScrollIntoView(driver, ActionMethods.FindElement(pickUpRequested, driver, 20,5));

            if(activity.equals("Cancel Order")){
                WebElement cancel_Order = ActionMethods.FindElement(cancelOrder,driver, 20,5);
                Assert.assertNotNull(cancel_Order);
                ActionMethods.JavaScriptClick(driver, cancel_Order);

                //checking cancellation reason
                WebElement cancelationrequest  =ActionMethods.FindElement(reasonForCancellation, driver,20,5);
                Assert.assertNotNull(cancelationrequest);

                WebElement choiceCancellation = ActionMethods.FindElement(ActionMethods.textLocatorCreator.apply(radiobuttonforReason,reason),driver,20,5);
                Assert.assertNotNull(choiceCancellation);
                ActionMethods.MoveTo(driver,true, choiceCancellation );

                Assert.assertTrue(commonActions.clickOnButton(BasicConstants.CONFIRM, false));
                Assert.assertTrue(commonActions.clickOnButton(BasicConstants.YES, false));

                WebElement pickUp_Cancelled = ActionMethods.FindElement(pickUpCancelled,driver,30,4);
                Assert.assertNotNull(pickUp_Cancelled);
                ActionMethods.ScrollIntoView(driver, pickUp_Cancelled);
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
