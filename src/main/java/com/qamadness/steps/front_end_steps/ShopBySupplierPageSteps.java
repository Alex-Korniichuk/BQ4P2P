package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.ShopBySupplierPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 08.10.15.
 */
public class ShopBySupplierPageSteps extends ScenarioSteps {

    ShopBySupplierPage shopBySupplierPage;

    @Step
    public void open_Supplier_Page_With_Products(){
        shopBySupplierPage.openSupplierPageWithProducts();
    }

    @Step
    public void add_Products_To_Comparison(){
        shopBySupplierPage.addProductsToComparison();
    }

    @Step
    public void go_To_Comparison_Page(){
        shopBySupplierPage.goToComparisonPage();
    }

    @Step
    public void open_Product_Details_Page (){
        shopBySupplierPage.openProductDetailsPage();
    }
    @Step
    public String get_Product_Currency (){
        return shopBySupplierPage.getCurrency();
    }

    @Step
    public void add_Product_To_Cart (){ shopBySupplierPage.addProductToCart();}
}
