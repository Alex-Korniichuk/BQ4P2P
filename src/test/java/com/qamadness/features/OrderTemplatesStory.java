package com.qamadness.features;

import com.qamadness.steps.*;
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

    @Issue("AUT-39")

    @Pending @Test
    public void create_new_template_and_remove_it(){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.open_My_Order_Templates_Page();
        orderTemplatePageSteps.create_New_Order_Template();
        orderTemplatePageSteps.delete_Order_Template();
    }

    @Pending @Test
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




}
