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
    public void type_First_Name (){
        profileInformationPage.enterFirstName();
    }

    @Step
    public void type_Last_Name (){
        profileInformationPage.enterLastName();
    }

    @Step
    public void save_Profile (){
        profileInformationPage.clickSaveProfileBtn();
    }

    @Step
    public void check_Saved_User_Name (){
        profileInformationPage.checkUserName();
    }


}
