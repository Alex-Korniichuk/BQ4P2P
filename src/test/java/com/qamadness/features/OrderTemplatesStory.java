package com.qamadness.features;

import com.qamadness.steps.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by alexandrakorniichuk on 07.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class OrderTemplatesStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public OrderTemplatePageSteps orderTemplatePageSteps;

    @Steps
    public ProductDetailsPageSteps productDetailsPageSteps;

    @Steps
    public ShoppingCartPageSteps shoppingCartPageSteps;

    @Steps
    public CheckoutPageSteps checkoutPageSteps;

    @Before
    public void login_to_site (){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
    }

    @Issue("AUT-39")

    @Test
    public void create_new_template_and_remove_it(){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.open_My_Order_Templates_Page();
        orderTemplatePageSteps.create_New_Order_Template();
        orderTemplatePageSteps.delete_Order_Template();
    }

    @Test
    public void add_a_product_to_order_template(){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_Product_And_Services_Tab();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.open_Supplier_Page_With_Products();
        shopBySupplierPageSteps.open_Product_Details_Page();
        productDetailsPageSteps.add_Product_To_Order_Template();
        String expectedProductName = productDetailsPageSteps.get_Expected_Product_Name();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.open_My_Order_Templates_Page();
        orderTemplatePageSteps.check_That_Correct_Product_Is_Added_To_Template(expectedProductName);
        orderTemplatePageSteps.add_Product_To_Cart();
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_That_Correct_Product_In_The_Cart(expectedProductName);
        shoppingCartPageSteps.clear_Cart();
        shoppingCartPageSteps.go_To_Previous_Page();
        orderTemplatePageSteps.remove_Product_From_Order_Template();
    }

    @Issue("AUT-53")
    @Test
    public void create_order_template_from_recent_order (){
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
        checkoutPageSteps.create_New_Order_Template();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_My_Account_Tab();
        homePageSteps.open_My_Order_Templates_Page();
        orderTemplatePageSteps.open_Order_Template_Page();
        orderTemplatePageSteps.delete_Order_Template();
    }

    @After
    public void steps_after_test (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
    }
}
