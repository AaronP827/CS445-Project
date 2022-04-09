public class Ask extends Post{
    private String dateReceived;

    public Ask(String uid, String aid, String type, String description, String startDate, String endDate, String seperateZips, boolean active, String dateRecieved){
        super(uid, aid, type, description, startDate, endDate, seperateZips, active);
        this.setDateReceived(dateRecieved);
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }
}