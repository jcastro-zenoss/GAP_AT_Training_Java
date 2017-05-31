package com.gap.at.testsuite;

import com.gap.at.testngdataprovider.GoogleDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by jcastro on 5/28/17.
 */
public class TestDataProvider {


    /*****************************************
     * Local Data Providers
     *****************************************/
    @DataProvider(name = "dpLocal")
    public Object[][] dataProviderMethod(Method m) {
        System.out.println(String.format("Data Provider name: %s", m.getName()));  // print test method name
        return new Object[][] {
                {1, true},
                {2, false},
        };987
    }

    /********************************************
     * Test cases that use local data providers
     ********************************************/
    @Test(groups = "test01", dataProvider = "dpLocal")
    public void test01(Integer inputNumber, Boolean expectedResult) {
        System.out.println(inputNumber + " " + expectedResult);
    }

    @Test(groups = "test02", dataProvider = "dpLocal")
    public void test02(Integer inputNumber, Boolean expectedResult) {
        System.out.println(inputNumber + " " + expectedResult);
    }

    /********************************************
     * Test cases that use data provider in other
     * class
     ********************************************/
    @Test(groups = "test03", dataProvider = "ddpOtherClass", dataProviderClass = GoogleDataProvider.class)
    public void test03(String name, String id) {
        System.out.println(String.format("%s: %s", name, id));
    }

    /********************************************
     * Test cases that use a data provider
     * that reads data from a excel file
     ********************************************/
    @Test(groups = "test04", dataProvider = "dataProviderXLS", dataProviderClass = GoogleDataProvider.class)
    public void test04(String name, String lastName) {
        System.out.println(String.format("%s %s", name, lastName));
    }

}
