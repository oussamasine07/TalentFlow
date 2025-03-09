package talentflow.model;

public class Recruiter extends User {
     private int recruiterId;
     private String company;
     private String phone;
     private String address;

    public Recruiter() {
    }

    public Recruiter(String email) {
        super(email);
    }

    public Recruiter(int id, String firstName, String lastName, String email, String role, String password) {
        super(id, firstName, lastName, email, role, password);
    }

    public Recruiter(int id, String firstName, String lastName, String email, String role, int recruiterId, String company, String phone, String address) {
        super(id, firstName, lastName, email, role);
        this.recruiterId = recruiterId;
        this.company = company;
        this.phone = phone;
        this.address = address;
    }

    public Recruiter(String firstName, String lastName, String email, String role, String password) {
        super(firstName, lastName, email, role, password);
    }

    public Recruiter (int recruiterId, String company, String phone, String address) {
        this.recruiterId = recruiterId;
        this.company = company;
        this.phone = phone;
        this.address = address;
    }


    public int getRecruiterId() {
        return recruiterId;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
