package com.Automation.Pages.Web;

import com.Automation.StepDefinitions.Web.SetUp;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.ActionMethods;
import com.Automation.utilities.EnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


@Slf4j
public class sellPhoneActions {
    private WebDriver driver;

    //Page wise Constants
    private static final String headerForPage = "Select City";

    //String locators
    private String headerPageDescription = "//h1[contains(text(),'%s')]";

    //Locators
    By textInputSearchModel = By.xpath("//input[@placeholder='Search model']");
    By searchList = By.xpath("//ul[contains(@id,'list_search')]//li");
    By variantCounts = By.xpath("//span[contains(text(),'GB')]");

    public sellPhoneActions() {
        driver= WebBrowser.getDriver();
    }
    public boolean presenceOfHeader(String header){
        try{
            WebElement headerElem = ActionMethods.FindElement(ActionMethods.textLocatorCreator.apply(headerPageDescription,header),driver,30,5);
            Assert.assertNotNull(headerElem);
            ActionMethods.embedScreenshot(driver, SetUp.Sc,"Found the header");
            return headerElem.isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean choosePhoneModel(String modelName){
        try{
            WebElement textBoxModelSearch = ActionMethods.FindElement(textInputSearchModel,driver,30,5);
            Assert.assertNotNull(textBoxModelSearch);
            ActionMethods.type(textBoxModelSearch,modelName);

            List<WebElement> listOfSearches = ActionMethods.FindElements(searchList,driver,30,5);
            Integer count =0;
            while(listOfSearches.size()==0){
                count++;
                Thread.sleep(3000);
                listOfSearches = ActionMethods.FindElements(searchList,driver,30,5);

                if(count>5){
                    log.info("Failed as couldnot get the values of the mobile from the Search mobile Dropdown");
                    return false;
                }else{
                    log.info("Waiting for the :: "+count+" times");
                }
            }
            WebElement variantChoices = listOfSearches.stream().filter(x-> x.getText().equals(modelName)).findFirst().get();
            variantChoices.click();
            ActionMethods.EmbedText(SetUp.Sc,"Choose the right model from the suggestive dropdown :: "+modelName);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean chooseVariant(String variantChoice){
        try{
            List<WebElement> variants = ActionMethods.FindElements(variantCounts,driver,30,5);
            WebElement choiceOfVariant = variants.stream().filter(x->x.getText().equals(variantChoice)).findFirst().orElse(null);
            Assert.assertNotNull(choiceOfVariant);
            choiceOfVariant.click();
            ActionMethods.EmbedText(SetUp.Sc,"Found the Variant :: "+variantChoice);

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean assertValuation(String modelName, String Variant){
        try{
            String phoneName = modelName.replace(" ","_")+"_"+Variant.replace(" ","_").replace("/","_");
            String price = EnvUtil.getProperty(phoneName);
            WebElement priceFromWebsite = ActionMethods.FindElement(By.xpath("//span[contains(text(),'"+price+"')]"),driver,30,5);
            Assert.assertNotNull(priceFromWebsite);
            ActionMethods.embedScreenshot(driver, SetUp.Sc,"Found the value and asserted it");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
