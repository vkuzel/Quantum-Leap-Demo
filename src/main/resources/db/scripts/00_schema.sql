CREATE SCHEMA quantum_leap_demo;

CREATE TABLE quantum_leap_demo.example (
    id           BIGSERIAL PRIMARY KEY,
    text_field   VARCHAR   NOT NULL,
    enum_field   VARCHAR   NOT NULL,
    set_field    VARCHAR[] NOT NULL,
    lookup_field BIGINT    NOT NULL REFERENCES core.person,
    json_field   JSON      NOT NULL DEFAULT '{}'
);
