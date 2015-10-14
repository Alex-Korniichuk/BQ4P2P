package com.qamadness.steps;

import com.qamadness.pages.front_end.MyTagsPage;
import com.qamadness.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by Vlad on 14.10.2015.
 */

public class MyTagsSteps extends ScenarioSteps {

    MyTagsPage myTagsPage;

    @Step
    public void click_appropriate_Tag (){
        myTagsPage.clickTag();
    }

    @Step
    public void check_Tag_On_My_Tags_Page() {myTagsPage.checkOurTag();}

}
