create table candidatures (
    id int AUTO_INCREMENT primary key,
    candidat_id int not null,
    offre_id int not null,
    is_canceled boolean default false,
    status enum("acceptée", "refusée", "en attente"),
    FOREIGN KEY (candidat_id ) REFERENCES candidates (id),
    FOREIGN KEY (offre_id ) REFERENCES offers (id)

);
