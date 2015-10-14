package com.qamadness.pages.front_end;

import net.thucydides.core.pages.PageObject;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CompareProductsPage extends PageObject {

    @FindBy(xpath = "//button[@id='bq-ui-1']")
    WebElementFacade addToCartBtn;

    @FindBy(xpath = "//div[@class='compare-product-buttons']/a")
    public List<WebElementFacade> allProducts;

    public CompareProductsPage() {
    }

    public void addProductToCart (){
        addToCartBtn.click();
    }

    public void removeCompareProducts (){
        int productsQty = allProducts.size();
        for (int i=1; i<=productsQty; i++){
            waitForRenderedElementsToBePresent(By.xpath("//th[@class='product'][1]/div/div[1]/div/a"));
            getDriver().findElement(By.xpath("//th[@class='product'][1]/div/div[1]/div/a")).click();
        }
    }

}
