package com.qamadness.pages.front_end;

import net.thucydides.core.pages.PageObject;

/**
 * Created by alexandrakorniichuk on 02.10.15.
 */

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ShopBySupplierPage extends PageObject {

    @FindBy(id = "supplierList")
    WebElementFacade suppliersList;

    @FindBy (xpath = "//div[@id='product-listing-container']/div[1]/div/div[@class='product-name name-container']/a")
    WebElementFacade productName;

    @FindBy (xpath = "//div[@class='product-price']/span/span")
    WebElementFacade productPrice;

    @FindBy(css = "#bq-ui-1")
    WebElementFacade addToCartBtn;

    public ShopBySupplierPage(){
    }

    public void openSupplierPageWithProducts (){
        setImplicitTimeout(60, TimeUnit.SECONDS);
        int suppliersQty = getDriver().findElements(By.xpath("//ul[@id='supplierList']/li")).size();
        for (int i=1; i<=suppliersQty; i++){
            waitForRenderedElementsToBePresent(By.xpath("//ul[@id='supplierList']/li[" + i + "]/div/div/a"));
            getDriver().findElement(By.xpath("//ul[@id='supplierList']/li["+i+"]/div/div/a")).click();
            if(getDriver().findElements(By.xpath("//div[@class='product-item']")).size()>2){
                System.out.print("Category has products");
                break;
            }else{
                getDriver().navigate().back();
            }
        }
    }

    public void addProductsToComparison(){
        setImplicitTimeout(50, TimeUnit.SECONDS);
        for (int i=1; i<=2; i++){
            waitForRenderedElementsToBePresent(By.xpath("//*[@id='product-listing-container']/div["+i+"]/div/div[2]/div[1]/div/a"));
            waitForRenderedElementsToBePresent(By.xpath("//*[@id='product-listing-container']/div[" + i + "]/div/div[2]/div[1]/div/a"));
            WebElement compareLink = getDriver().findElement(By.xpath("//*[@id='product-listing-container']/div["+i+"]/div/div[2]/div[1]/div/a"));
            compareLink.click();
        }
    }

    public void goToComparisonPage (){
        setImplicitTimeout(60, TimeUnit.SECONDS);
        waitForRenderedElementsToBePresent(By.cssSelector(".compare-link-action")).withTimeoutOf(60, TimeUnit.SECONDS);
        WebElement linkToComparePage = getDriver().findElement(By.cssSelector(".compare-link-action"));
        linkToComparePage.click();
    }

    public void openProductDetailsPage(){
        productName.click();
    }


    public String getCurrency (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-price']/span/span")));
        String price = productPrice.getText();
        String currency = price.substring(0,1);
        System.out.print("Currency is: "+currency);
        return currency;
    }

    public void addProductToCart (){
        addToCartBtn.click();
    }



}

