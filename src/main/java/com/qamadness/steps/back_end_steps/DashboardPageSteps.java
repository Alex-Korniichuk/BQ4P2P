package com.qamadness.steps.back_end_steps;

import com.qamadness.pages.back_end.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 28.10.15.
 */
public class DashboardPageSteps extends ScenarioSteps {

    DashboardPage dashboardPage;

    @Step
    public void check_That_Admin_Is_Logged_In (){
        dashboardPage.checkThatAdminLoggedIn();
    }

    @Step
    public void click_Show_Menu_Button (){
        dashboardPage.clickShowMenuBtn();
    }

    @Step
    public void logout_From_Admin (){
        dashboardPage.logOutFromAdmin();
    }

    @Step
    public void open_Manage_RFQ_Forms_Page (){
        dashboardPage.expandRFQSMenuBlock();
        dashboardPage.clickManageRFQFormsLink();
    }
}
