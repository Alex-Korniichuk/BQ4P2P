package com.qamadness.steps;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */
import com.qamadness.pages.front_end.HomePage;
import com.qamadness.pages.front_end.ShopBySupplierPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.qamadness.pages.front_end.ShoppingCartPage;
import com.qamadness.pages.front_end.CompareProductsPage;

public class CompareProductsPageSteps extends ScenarioSteps {

    CompareProductsPage compareProductsPage;
    HomePage homePage;

    @Step
    public void add_Product_To_Cart (){
        compareProductsPage.addProductToCart();
    }

    @Step
    public void remove_All_Products_From_Comparison (){
        compareProductsPage.removeCompareProducts();
    }
}
