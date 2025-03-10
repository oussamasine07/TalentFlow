package talentflow.model;

public class Candidat extends User {

    private int candidatId;
    private String diploma;
    private String phone;
    private String cv;

    public Candidat(String email) {
        super(email);
    }

    public Candidat(String firstName, String lastName, String email, String diploma, String phone, String cv){
        super(firstName,lastName,email);
        this.diploma = diploma;
        this.phone = phone;
        this.cv = cv;
    }

    public Candidat(int candidatId) {
        this.candidatId = candidatId;
    }

    public Candidat(int id, String firstName, String lastName, String email, String role, String password) {
        super(id, firstName, lastName, email, role, password);
    }

    public Candidat(int id, String firstName, String lastName, String email, String blank) {
        super(id, firstName, lastName, email);
    }

    public Candidat(String firstName, String lastName, String email, String role, String password) {
        super(firstName, lastName, email, role, password);
    }

    public Candidat(int candidatId, String diploma, String phone, String cv) {
        this.candidatId = candidatId;
        this.diploma = diploma;
        this.phone = phone;
        this.cv = cv;
    }

    public Candidat(String phone, String diploma) {
        this.diploma = diploma;
        this.phone = phone;
    }

    public Candidat(int id, String firstName, String lastName, String email, String role, String password, int candidatId, String diploma, String phone, String cv) {
        super(id, firstName, lastName, email, role, password);
        this.candidatId = candidatId;
        this.diploma = diploma;
        this.phone = phone;
        this.cv = cv;
    }

    public Candidat(String firstName, String lastName, String email, String role, String password, int candidatId, String diploma, String phone, String cv) {
        super(firstName, lastName, email, role, password);
        this.candidatId = candidatId;
        this.diploma = diploma;
        this.phone = phone;
        this.cv = cv;
    }



    public int getCandidatId() {
        return candidatId;
    }

    public String getDiploma() {
        return diploma;
    }

    public String getPhone() {
        return phone;
    }

    public String getCv() {
        return cv;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
}
