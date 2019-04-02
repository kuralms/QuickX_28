package quickstartx.kural.utils;

public class BaseObject {
    private String image_address,title,summary;

    public BaseObject(String image_address, String title, String summary) {
        this.image_address = image_address;
        this.title = title;
        this.summary = summary;
    }

    public String getImage_address() {
        return image_address;
    }

    public void setImage_address(String image_address) {
        this.image_address = image_address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
