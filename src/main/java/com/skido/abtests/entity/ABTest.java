package com.skido.abtests.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ab_test")
public class ABTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ab_test_id", nullable = false)
    private  Long testId;
    private int appID;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "app_resource_id", nullable = false)
    private AppResource appResource;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "abtest_resource_id", nullable = false)
    private ABTestResource abTestResource;
    private String testMethod;
    private String hypothesis;
    private String changeType;
    private int sampleSize;
    private double sampleDistribution;
    private boolean isActive;
    private boolean isCompleted;
    private long completeCount;
    private double significanceValue;
    private boolean isConcluded;
    private String conclusionReason;
    private Date createdDate;
    private Date updatedDate;
    private Date completedDate;

    @OneToMany(mappedBy = "abTest")
    private Set<ABTestUser> abTestUsers = new LinkedHashSet<>();

}