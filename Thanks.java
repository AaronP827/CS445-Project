public class Thanks {
    private String uid;
    private String tid;
    private String thanksTo;
    private String description;
    private String dateCreated;

    public Thanks(String uid, String tid, String thanksTo, String desciption, String dateCreated){
        this.setUid(uid);
        this.setTid(tid);
        this.setThanksTo(thanksTo);
        this.setDescription(desciption);
        this.setDateCreated(dateCreated);
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThanksTo() {
        return thanksTo;
    }

    public void setThanksTo(String thanksTo) {
        this.thanksTo = thanksTo;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
