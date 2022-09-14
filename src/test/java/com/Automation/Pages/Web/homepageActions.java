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

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.IntStream;

@Slf4j
public class homepageActions {
    private WebDriver driver;

    private WebElement choiceHeader = null;
    private commonActions commonActions = new commonActions();
    //Page wise Constants
    private static final String defaultLocation = "Select City";
    private static final String defaultPlaceHolderChooseCity = "Search your city or pincode";
    private static final String enterPhoneNumber = "Enter your phone number";
    //String locators
    private String selectCity_String = "//span[text()='%s']";
    private String placeHolderChooseCity = "//input[@placeholder='%s']";
    private String loginNumberInput = "//h6[text()='%s']/following-sibling::div//input";
    // By Locators for the Page
    By homepageVerification = By.xpath("//span/div[text()='Sell now']");
    By chooseLocation = By.xpath("//div[text()='Choose your location']");
    By navigationHeaders = By.xpath("//div[@id='navigation_nodes']/div");
    By acknowledgementCheckBox = By.xpath("(//input[@type='checkbox'])[2]");
    By otpBox = By.xpath("//input[@name = 'num_enter']");
    By Continue = By.xpath("//*[contains(text(),'CONTINUE')]/ancestor::button");
    public homepageActions() {
        driver = WebBrowser.getDriver();
    }

    public Boolean userLaunchesURL(String url) {
        try {
            driver.get(EnvUtil.getProperty(url));
            ActionMethods.FindElement(homepageVerification, driver, 30, 5).isDisplayed();
            ActionMethods.EmbedText(SetUp.Sc, "user launched the URL :: '" + EnvUtil.getProperty(url) + "' and landed on the homepage");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String phoneNumber, String OTP) {
        try {
            String phone = EnvUtil.getProperty(phoneNumber);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");
            LocalDateTime now = LocalDateTime.now();
            String otp = OTP.equals("Test_OTP") ? dtf.format(now) : EnvUtil.getProperty(OTP);

            Assert.assertTrue(commonActions.clickOnButton("Login", true));
            ActionMethods.EmbedText(SetUp.Sc, "Clicked on the Button :: Login");
            By enterPhoneNumberLoc = ActionMethods.textLocatorCreator.apply(loginNumberInput,enterPhoneNumber);
            WebElement inputTextBox = ActionMethods.FindElement(enterPhoneNumberLoc,driver,20,5);
            inputTextBox.sendKeys(phone);
            Assert.assertTrue(ActionMethods.Checkbox_Select(driver, ActionMethods.FindElement(acknowledgementCheckBox,driver,20,5)));
            ActionMethods.JavaScriptClick(driver,ActionMethods.FindElement(Continue,driver,20,5));
            ActionMethods.EmbedText(SetUp.Sc, "Clicked on the Button :: CONTINUE");

            List<WebElement> otpBoxes = ActionMethods.FindElements(otpBox,driver,30,5);
            for(int i = 0;i<otpBoxes.size();i++){
                otpBoxes.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean userChangesLocation(String location) {
        try {
            By selectCity = ActionMethods.textLocatorCreator.apply(selectCity_String, defaultLocation);

            WebElement sCity = ActionMethods.FindElement(selectCity, driver, 30, 5);
            Assert.assertNotNull(sCity);
            ActionMethods.EmbedText(SetUp.Sc, "Located the Select City option");

            sCity.click();
            ActionMethods.FindElement(chooseLocation, driver, 30, 5).isDisplayed();
            ActionMethods.EmbedText(SetUp.Sc, "Clicked on the Select city option");
            By textBoxChooseCity = ActionMethods.textLocatorCreator.apply(placeHolderChooseCity, defaultPlaceHolderChooseCity);
            WebElement textBoxChooseCity_elem = ActionMethods.FindElement(textBoxChooseCity, driver, 30, 5);
            Assert.assertNotNull(textBoxChooseCity_elem);
            ActionMethods.type(textBoxChooseCity_elem, location);

            ActionMethods.EmbedText(SetUp.Sc, "Landed on the Choose location page");
            By suggestionCity = ActionMethods.textLocatorCreator.apply(placeHolderChooseCity + "/ancestor::div[@class='MuiGrid-root  flwidth MuiGrid-item']/following-sibling::div//ul/div", defaultPlaceHolderChooseCity);
            List<WebElement> listOfCityChoice = ActionMethods.FindElements(suggestionCity, driver, 30, 5);
            Assert.assertTrue(listOfCityChoice.size() == 1);
            Assert.assertTrue(listOfCityChoice.get(0).getText().contains(location));

            ActionMethods.EmbedText(SetUp.Sc, "Searched for the location :: " + location + " and got 1 selectable option");

            ActionMethods.FindElement(By.xpath("./span[1]"), listOfCityChoice.get(0), driver, 30, 5).click();
            selectCity = ActionMethods.textLocatorCreator.apply(selectCity_String, location);
            sCity = ActionMethods.FindElement(selectCity, driver, 30, 5);
            Assert.assertNotNull(sCity);
            ActionMethods.embedScreenshot(driver, SetUp.Sc, "Select city now showing the location :: " + location);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean chooseHeader(String headerChoice) {
        try {
            List<WebElement> headerChoices = ActionMethods.FindElements(navigationHeaders, driver, 30, 5);
            choiceHeader = headerChoices.stream().filter(x -> ActionMethods.FindElement(By.xpath("./a"), x, driver, 20, 5).getAttribute("title")
                    .equals(headerChoice)).findFirst().get();

            Assert.assertNotNull(choiceHeader);
            ActionMethods.MoveTo(driver, false, choiceHeader);
            ActionMethods.EmbedText(SetUp.Sc, "Found the Header and hovered on it");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sellPhone(String type, String gadgetCompany) {
        try {
            ActionMethods.turnOffImplicitWaits(driver);
            String dynamicLoc = ".//div[text()='" + type + "']/following-sibling::div[1]//a/div[text()='" + gadgetCompany + "']";
            WebElement gadget = ActionMethods.FindElement(By.xpath(dynamicLoc), choiceHeader,
                    driver, 10, 1);
            Assert.assertNotNull(gadget);
            gadget.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean buyPhone(String type, String gadgetCompany) {
        try {
            String currentHandle = driver.getWindowHandle();
            ActionMethods.turnOffImplicitWaits(driver);
            String dynamicLoc = ".//div[text()='" + type + "']/following-sibling::div[1]//a/div[text()='" + gadgetCompany + "']";
            WebElement gadget = ActionMethods.FindElement(By.xpath(dynamicLoc), choiceHeader,
                    driver, 10, 1);
            Assert.assertNotNull(gadget);
            gadget.click();

            Set<String> windowHandles = new HashSet<>();
            while (windowHandles.size() < 2) {
                windowHandles = driver.getWindowHandles();
                ;
            }
            driver.switchTo().window(windowHandles.stream().filter(x -> !x.equalsIgnoreCase(currentHandle)).findFirst().get());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
