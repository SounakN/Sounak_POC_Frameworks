package com.Automation.StepDefinitions.Web;

import com.Automation.Pages.Web.SeoAutomationPage;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.net.MalformedURLException;

public class SeoAutomationSteps {
    SeoAutomationPage SEOAutomation;
    public WebDriver driver;

    public SeoAutomationSteps() throws IOException {
        this.driver = SetUp.driver;
        SEOAutomation = new SeoAutomationPage();
    }




    @Given("User launches direct {string}")
    public void userLaunchesDirectWithCacheSetTo(String URL) throws MalformedURLException, InterruptedException {
        SEOAutomation.getToURL(URL);
    }


    @Given("SEO verification from the Sheet {string}")
    public void seoVerificationFromTheSheet(String sheetName) {
        try {
            SEOAutomation.SEOUtility(sheetName);
        } catch (Exception e) {

        }
    }

    @Given("User verifies the presence of the title and meta name description with Sheet {string}")
    public void userVerifiesThePresenceOfTheTitleAndMetaNameDescriptionWithSheet(String sheet) {
        try {
            SEOAutomation.title_meta_name(sheet);
        } catch (Exception e) {

        }
    }

    @And("opens the page source of {string} to search for {string}")
    public void opens_the_page_source_of(String page, String titleTag) throws Exception {
        SEOAutomation.openPageSource_titleTag(page, titleTag);
    }

    @And("{string} on the page source and confirm their presence")
    public void on_the_page_source(String metaNameDesc) throws Exception {
        SEOAutomation.openPageSource_metaNameDesc(metaNameDesc);
    }


    @And("opens page source of {string} to search {string} and {string} and confirm their presence")
    public void opens_page_source_of(String Page, String noIndex, String noFollow) throws Exception {
        SEOAutomation.openPageSource_noIndex_nofollow(Page, noIndex, noFollow);
    }
}
