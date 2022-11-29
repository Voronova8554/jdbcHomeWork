package com.library.stepDef;

import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.module.Configuration;

public class Hooks {
    @Before
    public void  setupScenario(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After
    public  void  teardownScenario(Scenario scenario){

        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());

        }

        Driver.closeDriver();

    }


    @Before("@db")
    public void setupDB(){
        DB_Util.createConnection();
        System.out.println("connecting to database.....");
    }

    @After("@db")
    public void destroyDB(){
        DB_Util.destroy();
        System.out.println("closing connection....");
    }
}
