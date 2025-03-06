package talentflow.model;

public class Offer {
    private int id;
    private String title;
    private String description;
    private String offerDate;
    private Recruiter recruiter;

    public Offer(String title, String description, String offerDate, Recruiter recruiter) {
        this.title = title;
        this.description = description;
        this.offerDate = offerDate;
        this.recruiter = recruiter;
    }

    public Offer(int id, String title, String description, String offerDate, Recruiter recruiter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.offerDate = offerDate;
        this.recruiter = recruiter;
    }

    public Offer(int id, String title, String description, String offerDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.offerDate = offerDate;
    }

    public Offer(String title, String description, String offerDate) {
        this.title = title;
        this.description = description;
        this.offerDate = offerDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getofferDate() {
        return offerDate;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public void setOfferDate(String offerDate) {
        this.offerDate = offerDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }
}
