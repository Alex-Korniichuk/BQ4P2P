package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by alexandrakorniichuk on 07.10.15.
 */
public class OrderTemplatePageSteps extends ScenarioSteps {

    MyOrderTemplatesPage orderTemplatesPage;


    @Step
    public void create_New_Order_Template (){
        orderTemplatesPage.expandOrderTemplate();
        orderTemplatesPage.createNewOrderTemplateName();
    }

    @Step
    public void open_Order_Template_Page (){
        orderTemplatesPage.openOrderTemplatePage();
    }

    @Step
    public void delete_Order_Template (){
        orderTemplatesPage.deleteOrderTemplate();
    }

    @Step
    public void check_That_Correct_Product_Is_Added_To_Template (String expectedProductName){
        //String expectedProductName = productDetailsPage.getProductName();
        System.out.println("Expected Product name: " + expectedProductName);
        String actualProductName = orderTemplatesPage.getProductTitle();
        System.out.println("Actual product name: " + actualProductName);
        if (expectedProductName.equalsIgnoreCase(actualProductName) == true){
            System.out.println ("Correct product was added to template");
        }else{
            Assert.fail("Incorrect prouct was added: "+actualProductName+" correct product is: "+expectedProductName);
        }
    }

    @Step
    public void add_Product_To_Cart (){
        orderTemplatesPage.clickAddToCartBtn();
    }

    @Step
    public void remove_Product_From_Order_Template(){
        orderTemplatesPage.removeProduct();
    }


}
