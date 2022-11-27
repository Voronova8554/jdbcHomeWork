package com.library.stepDef;

import com.library.pages.DashboardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtils;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_2_StepDef  extends  DashboardPage{

    LoginPage loginPage = new LoginPage();
  String actualBarrowedBookNumber;

  String DBurl = "jdbc:mysql://34.230.35.214:3306/library2";
  String DBusername = "library2_client";
    String DBpasscode = "6s2LQQTjBcGFfDhY";


    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(5);
    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
      actualBarrowedBookNumber = borrowedBooksNum.getText();
        //System.out.println(actualBarrowedBookNumber);
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.createConnection(DBurl,DBusername,DBpasscode);
    DB_Util.runQuery("select count(*) as borrowedBooks from users u inner join book_borrow b on u.id = b.user_id where is_returned = 0;");

    String expected = DB_Util.getFirstRowFirstColumn();

    //System.out.println(expected);

        Assert.assertEquals("Failed! ",expected,actualBarrowedBookNumber);
    }

}
