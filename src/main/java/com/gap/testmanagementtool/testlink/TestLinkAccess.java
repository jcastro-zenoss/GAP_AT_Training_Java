package com.gap.testmanagementtool.testlink;


import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.ReportTCResultResponse;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jcastro on 7/13/16.
 */
public class TestLinkAccess extends TestLinkAPI{

    public TestLinkAccess(String URL, String devKey) throws MalformedURLException {
        super(new URL(URL), devKey);
    }

    public ReportTCResultResponse setResult(int testCaseId, int testPlanId, int buildID, String notes, String status) throws TestLinkAPIException, MalformedURLException
    {
        return this.setTestCaseExecutionResult(testCaseId, null, testPlanId, ExecutionStatus.getExecutionStatus(status.charAt(0)), buildID, null, notes, true, null, null, null, null, false);
    }

}
