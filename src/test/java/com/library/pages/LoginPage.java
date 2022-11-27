package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement usernameInput;

    @FindBy(id = "inputPassword")
    public WebElement userPasswordInput;

    @FindBy (xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement signInBtn;


    public void login(String username, String password){
        usernameInput.sendKeys(username);
        userPasswordInput.sendKeys(password);
        signInBtn.click();
    }

}
