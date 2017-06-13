package com.gap.testmanagementtool.testlink;


import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.ReportTCResultResponse;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jcastro on 7/13/16.
 */
public class TestLinkAccess extends TestLinkAPI{

    public TestLinkAccess(String URL, String devKey) throws TestLinkAPIException, MalformedURLException {
        super(new URL(URL), devKey);
    }

    /**
     * This method create a new Testlink project
     * @param testProjectName Project name
     * @param testProjectPrefix Prefix (used for Test case ID)
     * @param notes Description of the project
     * @param enableRequirements Boolean to enable requirements
     * @param enableTestPriority Boolean to enable test priority
     * @param enableAutomation Boolean to enable Automation
     * @param enableInventory Boolean to enable inventory
     * @param isActive Active project
     * @param isPublic Public project
     * @return a TestProject object
     */
    public TestProject createTestlinkProject(String testProjectName, String testProjectPrefix, String notes, Boolean enableRequirements,
                                         Boolean enableTestPriority, Boolean enableAutomation, Boolean enableInventory, Boolean isActive,
                                         Boolean isPublic){

        return this.createTestProject(testProjectName, testProjectPrefix, notes, enableRequirements, enableTestPriority,
                                      enableAutomation, enableInventory, isActive, isPublic);
    }


    public ReportTCResultResponse setResult(int testCaseId, int testPlanId, int buildID, String notes, String status) throws TestLinkAPIException, MalformedURLException
    {
        return setTestCaseExecutionResult(testCaseId, null, testPlanId, ExecutionStatus.getExecutionStatus(status.charAt(0)), buildID, null, notes, true, null, null, null, null, false);
    }

    /*String url;
    String devKey;
    TestLinkAPI api;

    public TestLinkAccess(String url, String devKey){
        this.url = url;
        this.devKey = devKey;
        api = null;
    }

    public TestLinkAPI getTeslinkConnection(){
        URL testlinkURL = null;

        try {
            testlinkURL = new URL(url);
        } catch ( MalformedURLException mue ){
            mue.printStackTrace( System.err );
            System.exit(-1);
        }

        try{
            api = new TestLinkAPI(testlinkURL, devKey);
        } catch( TestLinkAPIException te) {
            te.printStackTrace( System.err );
            System.exit(-1);
        }

        System.out.println(api.ping());
        return api;
    }*/
}
