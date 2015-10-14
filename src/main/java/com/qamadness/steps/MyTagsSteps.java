package com.qamadness.steps;

import com.qamadness.pages.front_end.MyTagsPage;
import com.qamadness.pages.front_end.HomePage;
/**
 * Created by Vlad on 14.10.2015.
 */

public class MyTagsSteps {

    MyTagsPage myTagsPage;
    HomePage homePage;

public void clickTagBtn() {myTagsPage.clickProductTagBtn();}

    public void addTagName() {myTagsPage.fillNameField();}

    public void addTagField() {myTagsPage.addTagField();}

    public void addTagButn() {myTagsPage.addProductTagBtn();}

    public void clickMyAcc() {myTagsPage.clickMyAccLink();}

    public void clickMyTagsLink() {myTagsPage.clickMyTagsLink();}

    public void check_Tag_Page() {
        Boolean status = myTagsPage.checkOurTag();
        if (status == true) {
            myTagsPage.clickTag();
        }
    }

    public void loggOut() {myTagsPage.loggOut();}

}
