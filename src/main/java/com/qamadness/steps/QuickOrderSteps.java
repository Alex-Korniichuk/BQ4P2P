package com.qamadness.steps;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */

import com.qamadness.pages.front_end.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class QuickOrderSteps extends ScenarioSteps{

    LoginPage loginPage;
    HomePage homePage;
    QuickOrderPage quickOrderPage;
    ShoppingCartPage shoppingCartPage;

    @Step
    public void click_Quick_Order_Link (){
        homePage.clickQuickOrderLink();
    }

    @Step
    public void upload_File (){
        quickOrderPage.uploadFile();
    }

    @Step
    public void check_Is_Product_In_The_Cart (){
        shoppingCartPage.checkIsProductInTheCart();
        shoppingCartPage.clearCart();
    }

}
