package com.skido.abtests.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ab_test_resource")
public class ABTestResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private AppResource resource;
    private String resourceURL;
    private String newResourceURL;

    private long parentResourceID;
    private long testID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ab_test_resource_id")
    private ABTest abTestResource;

    public void setId(long id) {
        this.id = id;
    }

    public void setResource(AppResource resourceID) {
        this.resource = resourceID;
    }

    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

    public void setNewResourceURL(String newResourceURL) {
        this.newResourceURL = newResourceURL;
    }

    public void setParentResourceID(long parentResourceID) {
        this.parentResourceID = parentResourceID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }
}
