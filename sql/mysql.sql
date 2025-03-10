CREATE DATABASE talentflow;
USE talentflow;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) not null,
    lastName VARCHAR(255) not null,
    email VARCHAR(255) not null,
    password VARCHAR(255) not null,
    role ENUM("recruteur", "condidat") NOT NULL
);

CREATE TABLE candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    phone VARCHAR(255),
    diplome varchar(255),
    cv VARCHAR(255),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE recruiters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    company VARCHAR(255),
    address varchar(255),
    phone VARCHAR(255),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

SELECT
    users.id as userId,
    firstName,
    lastName,
    email,
    role,
    recruiters.id as recruiterId,
    company,
    address,
    phone
FROM users
INNER JOIN recruiters
    ON users.id = recruiters.user_id
    WHERE recruiters.user_id = 1;


UPDATE users
    SET firstName = ?,
         lastName = ?,
         email = ?
WHERE id = ?;

UPDATE candidates
    SET phone = ?,
        diplome = ?
WHERE user_id = ?;

UPDATE recruiters
    SET company = ?,
        address = ?,
        phone = ?
WHERE user_id = ?;




























