CREATE TABLE plc_event_journal(
    id       BIGSERIAL PRIMARY KEY,
    time    timestamptz not null,
    plc_id  BIGSERIAL not null,
    value   bytea not null,
    description VARCHAR(100)
)