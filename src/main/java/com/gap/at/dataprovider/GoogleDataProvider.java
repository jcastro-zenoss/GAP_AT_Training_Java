package com.gap.at.dataprovider;

import com.gap.at.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by jcastro on 5/28/17.
 */
public class GoogleDataProvider {

    /**
     * Data provider that returns a name with his id
     * @param m method that calls the DP
     * @return Object with a list of arrays: Name, ID
     */
    @DataProvider(name = "ddpOtherClass")
    public static Object[][] dataProviderMethod(Method m) {
        System.out.println(String.format("Data Provider name: %s", m.getName()));  // print test method name
        return new Object[][] {
                {"Ana Perez", "603458690"},
                {"Juan Castillo", "103058900"}
        };
    }

    @DataProvider(name = "dataProviderXLS")
    public static Object[][] dataProviderXLS() throws Exception {
        return ExcelUtils.getTableArray("src/main/resources/dataproviders/testXLS.xls", "sheet1");
    }

}
