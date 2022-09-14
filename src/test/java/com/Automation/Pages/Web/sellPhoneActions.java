package com.Automation.Pages.Web;

import com.Automation.StepDefinitions.Web.SetUp;
import com.Automation.driver.BasicConstants;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.ActionMethods;
import com.Automation.utilities.EnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.*;

import static java.lang.Thread.sleep;


@Slf4j
public class sellPhoneActions {
    private WebDriver driver;
    private commonActions commonActions = new commonActions();
    //Page wise Constants
    private static final String headerForPage = "Select City";

    //String locators
    private String headerPageDescription_h1 = "//h1[contains(text(),'%s')]";
    private String headerPageDescription_h2 = "//h2[contains(text(),'%s')]";
    //Locators
    By textInputSearchModel = By.xpath("//input[@placeholder='Search model']");
    By searchList = By.xpath("//ul[contains(@id,'list_search')]//li");
    By variantCounts = By.xpath("//span[contains(text(),'GB')]");
    By questionList = By.xpath("//section[contains(@class,'mar-b20')]");
    By phoneOptionBoxes = By.xpath("//div[@class='layout horizontal wrap flwidth']/section/div[1]");
    By radioButtonForSavedAddress = By.xpath("(//div[text()='Other'])[3]/ancestor::span/preceding-sibling::div//input");
    By availableDate = By.xpath("//div[text()='Please select your preferable pickup date']/following-sibling::div[1]/div");
    By slots = By.xpath("//div[text()='Your availability on that day']/following-sibling::div[1]/div");
    By sellNowButton = By.xpath("(//span[text()='Sell Now']/ancestor::button)[1]");
    //Payment SLots
    By Upi = By.xpath("//div[text()='Select your payment mode']/following-sibling::div[2]//input");
    public sellPhoneActions() {
        driver= WebBrowser.getDriver();
    }
    public boolean presenceOfHeader_h1(String header){
        try{
            WebElement headerElem = ActionMethods.FindElement(ActionMethods.textLocatorCreator.apply(headerPageDescription_h1,header),driver,30,5);
            Assert.assertNotNull(headerElem);
            ActionMethods.embedScreenshot(driver, SetUp.Sc,"Found the header");
            return headerElem.isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean presenceOfHeader_h2(String header){
        try{
            WebElement headerElem = ActionMethods.FindElement(ActionMethods.textLocatorCreator.apply(headerPageDescription_h2,header),driver,30,5);
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
                sleep(3000);
                listOfSearches = ActionMethods.FindElements(searchList,driver,30,5);

                if(count>5){
                    log.info("Failed as couldnot get the values of the mobile from the Search mobile Dropdown");
                    return false;
                }else{
                    log.info("Waiting for the :: "+count+" times");
                }
            }
            WebElement variantChoices = listOfSearches.stream().filter(x-> x.getText().equals(modelName)).findFirst().get();
            ActionMethods.JavaScriptClick(driver,variantChoices);
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
    public boolean buttonClicks(String buttonName,boolean check){
        try{
            Assert.assertTrue(commonActions.clickOnButton(buttonName,check));
            ActionMethods.EmbedText(SetUp.Sc,"Clicked on the Button :: "+buttonName);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean sellNowButtonClick(){
        try{
            ActionMethods.JavaScriptClick(driver, ActionMethods.FindElement(sellNowButton,driver,20,5));
            ActionMethods.EmbedText(SetUp.Sc,"Clicked on the Button :: Sell Now");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean questionAndAnswers(String question, String answer){
        try{
            List<WebElement> questionsParent = ActionMethods.FindElements(questionList,driver,20,5);

            WebElement choiceOfQuestion = questionsParent.stream().filter(x->
                 ActionMethods.FindElement(By.xpath("./div[1]"),x,driver,20,1).getText().equals(question)).findFirst().get();
            WebElement choiceOfAnswers = choiceOfQuestion.findElement(By.xpath("./div[2]//input[@value='"+answer+"']"));
            try{
                choiceOfAnswers.click();
            }catch(ElementNotInteractableException e){
                ActionMethods.ScrollIntoView(driver, choiceOfAnswers);
                ActionMethods.JavaScriptClick(driver,choiceOfAnswers);
            }
            ActionMethods.EmbedText(SetUp.Sc,"Answered all questions");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean chooseAvailableAccessories(String header){
        try{
            WebElement headerH2 = ActionMethods.FindElement(By.xpath("//h2"),driver,30,2);
            Assert.assertTrue(headerH2.getText().equals(header));
            if(header.equals("What is your mobile age?")){
                ActionMethods.FindElement(By.xpath("//input[@type='radio']"),driver,20,5).click();
            }else{
                List<WebElement> dynamicBoxes = ActionMethods.FindElements(phoneOptionBoxes,driver,10,2);
                /*dynamicBoxes.stream().forEach(x->{
                    try{
                        x.click();
                    }catch(ElementNotInteractableException e){
                        ActionMethods.ScrollIntoView(driver,x);
                       ActionMethods.JavaScriptClick(driver,x);
                    }
                });*/
                ActionMethods.ScrollIntoView(driver,dynamicBoxes.get(0));
                ActionMethods.JavaScriptClick(driver,dynamicBoxes.get(0));

                Assert.assertTrue(buttonClicks(BasicConstants.CONTINUE,false));

                ActionMethods.EmbedText(SetUp.Sc,"Answered all queries from :: "+header);
            }


            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean pickUpInformation(String day, String slot,String paymentType){
        try{
            WebElement radiobutton = ActionMethods.FindElement(radioButtonForSavedAddress,driver,20,5);
            assert radiobutton != null;
            String checked = radiobutton.getAttribute("checked");
            if(checked == null){
                ActionMethods.MoveTo(driver,true,radiobutton);
            }
            buttonClicks("Continue",false);
            ActionMethods.EmbedText(SetUp.Sc,"Selected Address");

            List<WebElement> availableDates = ActionMethods.FindElements(availableDate,driver,20,5);
            ActionMethods.JavaScriptClick(driver, availableDates.get(Integer.parseInt(day)));
            //ActionMethods.EmbedText(SetUp.Sc,"Selected Date :: "+availableDates.get(Integer.parseInt(day)).getText());

            List<WebElement> availableSlots = ActionMethods.FindElements(slots,driver,20,5);
            ActionMethods.JavaScriptClick(driver, availableSlots.get(Integer.parseInt(slot)));
            //ActionMethods.EmbedText(SetUp.Sc,"Selected Date :: "+availableSlots.get(Integer.parseInt(slot)).getText());

            buttonClicks("Continue",false);

            //Payments
            switch(paymentType){
                case "Upi":
                   WebElement UPI =  ActionMethods.FindElement(Upi,driver, 20,5);
                   Assert.assertNotNull(UPI);
                   ActionMethods.JavaScriptClick(driver,UPI);
                break;

            }
            ActionMethods.EmbedText(SetUp.Sc,"Payments made with :: "+paymentType);
            buttonClicks("Confirm Order",false);
            ActionMethods.embedScreenshot(driver,SetUp.Sc,"");

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
