package com.skido.abtests.api;

import com.skido.abtests.context.CrudOperations;
import com.skido.abtests.entity.*;
import com.skido.abtests.appbeans.AppResourceBean;

public class ABTestServiceImpl implements ABTestService{

    @Override
    public void createABTest(AppResourceBean appResource) {

    }

    @Override
    public void updateABTestData(AppResourceBean appResBean) {
        CrudOperations crudOps= new CrudOperations();
        ABTestData currentTestData= appResBean.getCurrentTestData();
        assert currentTestData != null;
        crudOps.updateTesData(currentTestData);
        ABTestUser currentUser = currentTestData.getAbTestUser();
        assert currentUser != null;
        crudOps.updateABTestUser(currentUser);


    }

    /**
     *
     * @param ResourceId: Key of the App Resource on which test is being performed
     * @param currentUserId: Not null when user is a registered user and system can detect it
     * @return
     */
    @Override
    public AppResourceBean createABTestData(String ResourceId, String currentUserId) {
        AppResourceBean appResBean= new AppResourceBean();
        CrudOperations crudOperations= new CrudOperations();
        AppResource appResource= crudOperations.getAppResource(ResourceId);
        appResBean.setAppResource(appResource);
        if(appResource.isABTestActive()) {
            ABTest abtestCurrent = crudOperations.findTest(appResource.getABTestId());
            //Count of data in experiment sample group
            long count = crudOperations.getCountofExperimentalData(abtestCurrent);
            ABTestResource resource= abtestCurrent.getAbTestResource();
            if (count < abtestCurrent.getCompleteCount()) {
                //Create/Update Test Data User
                ABTestUser user=new ABTestUser(abtestCurrent,currentUserId,"NewFromDehradun");
                user= crudOperations.getUserByReferenceId(user);
                //Create TestData
                ABTestData testData = new ABTestData(abtestCurrent, user);
                //Set Sample Group Type Control/Experiment (0/1)
                testData.setSampleGroupType((Math.random() * 100 <= abtestCurrent.getSampleDistribution())?1:0);
                testData.setTestDataId(crudOperations.getABTestDatID());
                // Save TestData
                crudOperations.insertTesData(testData);
                appResBean.setCurrentTestData(testData);
            }
            double experimentalGroupSize=(abtestCurrent.getSampleDistribution()* abtestCurrent.getSampleSize())/100;
            count++;
            if(count == experimentalGroupSize){
                abtestCurrent.setActive(false);
                crudOperations.updateTest(abtestCurrent);
            }
        }
        return appResBean;
    }
}
