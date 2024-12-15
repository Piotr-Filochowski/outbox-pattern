-- Drop the current primary key constraint
ALTER TABLE complaints DROP CONSTRAINT complaints_pkey;

-- Add a new numeric column 'id'
ALTER TABLE complaints ADD COLUMN id BIGSERIAL;

-- Set the new 'id' column as the primary key
ALTER TABLE complaints ADD CONSTRAINT complaints_pkey PRIMARY KEY (id);

-- Ensure the 'id' column uses the created sequence
ALTER TABLE complaints ALTER COLUMN id SET DEFAULT nextval('complaints_id_seq');
