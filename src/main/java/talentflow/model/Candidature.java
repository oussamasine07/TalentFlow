package talentflow.model;

public class Candidature {
    private int id;
    private Candidat candidat;
    private Offer offre;
    private String status;
    private boolean isCanceled;

    public Candidature() {}
    public Candidature(int id) {
        this.id = id;
    }

    public Candidature( int id, Candidat candidat, String status) {
        this.id = id;
        this.candidat = candidat;
        this.status = status;
    }

    public Candidature(int id, String status, boolean isCanceled, Offer offre) {
        this.id = id;
        this.offre = offre;
        this.status = status;
        this.isCanceled = isCanceled;
    }

    public Candidature(int id, String status, boolean isCanceled, Candidat candidat) {
        this.id = id;
        this.status = status;
        this.isCanceled = isCanceled;
        this.candidat = candidat;
    }

    public Candidature(Candidat candidat, Offer offer) {
        this.candidat = candidat;
        this.offre = offer;
    }

    public Candidature(int id, Candidat candidat, Offer offre, String status, boolean isCanceled) {
        this.id = id;
        this.candidat = candidat;
        this.offre = offre;
        this.status = status;
        this.isCanceled = isCanceled;
    }

    public Candidature(Candidat candidat, Offer offre, String status, boolean isCanceled) {
        this.candidat = candidat;
        this.offre = offre;
        this.status = status;
        this.isCanceled = isCanceled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Offer getOffre() {
        return offre;
    }

    public void setOffre(Offer offre) {
        this.offre = offre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
