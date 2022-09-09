package com.Automation.Pages.Web;

import com.Automation.StepDefinitions.Web.SetUp;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.BiFunction;

public class SeoAutomationPage {
    private final WebDriver driver;
    public Properties prop = null;
    private static String Cache_url= null;
    private static final String metaNameDesc="meta name description";
    private static HashMap<String, String> urlmapping = new HashMap<>();
    BiFunction<String, Object, By> XpathMaker = (x, y) -> By.xpath(String.format(String.format(x,y)));
    //private String cacheConstant = "http://webcache.googleusercontent.com/search?q=cache:";
    private String cacheConstant = "cache:";
    private String cache_link_toClick = "//span[text()='%s']";
    private By Link_to_validate = By.xpath("(//div[contains(@id,'google-cache-hdr')]/div/span/a)[1]");
    private final ActionMethods Commons = new ActionMethods();
    HashMap<Integer, ArrayList<String>> Excel_Verification = new HashMap<>();

    public SeoAutomationPage() throws IOException {
        this.driver=WebBrowser.getDriver();
        prop = EnvUtil.getProperties();
    }


    public void title_meta_name(String Sheet){
        String checkFilePresence = FileUtilities.deleteFile(System.getProperty("user.dir")+ File.separator+"build"+File.separator+File.separator+"SEO_Report");
        Assert.assertTrue(checkFilePresence.equals(FileUtilities.NONEXISTENT) || checkFilePresence.equals(FileUtilities.DELETED) || checkFilePresence.equals(FileUtilities.NOFILES));

        String filename = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData_MetaName_SEO.xlsx";
        Excel_Verification = Basic_Excel_Reader.Basic_Excel_Reader(filename,Sheet);
        for(int i = 1; i< Excel_Verification.size(); i++){

            Cache_url = Excel_Verification.get(i).get(2);
            driver.get(Cache_url);

            String titleTextIsPresent = driver.getTitle();
            System.out.println("The title is : " + titleTextIsPresent);

            if (titleTextIsPresent.equals("")) {
               Excel_Verification.get(i).set(3,"Failed as the page has no Title");
            }else{
                String metaName = driver.findElement(By.xpath("//meta[contains(@name,'description')]")).getAttribute("name");
                if (metaName.equals("")) {
                    Excel_Verification.get(i).set(3,"Failed as Meta name text / Meta tag is not present on");
                }else{
                    Excel_Verification.get(i).set(3,"Passed as Meta name text / Meta tag is present on "+metaName);
                }
            }
        }
        filename = System.getProperty("user.dir")+ File.separator+"build"+ File.separator+"SEO_Report"+File.separator+"Report_MetaName_SEO.xlsx";
        Basic_Excel_Writer.Excel_Writer_New_Excel_Google_SEO_Crawling_Specifics(filename,Sheet,Excel_Verification);
        /*Basic_Excel_Writer.Excel_Writer_Existing_Excel(filename,Sheet,Excel_Verification);*/
    }
    public void getToURL(String URL) throws MalformedURLException {
        String url = prop.getProperty(URL);
        driver.navigate().to(new URL (url));
        Commons.waiting(3000);
        ActionMethods.embedScreenshot(SetUp.driver, SetUp.Sc, "URL parsed:: " + prop.getProperty(URL));
    }

    public void SEOUtility(String Sheet) throws MalformedURLException, InterruptedException {
        String checkFilePresence = FileUtilities.deleteFile(System.getProperty("user.dir")+ File.separator+"build"+File.separator+File.separator+"SEO_Report");
        Assert.assertTrue(checkFilePresence.equals(FileUtilities.NONEXISTENT) || checkFilePresence.equals(FileUtilities.DELETED) || checkFilePresence.equals(FileUtilities.NOFILES));

        String filename = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData_Google_SEO.xlsx";
        Excel_Verification = Basic_Excel_Reader.Basic_Excel_Reader(filename,Sheet);
        String[] names = Sheet.split(" ");
        for(int i = 1; i< Excel_Verification.size(); i++){

            driver.get("https://www.google.com");
            Cache_url = Excel_Verification.get(i).get(2);
            WebElement gSearch = ActionMethods.FindElement(By.xpath("//input[@name='q']"),driver,10,1);
            gSearch.sendKeys(cacheConstant+Cache_url);
            gSearch.sendKeys(Keys.ENTER);

            ActionMethods.turnOffImplicitWaits(driver);
            WebElement Link_to_Click_xpath = ActionMethods.FindElement(XpathMaker.apply(cache_link_toClick,"Text-only version"),driver,5,1);

            if(Link_to_Click_xpath==null){
                WebElement Google_404 = ActionMethods.FindElement(By.xpath("//span[@id='logo' and @aria-label='Google']"),driver,3,1);

                if(Google_404!=null){
                    Excel_Verification.get(i).set(3,"Failed due to Google 404");
                    ActionMethods.embedScreenshot(driver, SetUp.Sc, "Failed due to Google 404");
                }else {
                    WebElement Captcha = ActionMethods.FindElement(By.xpath("//*[contains(@id,'recaptcha')]"),driver,3,1);
                    if (Captcha!=null){
                        Excel_Verification.get(i).set(3,"CAPTCHA Validation came UP");
                        ActionMethods.embedScreenshot(driver, SetUp.Sc, "CAPTCHA Validation came UP");
                    } else{
                        WebElement Crawling_404 = ActionMethods.FindElement(By.xpath("//h2[text()='Oops, Page Not Found']"),driver,3,1);
                        Excel_Verification.get(i).set(3,"Failed due to Crawling 404");
                        ActionMethods.embedScreenshot(driver, SetUp.Sc, "Failed due to Google 404");
                    }
                }

            }else{
                ActionMethods.JavaScriptClick(driver, Link_to_Click_xpath);
                //String url = prop.getProperty(actualLink);
                WebElement Link_to_validate_xpath = ActionMethods.FindElement(Link_to_validate,driver,30,5);
                Assert.assertNotNull(Link_to_validate_xpath);
                String Text = Link_to_validate_xpath.getText();
                String href = Link_to_validate_xpath.getAttribute("href");

                char car = Text.charAt(Text.length()-1);
                if(car=='/'){
                    if(Cache_url.equals(Text) && Cache_url.equals(href)){
                        Excel_Verification.get(i).set(3,"Passed");
                    }else{
                        Excel_Verification.get(i).set(3,"Failed while verifying URL");
                        ActionMethods.embedScreenshot(driver, SetUp.Sc, "Failed while verifying URL");
                    }
                }else{
                    if(Cache_url.substring(0,Cache_url.length()-1).equals(Text) && Cache_url.substring(0,Cache_url.length()-1).equals(href)){
                        Excel_Verification.get(i).set(3,"Passed");
                    }else{
                        Excel_Verification.get(i).set(3,"Failed while verifying URL");
                        ActionMethods.embedScreenshot(driver, SetUp.Sc, "Failed while verifying URL");
                    }
                }

            }
            ActionMethods.turnOnImplicitWaits(driver);
        }
        //Creating or Checking The existence of the folder
        String assertFileCreation = FileUtilities.createFolder(System.getProperty("user.dir")+ File.separator+"build","SEO_Report");
        Assert.assertTrue(assertFileCreation.equals(FileUtilities.CREATED) || assertFileCreation.equals(FileUtilities.EXISTING) );

        filename = System.getProperty("user.dir")+ File.separator+"build"+ File.separator+"SEO_Report"+File.separator+names[0]+"_"+names[1]+".xlsx";
        Basic_Excel_Writer.Excel_Writer_New_Excel_Google_SEO_Crawling_Specifics(filename,Sheet,Excel_Verification);
    }


    public void openPageSource_titleTag(String page, String titleTag) {
        String titleTextIsPresent = driver.getTitle();
        System.out.println("The title is : " + titleTextIsPresent);
        boolean flag = true;
        if (titleTextIsPresent.equals("")) {
            flag = false;
        }
        Assert.assertTrue("The " + page + " doesn't have a " + titleTag + " / Title Text!", flag);
    }

    public void openPageSource_metaNameDesc(String metaNameDesc) {
        String metaName = driver.findElement(By.xpath("//meta[contains(@name,'description')]")).getAttribute("name");
        System.out.println("Meta Name Text is : " + metaName);
        boolean flag = true;
        if (metaName.equals("")) {
            flag = false;
        }
        Assert.assertTrue("Meta name text / Meta tag is not present on " + metaNameDesc, flag);
    }

    public void openPageSource_noIndex_nofollow(String Page, String noIndex, String noFollow) {
        ActionMethods.turnOffImplicitWaits(driver);
        WebElement meta = ActionMethods.FindElement(By.xpath("//meta[contains(@content,'noindex,nofollow')]"), driver, 5, 1);
        System.out.println("Meta Content Text is : " + meta);
        if (meta == null) {
            Assert.assertTrue("The " + Page + " doesn't contains " + noIndex + " and " + noFollow + " meta tag attributes", true);
        } else
            Assert.fail("The " + Page + " contains " + noIndex + " and " + noFollow + " meta tag attributes");
    }

}