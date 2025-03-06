CREATE DATABASE talentflow;
USE talentflow;

CREATE TABLE offers(
    id int AUTO_INCREMENT PRIMARY KEY,
    recruiter_id int,
    title VARCHAR(255),
    description TEXT,
    offer_date DATETIME DEFAULT NOW(),
    foreign key(recruiter_id) references recruiters(id) ON DELETE CASCADE
);

SELECT * FROM recruiters WHERE user_id = 2;

UPDATE offers
SET
    title = ?,
     description = ?,
     offer_date = ?
WHERE id = ?;