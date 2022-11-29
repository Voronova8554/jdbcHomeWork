package com.library.stepDef;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US_1_StepDef {
int totalIdNums;
int totalUniqueIdNums;
    List<String> actualAllColumnName;
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("select id from users;");
     totalIdNums =   DB_Util.getRowCount();
        System.out.println(totalIdNums);
    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        DB_Util.runQuery("select distinct id from users;");
        totalUniqueIdNums = DB_Util.getRowCount();


        Assert.assertEquals("Not all User have unique ID!",totalUniqueIdNums,totalIdNums);

    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
       DB_Util.runQuery("select * from users;");
       actualAllColumnName =  DB_Util.getAllColumnNamesAsList();
        System.out.println(actualAllColumnName);

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> ExpectedAllColumnName) {

        Assert.assertEquals("Failed!",ExpectedAllColumnName,actualAllColumnName);



    }
}
