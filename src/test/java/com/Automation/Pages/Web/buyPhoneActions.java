package com.Automation.Pages.Web;

import com.Automation.StepDefinitions.Web.SetUp;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.ActionMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class buyPhoneActions {

    private WebDriver driver;
    private commonActions commonActions = new commonActions();

    By listOfPhones = By.xpath("//div[contains(@class,'products-container')]/div");
    //Doesnot have different buy phone and Add to cart DOM naming structure
    By buyPhoneButton = By.xpath("//button[@class='buy-now-cart gkbybtn']");
    By checkOut = By.xpath("//button[text()='Checkout']");
    By continueToShipping = By.xpath("//button/span[text()='Continue to shipping']");
    By tableRows = By.xpath("//div[@role='table']/div[@role='row']");
    private String phonePrice;

    public buyPhoneActions() {
        driver= WebBrowser.getDriver();
    }

    public boolean choosePhone(String phoneName){
        try{
            List<WebElement> listOfPhonesXpath = ActionMethods.FindElements(listOfPhones,driver,30,5);
            WebElement phoneChoice = listOfPhonesXpath.stream().filter(x-> ActionMethods.FindElement(By.xpath("./a//h3"),x,driver,5,1)
                   .getText().equals(phoneName)).findFirst().orElse(ActionMethods.FindElement(By.xpath("./a//h3"),listOfPhonesXpath.get(0),driver,5,1));
            phonePrice = phoneChoice.findElement(By.xpath("./a//div[@class='product-prices']/p/span")).getText()
                    .replace("₹","").trim();
            phoneChoice.click();
            ActionMethods.EmbedText(SetUp.Sc,"Found the Phone :: "+phoneName+" of the given current price :: "+phonePrice);


            ActionMethods.JavaScriptClick(driver, ActionMethods.FindElement(buyPhoneButton,driver,20,1));
            ActionMethods.EmbedText(SetUp.Sc,"Clicked on Buy now");
            ActionMethods.JavaScriptClick(driver, ActionMethods.FindElement(checkOut,driver,20,1));
            ActionMethods.EmbedText(SetUp.Sc,"Clicked on Checkout");

            return true;

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean provideShippingInformation(String type, String value){
        try{
            switch(type){
                case "Email":
                case "First name":
                case "Last name":
                case "Address":
                case "City":
                case "PIN code":
                case "Phone":
                    WebElement textBox = ActionMethods.FindElement(By.xpath("//input[@placeholder='"+type+"']"),driver,20,10);
                    ActionMethods.ScrollIntoView(driver,textBox );
                    ActionMethods.type(textBox,value);
                    ActionMethods.EmbedText(SetUp.Sc,"Filled value for the Text Box :: "+type+" with the value :: "+value);
                    break;

                case "State":
                    ActionMethods.selectElementFromDropDownbyValue(driver,By.xpath("//select[@placeholder='"+type+"']"),value);
                    ActionMethods.EmbedText(SetUp.Sc,"Selected value for the Dropdown :: "+type+" with the value :: "+value);
                    break;

            }


            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickContinueShipping(){
        try{
            ActionMethods.JavaScriptClick(driver,ActionMethods.FindElement(continueToShipping,driver,10,1));
            ActionMethods.EmbedText(SetUp.Sc,"Clicked on Continue Shipping");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean shippingInformationVerification(List<Map<String,String>> tableValues) {
        try{
            List<WebElement>  rows = ActionMethods.FindElements(tableRows,driver, 30, 5);
            rows.stream().forEach(x->{
                String rowHeader = ActionMethods.FindElement(By.xpath("./div[1]/div[@role='rowheader']"),x,driver,20,4).getText().trim();
                if(rowHeader.equals("Contact")){
                    String rowValue = ActionMethods.FindElement(By.xpath("./div[1]/div[@role='cell']/bdo"),x,driver,20,4).getText().trim();
                    Assert.assertTrue(rowValue.equals(tableValues.get(0).get("Email")));
                }else{

                }
            });
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
