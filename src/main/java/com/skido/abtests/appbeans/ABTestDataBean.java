package com.skido.abtests.appbeans;

import com.skido.abtests.entity.ABTestUser;
import com.skido.abtests.entity.ABTest;

public class ABTestDataBean {
    private Long testDataId;
    private ABTest abTest;

    private ABTestUser abTestUser;
    private Integer sampleGroupType;
    private boolean converted;

    public Long getTestDataId() {
        return testDataId;
    }

    public void setTestDataId(Long testDataId) {
        this.testDataId = testDataId;
    }

    public ABTest getAbTest() {
        return abTest;
    }

    public void setAbTest(ABTest abTest) {
        this.abTest = abTest;
    }

    public ABTestUser getAbTestUser() {
        return abTestUser;
    }

    public void setAbTestUser(ABTestUser abTestUser) {
        this.abTestUser = abTestUser;
    }

    public Integer getSampleGroupType() {
        return sampleGroupType;
    }

    public void setSampleGroupType(Integer sampleGroupType) {
        this.sampleGroupType = sampleGroupType;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

}
