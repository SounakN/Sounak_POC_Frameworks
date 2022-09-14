package com.Automation.utilities;

//import java.awt.Robot;

import com.Automation.driver.BasicConstants;
import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

//import junit.framework.Assert;

public class ActionMethods {

    public static WebDriverWait wait;
    public static Actions actions ;


    public static BiFunction<String, String, By> textLocatorCreator = new BiFunction<String, String, By>() {
        @Override
        public By apply(String s, String s2) {
            return By.xpath(String.format(s,s2));
        }
    };

    public Date getDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date OutDate = formatter.parse(date);
            System.out.println(OutDate);
            return OutDate;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void SyncAndVisible(WebDriver driver, WebElement element) {
        try {
            FluentWait<WebDriver> wait = new WebDriverWait(driver, 300).ignoring(StaleElementReferenceException.class).pollingEvery(5, TimeUnit.SECONDS).withTimeout(30, TimeUnit.SECONDS);
            ;
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WaitforElementVisible(WebDriver driver, WebElement Elem, int Timeout) {
        try {
            wait = new WebDriverWait(driver, Timeout);
            wait.until(ExpectedConditions.visibilityOf(Elem));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean sync_withNoSuchElemAndStateElement(WebDriver driver, WebElement element) {
        try {
            FluentWait<WebDriver> wait = new WebDriverWait(driver, 100).ignoring(NoSuchElementException.class).pollingEvery(5, TimeUnit.SECONDS).withTimeout(30, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("No Suh Elem");
            return false;
        } catch (ElementNotVisibleException e) {
            System.out.println("Elem not visible");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Timed Out");
            return false;
        }
    }


    public static Boolean syncClickable(WebDriver driver, WebElement element) {
        try {
            FluentWait<WebDriver> wait = (WebDriverWait) new WebDriverWait(driver, 100).ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (ElementNotInteractableException e) {
            System.out.println("Not interactable");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Timeout");
            return false;
        } catch (WebDriverException e) {
            System.out.println("WebDriver couldnot click");
            return false;
        }

    }

    public Boolean isClickable(WebDriver driver, WebElement element, int time) {
        try {
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return true;
        } catch (ElementNotInteractableException e) {
            System.out.println("Not interactable");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Timeout");
            return false;
        } catch (WebDriverException e) {
            System.out.println("WebDriver couldnot click");
            return false;
        }
    }

    public void HighlighterOnElem(WebDriver driver, WebElement Element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", Element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void JavaScriptClick(WebDriver driver, WebElement Element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", Element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OpenanewWindow(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open('');");
        } catch (Exception e) {

        }
    }

    public Boolean justClickable(WebDriver driver, WebElement element, int time) {
        try {
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (ElementNotInteractableException e) {
            System.out.println("Not interactable");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Timeout");
            return false;
        } catch (WebDriverException e) {
            System.out.println("WebDriver could not click");
            return false;
        }
    }

    public static void type(WebElement element, String str) {
        element.clear();
        element.sendKeys(str);
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public boolean verifyElement(Object element) {
        try {
            if (element instanceof WebElement) {
                if (((WebElement) element).isDisplayed()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("Object value null");
            e.printStackTrace();
            return false;
        } catch (ElementNotVisibleException e) {
            System.out.println("Object not visible");
            e.printStackTrace();
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Object Not exists");
            e.printStackTrace();
            return false;
        }

    }

    public boolean isWebElementPresent(WebElement element, WebDriver driver, int time) {
        try {
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("No Suh Elem");
            return false;
        } catch (ElementNotVisibleException e) {
            System.out.println("Elem not visible");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Timed Out");
            return false;
        }

    }

    public static Boolean ScrollIntoView(WebDriver driver, WebElement Element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", Element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setClipBoardData(String str) {
        StringSelection stringselection = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
    }


    //Click on the Dropdown button and then Select the option from Visible Text
    //WebElement of the Dropdown, Text to chose from
    public void selectDropDownValueByVisibleText(WebDriver driver, By locator, String visibleText) {
        Select se = new Select(driver.findElement(locator));
        se.selectByVisibleText(visibleText);
    }

    //Click on the Dropdown button and then Select the choice based on index
    //WebDriver, WebElement of the Dropdown, Select class locator, Text to chose from
    public void selectElementFromDropDownbyIndex(WebDriver driver, WebElement element, By Dropdown, int index) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Dropdown));
        WebElement Dropwdown_Elem = FindElement(Dropdown, driver, 5, 1);
        Select dropDown = new Select(Dropwdown_Elem);
        dropDown.selectByIndex(index);
    }

    //Click on the Dropdown button and then Select the choice based on value
    //WebDriver, WebElement of the Dropdown, Select class locator, Text to chose from
    public static void selectElementFromDropDownbyValue(WebDriver driver, WebElement element, By Dropdown, String value) {
       wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Dropdown));
        WebElement Dropwdown_Elem = FindElement(Dropdown, driver, 5, 1);
        Select dropDown = new Select(Dropwdown_Elem);
        dropDown.selectByValue(value);
    }
    public static void selectElementFromDropDownbyValue(WebDriver driver, By Dropdown, String value) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(Dropdown));
        WebElement Dropwdown_Elem = FindElement(Dropdown, driver, 5, 1);
        Dropwdown_Elem.click();
        Select dropDown = new Select(Dropwdown_Elem);
        dropDown.selectByValue(value);
    }

    //Click on the Dropdown button and then De-Select the choice based on Text
    //WebDriver, WebElement of the Dropdown, Select class locator, Text to chose from
    public void DeselectElementFromDropDownbyVisibleText(WebDriver driver, WebElement element, By Dropdown, String text) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Dropdown));
        WebElement Dropwdown_Elem = FindElement(Dropdown, driver, 5, 1);
        Select dropDown = new Select(Dropwdown_Elem);
        dropDown.deselectByVisibleText(text);
    }

    //Click on the Dropdown button and then De-Select the choice based on Index
    //WebDriver, WebElement of the Dropdown, Select class locator, Text to chose from
    public void DeselectElementFromDropDownbyIndex(WebDriver driver, WebElement element, By Dropdown, int index) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Dropdown));
        WebElement Dropwdown_Elem = FindElement(Dropdown, driver, 5, 1);
        Select dropDown = new Select(Dropwdown_Elem);
        dropDown.deselectByIndex(index);
    }

    //Click on the Dropdown button and then De-Select the choice based on Index
    //WebDriver, WebElement of the Dropdown, Select class locator, Text to chose from
    public void DeselectElementFromDropDownbyValue(WebDriver driver, WebElement element, By Dropdown, String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Dropdown));
        WebElement Dropwdown_Elem = FindElement(Dropdown, driver, 5, 1);
        Select dropDown = new Select(Dropwdown_Elem);
        dropDown.deselectByValue(Value);
    }
    public static void pageLoadCompleteByJavaScript(WebDriver driver){
        wait = new WebDriverWait(driver, 30);
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    //Scroll Down by certain given Pixel
    //Webdriver and pixel by which to scroll down
    public void scrollDownBy(WebDriver driver, int val) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + val + ")");
    }

    //Scroll Up by certain given Pixel
    //WebDriver and pixel by which to scroll up
    public void scrollUpBy(WebDriver driver, int val) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -" + val + ")");
    }

    //Scroll down to the bottom of the page
    //WebDriver
    public void scrollDownPageBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //Scroll down to the bottom of the page
    //WebDriver
    public void scrollUpPageTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
    }


    //Match a text with the Driver Title
    //Param WebDriver, String Title to be matched
    public boolean checkTitle(WebDriver driver, String title) {
        try {
            if (driver.getTitle().equalsIgnoreCase(title)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public void waiting(long a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Select a checkbox
    //Param WebElement
    public static boolean Checkbox_Select(WebDriver driver,WebElement element) {
        try {
            if (element.isSelected()) {

            } else {
                MoveTo(driver,true, element);
                Thread.sleep(2000);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Un-Select a checkbox
    //Param WebElement
    public void Checkbox_UnSelect(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isSelected()) {
                element.click();
                Thread.sleep(2000);
            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Scroll Element in view
    //Param WebDriver and Element
    public void scrollToElement(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    //Check for the Presence of Alert and Switch if needed
    //Param WeDriver and Boolean flag if true then accept else dismiss
    public boolean Alert_isPresent(WebDriver driver, Boolean toDO) {
        try {
            wait.until((ExpectedConditions.alertIsPresent()));
            Alert alert = driver.switchTo().alert();
            if (toDO) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //Check for the Presence of Alert and Switch if needed
    //Param WeDriver and Boolean flag if true then accept else dismiss
    public boolean Alert_Send_Text_Accept(WebDriver driver, String text) {
        try {
            wait.until((ExpectedConditions.alertIsPresent()));
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //JavaScript Executor Click
    public void jsClick(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    //Find the first or Default child Element from a List fo WebElement where a text matches
    //Param WebDriver, List of WebElements, by locator, String text
    //Returns WebElement Parent
    public WebElement matchtextfromChildElementandReturnParentElement(WebDriver driver, List<WebElement> ListElem, By bylocator, String Sentdata) {
        WebElement ParentReturn = null;
        WebElement ChildReturn = null;
        for (WebElement Elem : ListElem) {
            ChildReturn = FindElement(bylocator, Elem, driver, 5, 1);
            String data = ChildReturn.getText();
            if (data.trim().contains(Sentdata)) {
                ParentReturn = Elem;
                break;
            }
        }
        return ParentReturn;
    }

    //Find the first or Default child Element from a List fo WebElement where a text matches
    //Param WebDriver, List of WebElements, by locator, String text
    //Returns WebElement Child
    public WebElement matchtextfromChildElementandRetrunChildElement(WebDriver driver, List<WebElement> ListElem, By bylocator, String Sentdata) {
        WebElement ChildReturn = null;
        for (WebElement Elem : ListElem) {
            ChildReturn = FindElement(bylocator, Elem, driver, 5, 1);
            String data = ChildReturn.getText();
            if (data.trim().contains(Sentdata)) {
                break;
            }
        }
        return ChildReturn;
    }

    //Return a single element first or default search result from a List of Element based on the Matched Text
    //Param List of WebElement and Text Data
    //Returns WebElement
    public WebElement returnWebElementfromList(List<WebElement> ListElem, String textdata) {
        WebElement toFind = null;
        for (WebElement elem : ListElem) {
            String ExtractedText = elem.getText();
            if (elem.getText().contains(textdata)) {
                toFind = elem;
                break;
            }
        }
        return toFind;
    }

    //Return count of occurence of a text from a series of WebElement
    //Param List of WebElement and Text Data
    //Returns Integer
    public int returnCountofOccurenceofText(List<WebElement> ListElem, String textdata) {
        int count = 0;
        for (WebElement elem : ListElem) {
            String ExtractedText = elem.getText();
            if (elem.getText().contains(textdata)) {
                count++;
            }
        }
        return count;
    }

    //Find the First Matching Child Element from a List of Element
    //Param Webdriver, List of WebElement, Locator, Timeout and Polltime
    //Returns WebElement
    public WebElement FindmatchingElementfromlist(WebDriver driver, List<WebElement> ListElem, By locator, int timeout, int polltime) {
        WebElement toReturn = null;
        turnOffImplicitWaits(driver);
        for (WebElement elem : ListElem) {
            if (toReturn == null) {
                toReturn = FindElement(locator, elem, driver, timeout, polltime);
            } else {
                break;
            }
        }
        turnOnImplicitWaits(driver);
        return toReturn;
    }

    //Find the count Matching Child Element from a List of Element
    //Param Webdriver, List of WebElement, Locator, Timeout and Polltime
    //Returns the Integer count
    public int FindcountofmatchingElementfromlist(WebDriver driver, List<WebElement> ListElem, By locator, int timeout, int polltime) {
        WebElement toReturn = null;
        int count = 0;
        turnOffImplicitWaits(driver);
        for (WebElement elem : ListElem) {
            toReturn = FindElement(locator, elem, driver, timeout, polltime);
            if (toReturn != null) {
                count++;
                toReturn = null;
            }
        }
        turnOnImplicitWaits(driver);
        return count;
    }

    //Embed Screenshots with Messages in Cucumber Report
    public static void embedScreenshot(WebDriver driver, Scenario result, String message) {

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        result.attach(screenshot, "image/png", message);
        result.log(message);
    }

    public static Boolean Wait_Till_Element_Text_Changes(WebDriver driver, By loc, String Text, long time) {
        try {
            wait = new WebDriverWait(driver, time);
            return wait.until(ExpectedConditions.textToBe(loc, Text));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Invisibility_of_Element(By loc, WebDriver driver, long time) {
        try {
            ActionMethods.turnOffImplicitWaits(driver);
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loc));
            ActionMethods.turnOnImplicitWaits(driver);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Embed Text Logs in Cucumber Report
    public static void EmbedText(Scenario result, String message) {
        result.log(message);
    }

    //Find Element with Fluent wait ignoring Exceptions
    //Param By Locator, WebElement, WebDriver, Timeout, polltime
    //Returns a WebElement or NUll in case of a Timeout
    public static WebElement FindElement(By Locator, WebDriver driver, int timeout, int polltime) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)

                    .pollingEvery(polltime, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class).ignoring(org.openqa.selenium.NoSuchElementException.class).ignoring(ElementNotVisibleException.class);
            ;
            WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(Locator);
                }
            });

            return foo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            return null;
        }
    }

    //Find list of Elements with Fluent wait ignoring Exceptions
    //Param By Locator, WebElement, WebDriver, Timeout, polltime
    //Returns List of WebElement or NUll in case of a Timeout
    public static List<WebElement> FindElements(By Locator, WebDriver driver, int timeout, int polltime) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)

                    .pollingEvery(polltime, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class).ignoring(org.openqa.selenium.NoSuchElementException.class).ignoring(ElementNotVisibleException.class).ignoring(TimeoutException.class);
            ;
            List<WebElement> foo = wait.until(new Function<WebDriver, List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(Locator);
                }
            });
            return foo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            return null;
        }
    }

    //Find Element with Fluent wait ignoring Exceptions on Another Element
    //Param By Locator, WebElement, WebDriver, Timeout, polltime
    //Returns WebElement or NUll in case of a Timeout
    public static WebElement FindElement(By Locator, WebElement elem, WebDriver driver, int timeout, int polltime) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)

                    .pollingEvery(polltime, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class);
            ;
            BiFunction<WebElement, By, WebElement> foo = new BiFunction<WebElement, By, WebElement>() {
                @Override
                public WebElement apply(WebElement webElement, By by) {
                    return webElement.findElement(by);
                }
            };

            return wait.until(ExpectedConditions.visibilityOf(foo.apply(elem, Locator)));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public static Boolean waitforDOMStability(WebDriver driver) {
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, BasicConstants.EXPLICIT_WAIT_TIMEOUT);
			/*wait.until((ExpectedCondition<Boolean>) wd ->
					((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));*/
            Boolean x = wait.until((ExpectedCondition<Boolean>) driver1 -> {
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                return true;
            });
            return x;
        } catch (TimeoutException e) {
            return false;
        }

    }

    //Turn off the implicit wait
    public static void turnOffImplicitWaits(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    //Turn on the implicit wait
    public static void turnOnImplicitWaits(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(BasicConstants.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    //Assert the exact matching of a send in text with an Element Text
    //param is WebElement, and String text
    public void matchElementText(WebElement Elem, String text) {
        String extractedText = Elem.getText().trim();
        Assert.assertEquals(text, extractedText);
    }

    //Assert the whether a WebElement text contains the send in Text
    //param is WebElement, and String text
    public void containsElementText(WebElement Elem, String text) {
        String extractedText = Elem.getText().trim();
        Assert.assertTrue(extractedText.contains(text));
    }

    //Get WebElement text
    //param is WebElement
    //Returns WebElements text
    public String getElementText(WebElement elem) {
        String eleText = "";
        try {
            eleText = elem.getText().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eleText;
    }

    //Move To an Element
    //Param(true for clicking, False for not clicking), Webdriver, WebElement
    public static void MoveTo(WebDriver driver, boolean check, WebElement elem) {
        actions = new Actions(driver);
        if (check) {
            actions.moveToElement(elem).click().perform();
        } else {
            actions.moveToElement(elem).perform();
        }
    }

    public void clickElement(WebDriver driver, By locator) {
        try {
            waitForElement(driver, locator);
//			scrollToElement(driver,driver.findElement(locator));
            driver.findElement(locator).click();

        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public void waitForElement(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public void sendKeys(WebDriver driver, By locator, String key) {
        try {
            waitForElement(driver, locator);
            driver.findElement(locator).click();
            driver.findElement(locator).sendKeys(key);
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public void sendKeysOTP(WebDriver driver, By locator, String value) {
        try {
            driver.findElement(locator).clear();
            driver.findElement(locator).click();
            driver.findElement(locator).sendKeys(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, By locate) {
        try {
            return driver.findElement(locate).isDisplayed();
        } catch (Exception ex) {
            //ex.printStackTrace();
            return false;
        }
    }

    public boolean isElementEnabled(WebDriver driver, By locate) {
        try {
            return driver.findElement(locate).isEnabled();
        } catch (Exception ex) {
            //ex.printStackTrace();
            return false;
        }
    }

    public void waitForElementtoVisible(WebDriver driver, By locator, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public void dragAndDropElement(WebDriver driver, WebElement source, WebElement destination) {
        try {
            Actions action = new Actions(driver);
            action.dragAndDrop(source, destination).build().perform();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public void writeImportApplicationDetailsIntoCSV(List<String> columns) throws IOException {
        String[] columnsToUpdate = {"firstName", "lastName", "email", "phoneNumber", "programKey", "programPackageKey"};
        File inputFile = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/import-application-sample.csv");
        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        String[] strArray = csvBody.get(0);
        for (int j = 0; j < columnsToUpdate.length; j++) {
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].equalsIgnoreCase(columnsToUpdate[j])) { //String to be replaced
                    csvBody.get(1)[i] = columns.get(j); //Target replacement
                    break;
                }
            }
        }
        reader.close();
        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    public void writeShortlistApplicationDetailsIntoCSV(String emailId) throws IOException {
        File inputFile = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/Sample_Shortlisting_New.csv");
        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        String[] strArray = csvBody.get(0);
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equalsIgnoreCase("email")) { //String to be replaced
                csvBody.get(1)[i] = emailId; //Target replacement
            } else if (strArray[i].equalsIgnoreCase("paymentBatchName")) {
                csvBody.get(1)[i] = "";
            }
        }
        reader.close();
        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    public String readEmailIdFromImportCSV() throws IOException {
        String emailId = "";
        File inputFile = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/import-application-sample.csv");
        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        String[] strArray = csvBody.get(0);
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equalsIgnoreCase("email")) {
                emailId = csvBody.get(1)[i];
            }
        }
        reader.close();
        return emailId;
    }

    public String readUseNameFromImportCSV() throws IOException {
        String userName = "", fName = "", lName = "";
        File inputFile = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/import-application-sample.csv");
        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        String[] strArray = csvBody.get(0);
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equalsIgnoreCase("firstName")) {
                fName = csvBody.get(1)[i];
            }
            if (strArray[i].equalsIgnoreCase("lastName")) {
                lName = csvBody.get(1)[i];
            }
        }
        userName = fName + " " + lName;
        reader.close();
        return userName;
    }

    public List<String> generateUserDetails() throws Exception {
        String specialChars = "[`~!@#$%^&*()_+\\[\\]\\\\;\',./{}|:\"<>?]";
        List<String> userDetails = new ArrayList<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName().replaceAll(specialChars, ""); // Emory
        userDetails.add(firstName);
        String lastName = faker.name().lastName().replaceAll(specialChars, ""); // Barton
        userDetails.add(lastName);
        String number = faker.number().digit();
        String email = firstName.trim() + lastName.trim() + number + "@gmail.com";
        userDetails.add(email);
        String phoneNumber = faker.phoneNumber().subscriberNumber(10).replace("0", "7");
        userDetails.add(phoneNumber);
//		userDetails.add(prop.getProperty("ProgramKey"));
//		userDetails.add(prop.getProperty("ProgramPackageKey"));
        return userDetails;
    }

    public void uploadFile(String filePath) throws AWTException, InterruptedException {
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
