package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.ProfileInformationPage;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.annotations.Step;

/**
 * Created by alexandrakorniichuk on 09.10.15.
 */
public class ProfileInformationPageSteps extends ScenarioSteps {

    ProfileInformationPage profileInformationPage;

    @Step
    public void type_First_Name (String expectedFirstName){
        profileInformationPage.enterFirstName(expectedFirstName);
    }

    @Step
    public void type_Last_Name (String expectedLastName){
        profileInformationPage.enterLastName(expectedLastName);
    }

    @Step
    public void save_Profile (){
        profileInformationPage.clickSaveProfileBtn();
    }

    @Step
    public void check_Saved_User_Name (String expectedFirstName, String expectedLastName){
        profileInformationPage.checkUserName(expectedFirstName, expectedLastName);
    }

    @Step
    public void type_Current_Password (String currentPass){
        profileInformationPage.enterCurrentPass(currentPass);
    }

    @Step
    public void type_New_Password (String newPass){
        profileInformationPage.enterNewPass(newPass);
    }

    @Step
    public void type_New_Password_Confirmation (String confPass){
        profileInformationPage.enterConfirmPass(confPass);
    }

    @Step
    public void save_New_Password (){
        profileInformationPage.clickSavePassBtn();
    }

    @Step
    public void select_Language (String languageValue){
        profileInformationPage.selectLanguage(languageValue);
    }

    @Step
    public void save_Preferences (){
        profileInformationPage.clickSavePreferencesBtn();
    }

    @Step
    public void check_That_Language_Is_Changed_To_FR (){
        profileInformationPage.checkFRLanguage();
    }

    @Step
    public void select_Currency (String currencyValue){
        profileInformationPage.selectCurrency(currencyValue);
    }

    @Step
    public void check_Currency_On_Shop_By_Supplier_Page (String actualCurrency, String expectedCurrency){
        profileInformationPage.check_Currency(actualCurrency, expectedCurrency);
    }


}
