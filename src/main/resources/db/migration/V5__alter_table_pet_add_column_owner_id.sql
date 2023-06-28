ALTER TABLE pets ADD owner_id INT,
ADD FOREIGN KEY (owner_id)
REFERENCES  owners (id);