public abstract class Post {
    private String uid;
    private String pid;
    private String type;
    private String description;
    private String startDate;
    private String endDate;
    private String seperateZips;
    private boolean active;

    public Post(String uid, String pid, String type, String description, String startDate, String endDate, String seperateZips, boolean active){
        this.setUid(uid);
        this.setPid(pid);
        this.setType(type);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setSeperateZips(seperateZips);
        this.setActive(active);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSeperateZips() {
        return seperateZips;
    }

    public void setSeperateZips(String seperateZips) {
        this.seperateZips = seperateZips;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
