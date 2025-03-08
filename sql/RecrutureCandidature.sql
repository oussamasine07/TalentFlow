select
    users.firstName,
    users.lastName,
    users.email,
    candidates.phone,
    candidates.diplome,
    candidates.cv,
    candidatures.status
from users
inner join candidates
    on users.id = candidates.user_id
inner join candidatures
    on candidates.id = candidatures.candidat_id
inner join offers
    on offers.id = candidatures.offre_id
where offers.id = ?;

