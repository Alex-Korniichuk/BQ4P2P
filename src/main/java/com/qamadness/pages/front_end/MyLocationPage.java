package com.qamadness.pages.front_end;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vlad on 15.10.2015.
 */
public class MyLocationPage extends PageObject{

    @FindBy (css = ".action>a")
    WebElementFacade addNewLocation;

    @FindBy (css = "#city")
    WebElementFacade addCityField;

    @FindBy (css = "#name")
    WebElementFacade addNickNameField;

    @FindBy (css = "#street1")
    WebElementFacade addStreetField;

    @FindBy (css = "#postcode")
    WebElementFacade addPostalCode;

    @FindBy (css = "#location-primary")
    WebElementFacade saveLocationButn;

    @FindBy(xpath = ".//*[@id='account-location-listing']/div[2]/div/div[2]/address")
    WebElementFacade locationTab;

    @FindBy (xpath = ".//*[@id='confirm_dialog_2']/div/div/div[3]/button[2]")
    WebElementFacade confirmButn;


    public void locationNickName () {addNickNameField.sendKeys("Auto Location");}

    public void addStreet () {addStreetField.sendKeys("Auto Street");}

    public void selectCountry() {
        Select country = new Select(getDriver().findElement(By.id("country")));
        country.selectByVisibleText("United States");
    }

    public void selectRegion() {
        Select region = new Select(getDriver().findElement(By.id("region_id")));
        region.selectByVisibleText("Alabama");
    }

    public void addCity () {addCityField.sendKeys("Auto City");}

    public void addPostalCode () {addPostalCode.sendKeys("1234567");}

    public void clickSaveLocationButn () {saveLocationButn.click();}

    public Boolean checkOurLocation () {
        setImplicitTimeout(60, TimeUnit.SECONDS);
        if (locationTab.isPresent() == true){
            System.out.println("Location is added");
            return true;
        }else{
            assert (false);
            System.out.println("Location isn't added");
            return false;
        }
    }

    public void deleteLocation () {
        waitForRenderedElementsToBePresent(org.openqa.selenium.By.xpath(".//*[@id='account-location-listing']/div[2]/div/div[2]/address/ul/li[2]/a"));
        WebElement deleteButn = getDriver().findElement(By.xpath(".//*[@id='account-location-listing']/div[2]/div/div[2]/address/ul/li[2]/a"));
        deleteButn.click();
    }

    public void clickConfirmButn () {confirmButn.click();}









}
