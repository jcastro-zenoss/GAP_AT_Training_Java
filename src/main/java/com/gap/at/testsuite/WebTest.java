package com.gap.at.testsuite;

import org.testng.annotations.Test;

/**
 * Created by jcastro on 5/28/17.
 */
public class WebTest {

    private int m_numOfTimes;

    public WebTest(int numberOfTimes) {
        m_numOfTimes = numberOfTimes;
    }

    @Test
    public void testServer() {
        System.out.println(String.format("Web Page access #: %d", m_numOfTimes));
    }

}
