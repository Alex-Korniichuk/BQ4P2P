package com.qamadness.features;

import com.qamadness.steps.front_end_steps.CollaborativeCartsPageSteps;
import com.qamadness.steps.front_end_steps.HomePageSteps;
import com.qamadness.steps.front_end_steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by alexandrakorniichuk on 13.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class CollaborativeCartsStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public CollaborativeCartsPageSteps collaborativeCartsPageSteps;

    @Issue("AUT-49")

    @Test
    public void create_new_collaborative_group (){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_Collaborative_Carts_Page();
        collaborativeCartsPageSteps.enter_New_Group_Name();
        collaborativeCartsPageSteps.save_New_Group();
        collaborativeCartsPageSteps.check_That_Group_With_Appropriate_Name_Is_Created();
        collaborativeCartsPageSteps.leave_Created_Group();
    }

}

