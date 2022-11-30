CREATE TABLE commands
(
    id           BIGSERIAL PRIMARY KEY,
    description  VARCHAR(100) NOT NULL,
    short_name   VARCHAR(25)  NOT NULL,
    address      INTEGER      NOT NULL,
    byte_count   INTEGER      NOT NULL,
    command_type VARCHAR(20)  NOT NULL,
    store        BOOLEAN default false,
    error_value  INTEGER,
    profile_id   BIGINT       NOT NULL
)