create table candidatures (
    id int AUTO_INCREMENT primary key,
    candidat_id int not null,
    offre_id int not null,
    is_canceled boolean default false,
    status enum("acceptée", "refusée", "en attente") DEFAULT "en attente",
    FOREIGN KEY (candidat_id ) REFERENCES candidates (id) ON DELETE CASCADE,
    FOREIGN KEY (offre_id ) REFERENCES offers (id) ON DELETE CASCADE
);


INSERT INTO candidatures
    (candidat_id, offre_id)
VALUES
    (?, ?);

SELECT * FROM candidatures
WHERE candidat_id = ? AND offre_id = ?;

SELECT
    offers.title,
    offers.offer_date,
    candidatures.id,
    candidatures.status,
    candidatures.is_canceled
FROM candidatures
inner join candidates
         on candidates.id = candidatures.candidat_id
INNER JOIN offers
         on offers.id = candidatures.offre_id
WHERE candidates.user_id = ?;

SELECT
    candidatures.id,
    candidatures.status,
    candidatures.is_canceled,
    candidates.user_id
FROM candidatures
inner join candidates
         on candidates.id = candidatures.candidat_id
WHERE candidatures.id = ? AND candidates.user_id = ?;

DELETE FROM candidatures WHERE id = ?;



























