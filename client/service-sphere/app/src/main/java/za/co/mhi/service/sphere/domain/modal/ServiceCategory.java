package za.co.mhi.service.sphere.domain.modal;

public class ServiceCategory {
    private String category;
    private String pictureName;

    public ServiceCategory() {
    }

    public ServiceCategory(String category, String pictureName) {
        this.category = category;
        this.pictureName = pictureName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
