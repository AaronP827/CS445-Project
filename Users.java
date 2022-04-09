import java.util.ArrayList;

public class Users{
    private String uid;
    private String name;
    private String street;
    private String zip;
    private String phone;
    private String picture;
    private boolean isActive;
    private String dateCreated;
    private final ArrayList<Post> postsList = new ArrayList<>();

    public Users(String uid, String name, String street, String zip, String phone, String picture, boolean isActive, String dateCreated){
        this.setUid(uid);
        this.setName(name);
        this.setStreet(street);
        this.setZip(zip);
        this.setPhone(phone);
        this.setPicture(picture);
        this.setActive(isActive);
        this.setDateCreated(dateCreated);
    }

    public ArrayList<Post> getPostsList() {
        return postsList;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public String toString(){
        return getUid() + ", " + getName() + ", " 
        + getStreet() + ", " + getZip() + ", " + getPhone() + 
        ", " +getPicture() + ", " + Boolean.toString(isActive()) 
        + ", " + getDateCreated();
    }
}
