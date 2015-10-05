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

public class CompareProductsSteps extends ScenarioSteps {

    HomePage homePage;
    ShopBySupplierPage shopBySupplierPage;
    ShoppingCartPage shoppingCartPage;
    CompareProductsPage compareProductsPage;

    @Step
    public void click_Main_Menu_Btn(){
        homePage.clickMainMenuBtn();
    }

    @Step
    public void click_Shop_By_Supplier_Link(){
        homePage.clickShopBySupplierLink();
    }

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
    public void add_Product_To_Cart (){
        compareProductsPage.addProductToCart();
    }

    @Step
    public void open_Shopping_Cart(){
        compareProductsPage.openShoppingCart();
    }

    @Step
    public void check_Is_Product_In_The_Cart(){
        Boolean status = shoppingCartPage.checkIsProductInTheCart();
        if (status == true){
            shoppingCartPage.removeProducts();
        }
    }

    @Step
    public void remove_All_Products_From_Comparison (){
        compareProductsPage.removeCompareProducts();
    }
}
