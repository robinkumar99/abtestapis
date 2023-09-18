CREATE TABLE ab_test_data
(
    ab_test_data_id BIGINT NOT NULL,
    ab_test_id      BIGINT NULL,
    ab_test_user_id BIGINT NULL,
    converted       BIT(1) NOT NULL,
    CONSTRAINT pk_ab_test_data PRIMARY KEY (ab_test_data_id)
);

ALTER TABLE ab_test_data
    ADD CONSTRAINT FK_AB_TEST_DATA_ON_AB_TEST FOREIGN KEY (ab_test_id) REFERENCES ab_test (ab_test_id);

ALTER TABLE ab_test_data
    ADD CONSTRAINT FK_AB_TEST_DATA_ON_AB_TEST_USER FOREIGN KEY (ab_test_user_id) REFERENCES ab_test_user (ab_test_user_id);