CREATE TABLE ab_test
(
    ab_test_id           BIGINT       NOT NULL,
    appid                INT          NOT NULL,
    test_method          VARCHAR(255) NULL,
    hypothesis           VARCHAR(255) NULL,
    change_type          VARCHAR(255) NULL,
    sample_size          INT          NOT NULL,
    control_distribution INT          NOT NULL,
    is_active            BIT(1)       NOT NULL,
    is_completed         BIT(1)       NOT NULL,
    complete_count       BIGINT       NOT NULL,
    significance_value   DOUBLE       NOT NULL,
    is_concluded         BIT(1)       NOT NULL,
    conclusion_reason    VARCHAR(255) NULL,
    created_date         date         NULL,
    updated_date         date         NULL,
    completed_date       date         NULL,
    CONSTRAINT pk_ab_test PRIMARY KEY (ab_test_id)
);