package talentflow.model;

public class Offer {
    private int id;
    private String title;
    private String description;
    private String offer_date;
    private Recruiter recruiter;

    public Offer(String title, String description, String offer_date, Recruiter recruiter) {
        this.title = title;
        this.description = description;
        this.offer_date = offer_date;
        this.recruiter = recruiter;
    }

    public Offer(int id, String title, String description, String offer_date, Recruiter recruiter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.offer_date = offer_date;
        this.recruiter = recruiter;
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

    public String getOffer_date() {
        return offer_date;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public void setOffer_date(String offer_date) {
        this.offer_date = offer_date;
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
