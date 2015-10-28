package com.qamadness.features;


import com.qamadness.steps.HomePageSteps;
import com.qamadness.steps.LoginSteps;
import com.qamadness.steps.MyLocationSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vlad on 15.10.2015.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class MyLocationStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public MyLocationSteps myLocationSteps;

    @Issue("AUT-")

    @Test
    public void add_New_Location() {
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_My_Location_Page();
        myLocationSteps.locationNickName();
        myLocationSteps.addStreet();
        myLocationSteps.choose_Country_Dropdown();
        myLocationSteps.choose_Region_Dropdown();
        myLocationSteps.addCity();
        myLocationSteps.addPostalCode();
        myLocationSteps.clickSaveLocationButn();
        myLocationSteps.checkOurLocation();
        myLocationSteps.deleteLocation();
        myLocationSteps.clickConfirmButn();

    }
}
