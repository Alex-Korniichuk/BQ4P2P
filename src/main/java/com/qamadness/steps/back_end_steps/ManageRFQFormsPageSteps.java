package com.qamadness.steps.back_end_steps;

import com.qamadness.pages.back_end.ManageRFQFormsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 28.10.15.
 */
public class ManageRFQFormsPageSteps extends ScenarioSteps {

    ManageRFQFormsPage manageRFQFormsPage;

    @Step
    public void search_Request_Form_By_Name (String name){
        manageRFQFormsPage.searchForRequestFormByName(name);
    }

    @Step
    public void click_Preview_Request_Form_Link (){
        manageRFQFormsPage.clickPreviewLink();
    }
}
