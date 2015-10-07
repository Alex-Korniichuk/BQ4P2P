package com.qamadness.steps;

import com.qamadness.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.qamadness.pages.front_end.MyOrderTemplatesPage;

/**
 * Created by alexandrakorniichuk on 07.10.15.
 */
public class OrderTemplateSteps extends ScenarioSteps {

    MyOrderTemplatesPage orderTemplatesPage;
    HomePage homePage;

    @Step
    public void open_My_Order_Templates_Page (){
        homePage.clickOrderTemplatesLink();
    }

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
}
