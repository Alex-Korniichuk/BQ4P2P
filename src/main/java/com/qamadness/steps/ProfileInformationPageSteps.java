package com.qamadness.steps;

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


}
