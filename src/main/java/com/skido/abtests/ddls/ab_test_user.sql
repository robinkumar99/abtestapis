CREATE TABLE ab_test_user
(
    ab_test_user_id   BIGINT       NOT NULL,
    ab_test_id        BIGINT       NULL,
    reference_user_id BIGINT       NOT NULL,
    is_control_group  BIT(1)       NOT NULL,
    user_properties   VARCHAR(255) NULL,
    CONSTRAINT pk_ab_test_user PRIMARY KEY (ab_test_user_id)
);

ALTER TABLE ab_test_user
    ADD CONSTRAINT FK_AB_TEST_USER_ON_AB_TEST FOREIGN KEY (ab_test_id) REFERENCES ab_test (ab_test_id);