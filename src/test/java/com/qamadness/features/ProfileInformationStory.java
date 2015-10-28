package com.qamadness.features;

import com.qamadness.steps.front_end_steps.HomePageSteps;
import com.qamadness.steps.front_end_steps.LoginSteps;
import com.qamadness.steps.front_end_steps.ProfileInformationPageSteps;
import com.qamadness.steps.front_end_steps.ShopBySupplierPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


/**
 * Created by alexandrakorniichuk on 09.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class ProfileInformationStory {

    public String expectedFirstName = "NewFirstName";
    public String expectedLastName = "NewLastName";
    public String currentPassword = "bquest1";
    public String newPassword = "Lambada2015";
    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public ProfileInformationPageSteps profileInformationPageSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Before
    public void login_to_the_site (){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
    }

    @Issue("AUT-44")

    @Test
    public void change_password (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Profile_Information_Page();
        profileInformationPageSteps.type_Current_Password(currentPassword);
        profileInformationPageSteps.type_New_Password(newPassword);
        profileInformationPageSteps.type_New_Password_Confirmation(newPassword);
        profileInformationPageSteps.save_New_Password();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,newPassword);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Profile_Information_Page();
        profileInformationPageSteps.type_Current_Password(newPassword);
        profileInformationPageSteps.type_New_Password(currentPassword);
        profileInformationPageSteps.type_New_Password_Confirmation(currentPassword);
        profileInformationPageSteps.save_New_Password();
    }

    @Issue("AUT-45")

    @Test
    public void change_first_and_last_name (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Profile_Information_Page();
        profileInformationPageSteps.type_First_Name(expectedFirstName);
        profileInformationPageSteps.type_Last_Name(expectedLastName);
        profileInformationPageSteps.save_Profile();
        homePageSteps.click_Main_Menu_Btn();
        profileInformationPageSteps.check_Saved_User_Name(expectedFirstName, expectedLastName);
        homePageSteps.click_Main_Menu_Btn();
        profileInformationPageSteps.type_First_Name("Robot");
        profileInformationPageSteps.type_Last_Name("Tester");
        profileInformationPageSteps.save_Profile();
    }

    @Issue("AUT-50")

    @Test
    public void change_site_language (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Profile_Information_Page();
        profileInformationPageSteps.select_Language("fr");
        profileInformationPageSteps.save_Preferences();
        profileInformationPageSteps.check_That_Language_Is_Changed_To_FR();
        profileInformationPageSteps.select_Language("default");
        profileInformationPageSteps.save_Preferences();
    }

    @Test
    public void change_currency_and_check_it_on_Supplier_Page (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Profile_Information_Page();
        profileInformationPageSteps.select_Currency("EUR");
        profileInformationPageSteps.save_Preferences();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_Product_And_Services_Tab();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        String actual_currency = shopBySupplierPageSteps.get_Product_Currency();
        profileInformationPageSteps.check_Currency_On_Shop_By_Supplier_Page(actual_currency, "€");
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Profile_Information_Page();
        profileInformationPageSteps.select_Currency("USD");
        profileInformationPageSteps.save_Preferences();
    }

    @After
    public void logout ()
    {
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
    }
}
