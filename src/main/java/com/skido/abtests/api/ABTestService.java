package com.skido.abtests.api;

import com.skido.abtests.appbeans.AppResourceBean;

public interface ABTestService {

    public abstract void createABTest(AppResourceBean abTestData);
    public abstract void updateABTestData(AppResourceBean abTestData);
    public abstract AppResourceBean createABTestData(String resourceId, String currentUserId);
}
