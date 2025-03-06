package talentflow.model;

public class Candidatures {
    private int id;
    private String titre;
    private String candidatId;
    private String offreId;
    private String datePostulation;
    private String status;
    private String commentaire;

    public Candidatures() {}

    public Candidatures(int id, String titre, String candidatId, String offreId, String datePostulation, String status, String commentaire) {
        this.id = id;
        this.titre = titre;
        this.candidatId = candidatId;
        this.offreId = offreId;
        this.datePostulation = datePostulation;
        this.status = status;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(String candidatId) {
        this.candidatId = candidatId;
    }

    public String getOffreId() {
        return offreId;
    }

    public void setOffreId(String offreId) {
        this.offreId = offreId;
    }

    public String getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(String datePostulation) {
        this.datePostulation = datePostulation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
