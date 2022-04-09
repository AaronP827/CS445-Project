public class Give extends Post{
    private String dateCreated;

    public Give(String uid, String pid, String type, String description, String startDate, String endDate, String seperateZips, boolean active, String dateCreated) {
        super(uid, pid, type, description, startDate, endDate, seperateZips, active);
        setDateCreated(dateCreated);
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
