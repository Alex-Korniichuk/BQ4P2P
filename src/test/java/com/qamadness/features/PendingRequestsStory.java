package com.qamadness.features;

<<<<<<< HEAD
import com.qamadness.steps.*;
=======
import com.qamadness.steps.front_end_steps.*;
>>>>>>> pr/2
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Managed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;

/**
 * Created by alexandrakorniichuk on 19.10.15.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class PendingRequestsStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Steps
    public ShoppingCartPageSteps shoppingCartPageSteps;

    @Steps
    public CheckoutPageSteps checkoutPageSteps;

    @Steps
    public PendingRequestsPageSteps pendingRequestsPageSteps;

    @Steps
    public PendingRequestDetailsPageSteps pendingRequestDetailsPageSteps;

    @Steps
    public ArchivedRequestsPageSteps archivedRequestsPageSteps;

    @Before
    public void loginToSite(){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
    }

    @Issue("AUT-54")
    @Test
    public void check_that_request_is_added_to_pending_requests_after_purchase (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.add_Product_To_Cart();
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
        shoppingCartPageSteps.click_Proceed_To_Checkout_Button();
        checkoutPageSteps.enter_Order_Title("Test Order Title");
        checkoutPageSteps.enter_Reason_To_Buy("Test Reason To Buy");
        checkoutPageSteps.continue_To_Shipping_And_Accounting();
        checkoutPageSteps.wait_Till_Shipping_Step_Is_Uploaded();
        checkoutPageSteps.select_Shipping_Address();
        checkoutPageSteps.continue_To_Approval_Chain();
        checkoutPageSteps.wait_Till_Approval_Chain_Step_Is_Uploaded();
        checkoutPageSteps.continue_To_Review();
        checkoutPageSteps.wait_Till_Review_Step_Is_Uploaded();
        checkoutPageSteps.submit_Order();
        checkoutPageSteps.wait_Till_Success_Page_Is_Uploaded();
        String expectedRequestID = checkoutPageSteps.get_Request_ID();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Documents_Tab();
        homePageSteps.expand_Requests_Tab();
        homePageSteps.open_Pending_Requests_Page();
        pendingRequestsPageSteps.search_Request_By_ID(expectedRequestID);
        pendingRequestsPageSteps.check_Search_Results(expectedRequestID);
    }

    @Test
    public void withdraw_Pending_Request (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.add_Product_To_Cart();
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
        shoppingCartPageSteps.click_Proceed_To_Checkout_Button();
        checkoutPageSteps.enter_Order_Title("Test Order Title");
        checkoutPageSteps.enter_Reason_To_Buy("Test Reason To Buy");
        checkoutPageSteps.continue_To_Shipping_And_Accounting();
        checkoutPageSteps.wait_Till_Shipping_Step_Is_Uploaded();
        checkoutPageSteps.select_Shipping_Address();
        checkoutPageSteps.continue_To_Approval_Chain();
        checkoutPageSteps.wait_Till_Approval_Chain_Step_Is_Uploaded();
        checkoutPageSteps.continue_To_Review();
        checkoutPageSteps.wait_Till_Review_Step_Is_Uploaded();
        checkoutPageSteps.submit_Order();
        checkoutPageSteps.wait_Till_Success_Page_Is_Uploaded();
        String expectedRequestID = checkoutPageSteps.get_Request_ID();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Documents_Tab();
        homePageSteps.expand_Requests_Tab();
        homePageSteps.open_Pending_Requests_Page();
        pendingRequestsPageSteps.search_Request_By_ID(expectedRequestID);
        pendingRequestsPageSteps.check_Search_Results(expectedRequestID);
        pendingRequestsPageSteps.open_Request_Details_Page();
        pendingRequestDetailsPageSteps.withdraw_Pending_Request();
        archivedRequestsPageSteps.search_Request_By_ID(expectedRequestID);
        archivedRequestsPageSteps.check_Search_Results(expectedRequestID);

    }

    @After
    public void logout () {
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
    }
}
