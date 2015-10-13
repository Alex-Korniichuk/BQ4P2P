package com.qamadness.steps;

import com.qamadness.pages.front_end.CollaborativeCartsPage;
import com.qamadness.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 13.10.15.
 */
public class CollaborativeCartsPageSteps extends ScenarioSteps {

    CollaborativeCartsPage collaborativeCartsPage;

    @Step
    public void enter_New_Group_Name (){
        collaborativeCartsPage.enterNewGroupName();
    }

    @Step
    public void save_New_Group (){
        collaborativeCartsPage.clickSaveGroupBtn();
    }

    @Step
    public void check_That_Group_With_Appropriate_Name_Is_Created (){
        collaborativeCartsPage.checkThatGroupIsCreated();
    }

    @Step
    public void leave_Created_Group(){
        collaborativeCartsPage.clickLeaveGroupLink();
        collaborativeCartsPage.clickConfirmBtn();
    }
}
