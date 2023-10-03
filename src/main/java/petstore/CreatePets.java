package petstore;

import java.util.List;

public class CreatePets {
    private Integer id;
    private String name;
    private String status;
    private List<String> photoUrls;

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    // Method to set pets
    public void setNameStatus(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public void setNameStatusPhoto(String name, String status, List<String> photoUrls) {
        this.name = name;
        this.status = status;
        this.photoUrls = photoUrls;
    }

}
