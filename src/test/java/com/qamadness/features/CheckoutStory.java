package com.qamadness.features;

import com.qamadness.steps.*;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Managed;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;

/**
 * Created by alexandrakorniichuk on 15.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class CheckoutStory {

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

    @Before
    public void loginToSite(){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
    }

    @Issue("AUT-51")
    @Test
    public void add_attachment_on_general_information_page(){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.add_Product_To_Cart();
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
        shoppingCartPageSteps.click_Proceed_To_Checkout_Button();
        checkoutPageSteps.upload_File();
        checkoutPageSteps.check_That_File_Is_Uploaded();
        checkoutPageSteps.remove_File();
        shoppingCartPageSteps.go_To_Previous_Page();
        shoppingCartPageSteps.clear_Cart();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
    }

    @Issue("AUT-52")
    @Test
    public void add_approver_and_watcher_to_chain (){
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
        checkoutPageSteps.add_Watcher();
        checkoutPageSteps.check_That_Watcher_Is_Added();
        checkoutPageSteps.addApprover();
        checkoutPageSteps.check_That_Approver_Is_Added_To_Chain();
        shoppingCartPageSteps.go_To_Previous_Page();
        shoppingCartPageSteps.clear_Cart();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
    }
}
