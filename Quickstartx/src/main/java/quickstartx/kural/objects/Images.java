package quickstartx.kural.objects;

import com.google.gson.annotations.SerializedName;

public class Images {
    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("thumbUrl")
    private String thumbUrl;

    @SerializedName("description")
    private String description;




    public Images(String imageUrl, String thumbUrl, String description) {
        this.imageUrl = imageUrl;
        this.thumbUrl = thumbUrl;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Images setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public Images setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Images setDescription(String description) {
        this.description = description;
        return this;
    }
}
