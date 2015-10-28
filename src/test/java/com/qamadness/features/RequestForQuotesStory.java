package com.qamadness.features;

import com.qamadness.pages.back_end.AdminLoginPage;
import com.qamadness.pages.back_end.DashboardPage;
import com.qamadness.pages.back_end.ManageRFQFormsPage;
import com.qamadness.pages.front_end.HomePage;
import com.qamadness.steps.back_end_steps.AdminLoginPageSteps;
import com.qamadness.steps.back_end_steps.DashboardPageSteps;
import com.qamadness.steps.back_end_steps.ManageRFQFormsPageSteps;
import com.qamadness.steps.back_end_steps.RequestForQuotePageSteps;
import com.qamadness.steps.front_end_steps.HomePageSteps;
import com.qamadness.steps.front_end_steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by alexandrakorniichuk on 28.10.15.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class RequestForQuotesStory {

    private String email;
    private String password;
    private String adminLogin;
    private String adminPassword;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    AdminLoginPageSteps adminLoginPageSteps;

    @Steps
    DashboardPageSteps dashboardPageSteps;

    @Steps
    ManageRFQFormsPageSteps manageRFQFormsPageSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    RequestForQuotePageSteps requestForQuotePageSteps;

    @Issue("AUT-56")
    @Test
    public void create_Request_For_Quote (){
        adminLoginPageSteps.open_Page();
        adminLoginPageSteps.enter_Credentials(adminLogin, adminPassword);
        adminLoginPageSteps.click_Login_Btn();
        dashboardPageSteps.check_That_Admin_Is_Logged_In();
        dashboardPageSteps.click_Show_Menu_Button();
        dashboardPageSteps.open_Manage_RFQ_Forms_Page();
        manageRFQFormsPageSteps.search_Request_Form_By_Name("Request For Quote");
        manageRFQFormsPageSteps.click_Preview_Request_Form_Link();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        requestForQuotePageSteps.enter_Quote_Title("Robot test quote title");
        requestForQuotePageSteps.select_Quote_Deadline();
        requestForQuotePageSteps.select_Quote_Need_By_Date();
        requestForQuotePageSteps.enter_Quote_Description("This is robot testing quote description");
        requestForQuotePageSteps.enter_Quote_Comment("This is robot testing quote comment");
        requestForQuotePageSteps.upload_File();
        requestForQuotePageSteps.click_Submit_Form_Button();
        requestForQuotePageSteps.check_That_Request_Is_Created_And_Cancel_It();

    }
}
