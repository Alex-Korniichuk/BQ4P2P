package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 08.10.15.
 */
public class HomePageSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void click_Main_Menu_Btn(){
        homePage.clickMainMenuBtn();
    }

    @Step
    public void click_Shop_By_Supplier_Link(){
        homePage.clickShopBySupplierLink();
    }

    @Step
    public void check_Is_User_Logged_In(){
        homePage.checkIsUserLoggedIn();
    }

    @Step
    public void open_My_Order_Templates_Page (){
        homePage.clickOrderTemplatesLink();
    }

    @Step
    public void expand_Product_And_Services_Tab (){
        homePage.expandProductsAndServicesTab();
    }

    @Step
    public void click_Quick_Order_Link (){
        homePage.clickQuickOrderLink();
    }

    @Step
    public void open_Shopping_Cart(){
        homePage.openShoppingCart();
    }

    @Step
    public void expand_My_Account_Tab (){
        homePage.expandMyAccountTab();
    }

    @Step
    public void open_Profile_Information_Page (){
        homePage.clickProfileInfoLink();
    }

    @Step
    public void logout (){
        homePage.clickLogoutLink();
    }

    @Step
    public void open_Collaborative_Carts_Page (){
        homePage.clickCollaborativeCartsLink();
    }

    @Step
    public void  open_My_Reviews_Page (){
        homePage.clickMyReviewsLink();
    }

    @Step
    public void open_My_Tags_Page (){homePage.clickMyTagsLink();}
}
