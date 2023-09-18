package com.skido.abtests.context;

import com.skido.abtests.entity.ABTest;
import com.skido.abtests.entity.ABTestData;
import com.skido.abtests.entity.ABTestUser;
import com.skido.abtests.entity.AppResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Date;
import java.util.ArrayList;


/**
 *  JPA CRUD Operations
 * @author Ramesh Fadatare
 *
 */
public class CrudOperations {
    public void insertTesData(ABTestData data) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(data);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Long getABTestDatID() {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Long testdataid=Long.parseLong(entityManager
                .createNativeQuery("select Auto_increment from information_schema.tables where table_name='"+"ab_test_data'")
                .getSingleResult().toString());
        entityManager.getTransaction().commit();
        entityManager.close();
        return testdataid;
    }
    public ABTestData findTestData(long id) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ABTestData test = entityManager.find(ABTestData.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return test;
    }

    public ABTest findTest(long id) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ABTest test = entityManager.find(ABTest.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return test;
    }

    public void updateTesData(ABTestData testData) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        ABTestData data = entityManager.find(ABTestData.class, testData.getTestDataId());
        // The entity object is physically updated in the database when the transaction
        // is committed
        data.setConverted(true);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeTestData(long id) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ABTestData student = entityManager.find(ABTestData.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * @param testid
     * @return list of ABTestData
     */
    public ArrayList<ABTestData> getTestDataListForTest(long testid){
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ArrayList<ABTestData> testDataList = (ArrayList<ABTestData>) entityManager.createNamedQuery(new StringBuffer("Select * from ab_test_data where ab_test_id=").append(testid).toString()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return testDataList;
    }

    public ArrayList<ABTest> getActiveTests(){
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ArrayList<ABTest> testList = (ArrayList<ABTest>) entityManager.createNamedQuery(new StringBuffer("Select * from ab_test where is_active=").append("Y").toString()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return testList;
    }

    public long getCountofExperimentalData(ABTest abtestCurrent) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        long  count =(long) entityManager.createNamedQuery(new StringBuffer("Select Sum(sample_group_type) from ab_test_data where ab_test_id=").append(abtestCurrent.getTestId()).toString()).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return count;
    }

    public AppResource getAppResource(String resourceId) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        AppResource appResource = entityManager.find(AppResource.class, resourceId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return appResource;
    }

    public void updateTest(ABTest abtestCurrent) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ABTest test=entityManager.find(ABTest.class,abtestCurrent.getTestId());
        if(!abtestCurrent.isActive()){
            test.setActive(false);
            test.setCompleted(true);
            test.setCompletedDate(new Date(System.currentTimeMillis()));
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateABTestUser(ABTestUser currentUser) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        ABTestUser user = entityManager.find(ABTestUser.class, currentUser.getId());
        user.setReferenceUserId(currentUser.getReferenceUserId());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public ABTestUser getUserByReferenceId(ABTestUser currentUser) {
        EntityManager entityManager = ABTestJPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        String testUserId = (String)entityManager.createNativeQuery("Select ab_test_user_id from ab_test_user where reference_user_id = "+currentUser.getReferenceUserId(), String.class).getSingleResult();
        if(testUserId != null && !testUserId.isEmpty()){
            currentUser.setId(Long.parseLong(testUserId));
        }else{
            entityManager.persist(currentUser);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return currentUser;
    }
}