CREATE database outbox;
\c outbox
CREATE SCHEMA outbox;

CREATE USER outbox_application;
ALTER USER outbox_application WITH ENCRYPTED PASSWORD 'outbox_application_password';
ALTER USER outbox_application SET search_path = outbox;
GRANT ALL ON SCHEMA outbox TO outbox_application;
