CREATE TABLE ab_test_resource
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    resource_id         BIGINT                NOT NULL,
    resourceurl         VARCHAR(255)          NULL,
    new_resourceurl     VARCHAR(255)          NULL,
    parent_resourceid   BIGINT                NOT NULL,
    testid              BIGINT                NOT NULL,
    ab_test_resource_id BIGINT                NULL,
    CONSTRAINT pk_ab_test_resource PRIMARY KEY (id)
);

ALTER TABLE ab_test_resource
    ADD CONSTRAINT FK_AB_TEST_RESOURCE_ON_AB_TEST_RESOURCE FOREIGN KEY (ab_test_resource_id) REFERENCES ab_test (ab_test_id);

ALTER TABLE ab_test_resource
    ADD CONSTRAINT FK_AB_TEST_RESOURCE_ON_RESOURCE FOREIGN KEY (resource_id) REFERENCES app_resource (resource_id);