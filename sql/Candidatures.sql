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
