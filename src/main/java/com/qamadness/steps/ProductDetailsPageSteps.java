package com.qamadness.steps;

import com.qamadness.pages.front_end.ProductDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 08.10.15.
 */
public class ProductDetailsPageSteps extends ScenarioSteps {

    ProductDetailsPage productDetailsPage;

    @Step
    public void add_Product_To_Order_Template (){
        productDetailsPage.openOrderTemplateDropDown();
        productDetailsPage.addProductToTemplate();
    }
    @Step
    public String get_Expected_Product_Name (){
        return productDetailsPage.getProductName();
    }

}
