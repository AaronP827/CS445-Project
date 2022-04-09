public class Notes{
    private String uid;
    private String nid;
    private String type;
    private String toUserID;
    private String toID;
    private String description;
    private String dateCreated;

    public Notes(String uid, String nid, String type, String toUserID, String toID, String description, String dateCreated){
        this.setUid(uid);
        this.setNid(nid);
        this.setType(type);
        this.setToUserID(toUserID);
        this.setToID(toID);
        this.setDescription(description);
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

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
