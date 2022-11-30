CREATE TABLE controllers
(
    id         BIGSERIAL PRIMARY KEY,
    short_name VARCHAR(10) NOT NULL,
    full_name  VARCHAR(80),
    address    SMALLINT NOT NULL,
    ip_address VARCHAR(15),
    segment_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    protocol VARCHAR(20) NOT NULL
);