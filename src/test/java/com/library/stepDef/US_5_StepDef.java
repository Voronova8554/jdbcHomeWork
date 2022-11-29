package com.library.stepDef;

import com.library.pages.LoginPage;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_5_StepDef {

    String countOfBooksCategories = "";
    LoginPage loginPage = new LoginPage();

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

      loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
      DB_Util.createConnection();

    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {

        countOfBooksCategories = "select bc.name,count(*) from book_borrow bb\n" +
                "        inner  join books b on bb.book_id = b.id\n" +
                "        inner join book_categories bc on b.book_category_id=bc.id\n" +
                "        group by name\n" +
                "        order by 2 desc;";
        DB_Util.runQuery(countOfBooksCategories);


    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expected) {

        String actual = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        System.out.println(expected);
    }

}
