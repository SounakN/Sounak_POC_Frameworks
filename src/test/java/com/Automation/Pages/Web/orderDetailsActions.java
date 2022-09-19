package com.Automation.Pages.Web;

import com.Automation.StepDefinitions.Web.SetUp;
import com.Automation.driver.BasicConstants;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.ActionMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import javax.swing.*;
import java.util.Locale;

public class orderDetailsActions {
    private WebDriver driver;
    private commonActions commonActions = new commonActions();
    public orderDetailsActions() {
        driver = WebBrowser.getDriver();
    }


    //Constant String
    String radiobuttonforReason = "//span[text()='%s']/preceding-sibling::span//input[@type='radio']";
    String yes_or_no_selection = "//div[text()='Cancel']/following-sibling::div/button/span[text()='%s']";

    By pickUpRequested = By.xpath("//div[text()='Pickup Requested']");
    By cancelOrder = By.xpath("//*[text()='Cancel Order'][1]");
    By reasonForCancellation = By.xpath("//span[text()='Reason for cancellation']");
    By pickUpCancelled = By.xpath("//div[text()='Pickup Cancelled']");
    By confirmForReason = By.xpath("//span[text()='Please tell us the reason']/following-sibling::div/button/span[text()='CONFIRM']");
    By cancelConfirmationBox = By.xpath("//div[text()='Cancel']");
    By rateOurService = By.xpath("//div[text()='How would you rate our service?']");
    By serviceBettermentOptions = By.xpath("//div[text()='What could be better?']/following-sibling::fieldset//label//input");
    By feedbackButton = By.xpath("//span[text()='Submit Feedback']");

    public boolean orderDetailsFromOrderConfirmation(String activity, String reason, String decision){
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

                WebElement confirmForReasonXpath = ActionMethods.FindElement(confirmForReason,driver,20,5);
                Assert.assertNotNull(confirmForReasonXpath);
                ActionMethods.ScrollIntoView(driver, confirmForReasonXpath);
                ActionMethods.JavaScriptClick(driver, confirmForReasonXpath);

                ActionMethods.EmbedText(SetUp.Sc,"Selected the Reason :: "+reason);

                WebElement cancelPopUpConfirmation = ActionMethods.FindElement(cancelConfirmationBox,driver,20,5);
                Assert.assertNotNull(cancelPopUpConfirmation);

                WebElement choiceOfCancellation = ActionMethods.FindElement(ActionMethods.textLocatorCreator.apply(yes_or_no_selection,
                        decision.toUpperCase(Locale.ROOT)),driver,20,5)   ;
                Assert.assertNotNull(choiceOfCancellation);
                ActionMethods.JavaScriptClick(driver, choiceOfCancellation);

                ActionMethods.EmbedText(SetUp.Sc,"In final Confirmation box clicked on :: "+decision);

                WebElement rateService = ActionMethods.FindElement(rateOurService,driver,20,5);
                Assert.assertNotNull(rateService);

                WebElement ratingService = ActionMethods.FindElement(serviceBettermentOptions,driver,20,5);
                Assert.assertNotNull(ratingService);
                ActionMethods.MoveTo(driver,true,ratingService );

                WebElement feedback = ActionMethods.FindElement(feedbackButton,driver,20,5);
                Assert.assertNotNull(feedback);
                ActionMethods.ScrollIntoView(driver, feedback);
                ActionMethods.JavaScriptClick(driver, feedback);

                WebElement pickUpCancelled_xpath = ActionMethods.FindElement(pickUpCancelled,driver, 20, 5);
                Assert.assertNotNull(pickUpCancelled_xpath);
                ActionMethods.ScrollIntoView(driver, pickUpCancelled_xpath);
                ActionMethods.embedScreenshot(driver, SetUp.Sc,"");
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
