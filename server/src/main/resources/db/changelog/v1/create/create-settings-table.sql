CREATE TABLE settings
(
    id                BIGSERIAL PRIMARY KEY,
    organization_name VARCHAR(400) NOT NULL,
    created           timestamptz default now()
);