package com.Automation.Pages.Web;

import com.Automation.driver.BasicConstants;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.ActionMethods;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;

public class commonActions {
    private WebDriver driver;

    By buttonMuiButtonParents = By.xpath("//*[contains(@class,'MuiButton-label')]");
    By buttonMuiButtonParentsGOTIT = By.xpath("//*[@class='MuiButton-label' and text()='"+BasicConstants.GOTIT+"']");
    public commonActions() {
        this.driver = WebBrowser.getDriver();
    }

    public  boolean clickOnButton(String buttonName, boolean clickType){
        try{
            WebElement button = null;
            if(buttonName.equals(BasicConstants.GOTIT)){
                button = ActionMethods.FindElement(buttonMuiButtonParentsGOTIT,driver,30,5);
            }else{
                List<WebElement> buttonsOnPage = ActionMethods.FindElements(buttonMuiButtonParents,driver,20,5);
                button = buttonsOnPage.stream().filter(x->{
                    try{
                        x.getText().contains(buttonName);
                        return true;
                    }catch(StaleElementReferenceException e){
                        return false;
                    }

                }).findFirst().orElse(null);
                Assert.assertNotNull(button);
                Assert.assertTrue(ActionMethods.syncClickable(driver,button));
            }

                if(clickType){
                    try{
                        button.click();
                    }catch(ElementNotInteractableException e){
                        ActionMethods.ScrollIntoView(driver, button);
                        button.click();
                    }
                }else{
                    ActionMethods.ScrollIntoView(driver, button);
                    ActionMethods.JavaScriptClick(driver,button);
                }

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
