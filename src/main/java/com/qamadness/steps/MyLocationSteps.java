package com.qamadness.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.qamadness.pages.front_end.MyLocationPage;

/**
 * Created by Vlad on 15.10.2015.
 */
public class MyLocationSteps extends ScenarioSteps {

    MyLocationPage myLocationPage;

    @Step
    public void choose_Country_Dropdown () {myLocationPage.selectCountry();}

    @Step
    public void choose_Region_Dropdown () {myLocationPage.selectRegion();}

    @Step
    public void locationNickName () {myLocationPage.locationNickName();}

    @Step
    public void addStreet () {myLocationPage.addStreet();}

    @Step
    public void addCity () {myLocationPage.addCity();}

    @Step
    public void addPostalCode () {myLocationPage.addPostalCode();}

    @Step
    public void clickSaveLocationButn () {myLocationPage.clickSaveLocationButn();}

    @Step
    public void checkOurLocation () {myLocationPage.checkOurLocation();}

    @Step
    public void deleteLocation () {myLocationPage.deleteLocation();}

    @Step
    public void clickConfirmButn () {myLocationPage.clickConfirmButn();}




}
