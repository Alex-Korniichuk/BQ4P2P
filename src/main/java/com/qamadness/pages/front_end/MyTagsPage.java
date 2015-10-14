package com.qamadness.pages.front_end;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vlad on 14.10.2015.
 */
public class MyTagsPage extends PageObject {

    @FindBy (css = ".tag-link>a")
    WebElementFacade productTagButn;

    @FindBy (xpath = ".//*[@id='productTagName']")
    WebElementFacade tagField;

    @FindBy (css = "#bq-ui-2")
    WebElementFacade addTagBtn;

    @FindBy (xpath = ".//*[@id='nav-my-account']/li[9]/a")
    WebElementFacade myTagsLink;

    @FindBy(xpath = "//li[@class='my-account-nav']/a")
    WebElementFacade myAccountLink;

    @FindBy (xpath = ".//*[@id='nav-welcome']/div/div[2]/div/div[2]/a")
    WebElementFacade logOutLink;

    @FindBy (linkText = "autotest")
    WebElementFacade ourTag;

    public Boolean checkOurTag(){
        if (ourTag.isPresent() == true){
            System.out.println("Tag was added");
            return true;
        }else{
            assert (false);
            System.out.println("Tag isn't added");
            return false;
        }
    }

    public void clickTag() {ourTag.click();}


    public void clickProductTagBtn() {productTagButn.click();}

    public void fillNameField() {
        waitForRenderedElementsToBePresent(By.cssSelector("#productTagName"));
        WebElement nameField = getDriver().findElement(By.cssSelector("#productTagName"));
        nameField.sendKeys("autotest");
    }

    public void loggOut() {logOutLink.click();}

    public void addProductTagBtn() {addTagBtn.click();}

    public void addTagField() {tagField.sendKeys("autotest");}

    public void clickMyAccLink() {myAccountLink.click();}

    public void clickMyTagsLink() {myTagsLink.click();}




}
