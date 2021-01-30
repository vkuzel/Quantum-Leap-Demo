INSERT INTO core.table_preferences (entity_identifier, is_default, enabled_columns)
VALUES
('quantum_leap_demo.example', TRUE, ARRAY ['id', 'text_field', 'enum_field', 'set_field', 'lookup_field']);

INSERT INTO core.enum (id, name)
VALUES
('EXAMPLE_ENUM', 'Example enum');

INSERT INTO core.enum_value (enum_id, id, label)
VALUES
('EXAMPLE_ENUM', 'VALUE1', 'Value 1'),
('EXAMPLE_ENUM', 'VALUE2', 'Value 2'),
('EXAMPLE_ENUM', 'VALUE3', 'Value 3'),
('EXAMPLE_ENUM', 'VALUE4', 'Value 4');
