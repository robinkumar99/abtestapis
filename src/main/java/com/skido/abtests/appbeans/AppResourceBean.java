package com.skido.abtests.appbeans;


import com.skido.abtests.entity.ABTestData;
import com.skido.abtests.entity.AppResource;

public class AppResourceBean {
    private Long id;
    private String appId;
    private String url;
    private boolean ABTestActive;
    private Long currentAbtestDataId;
    private ABTestData currentTestData;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isABTestActive() {
        return ABTestActive;
    }

    public void setABTestActive(boolean ABTestActive) {
        this.ABTestActive = ABTestActive;
    }

    public Long getCurrentAbtestDataId() {
        return currentAbtestDataId;
    }

    public void setCurrentAbtestDataId(Long currentAbtestDataId) {
        this.currentAbtestDataId = currentAbtestDataId;
    }

    public ABTestData getCurrentTestData() {
        return currentTestData;
    }

    public void setCurrentTestData(ABTestData currentTestData) {
        this.currentTestData = currentTestData;
        this.currentAbtestDataId = currentTestData.getTestDataId();
    }

    public void setAppResource(AppResource appResource) {
        this.id=appResource.getId();
        this.appId=appResource.getAppId();
        this.url=appResource.getFileURL();
        this.ABTestActive=appResource.isABTestActive();
    }
}
