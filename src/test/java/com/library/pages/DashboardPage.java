package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

  public  abstract class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
     }


     @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksNum;





}
