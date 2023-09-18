CREATE TABLE app_resource
(
    resource_id            BIGINT       NOT NULL,
    url                    VARCHAR(255) NULL,
    abtest_active          BIT(1)       NOT NULL,
    current_abtest_data_id BIGINT       NULL,
    CONSTRAINT pk_app_resource PRIMARY KEY (resource_id)
);