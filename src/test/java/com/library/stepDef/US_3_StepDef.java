package com.library.stepDef;

import com.library.pages.BookPage;
import com.library.pages.DashboardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US_3_StepDef extends DashboardPage{


    BookPage bookPage=new BookPage();
    List<String> actualCategoryList;

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
        DashboardPage.navigateModule(moduleName);
    }

    @When("the user gets all book categories in webpage")
    public void the_user_gets_all_book_categories_in_webpage() {

        actualCategoryList=BrowserUtils.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);
    }
    @Then("user should be able to see following categories")
    public void user_should_be_able_to_see_following_categories(List<String> expectedCategoryList) {

        Assert.assertEquals(expectedCategoryList, actualCategoryList);
    }
}