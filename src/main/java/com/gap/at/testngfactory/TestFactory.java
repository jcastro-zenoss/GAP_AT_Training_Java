package com.gap.at.testngfactory;

import com.gap.at.testsuite.WebTest;
import org.testng.annotations.Factory;

/**
 * Created by jcastro on 5/28/17.
 */
public class TestFactory {

    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[10];

        for (int i = 0; i < 10; i++) {
            result[i] = new WebTest(i);
        }
        return result;
    }

}
