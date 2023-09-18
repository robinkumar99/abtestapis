package com.skido.abtests.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "app_resource")
public class AppResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id", nullable = false)
    private Long id;
    private String appId;
    private String fileURL;
    private boolean ABTestActive;
    private Long ABTestId;
}