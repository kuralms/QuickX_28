package quick.kural.quickstart.Retrofit.Objects;

public class Obj_vp_data {
    private String image_address,text;

    public Obj_vp_data(String image_address, String text) {
        this.image_address = image_address;
        this.text = text;
    }

    public String getImage_address() {
        return image_address;
    }

    public void setImage_address(String image_address) {
        this.image_address = image_address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
