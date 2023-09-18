package com.skido.abtests.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Setter
@Table(name = "ab_test_data")
public class ABTestData {
    @Id
    @SequenceGenerator(name = "robin", sequenceName = "abtestdataseq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "robin")
    @Column(name = "ab_test_data_id", updatable = false, nullable = false)
    private Long testDataId;
    @OneToOne
    @JoinColumn(name = "ab_test_id")
    private ABTest abTest;
    @OneToOne
    @JoinColumn(name = "ab_test_user_id")
    private ABTestUser abTestUser;
    private boolean converted;
    @NotNull
    @Column(name = "sample_group_type", nullable = false)
    private Integer sampleGroupType;

    public ABTestData() {

    }
    public ABTestData(ABTest test, ABTestUser user) {
        this.abTest=test;
        this.abTestUser=user;
    }
}
