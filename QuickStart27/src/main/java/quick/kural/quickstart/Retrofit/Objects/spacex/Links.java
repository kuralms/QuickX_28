
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Serializable
{

    @SerializedName("mission_patch")
    @Expose
    private String missionPatch;
    @SerializedName("mission_patch_small")
    @Expose
    private String missionPatchSmall;
    @SerializedName("article_link")
    @Expose
    private String articleLink;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("video_link")
    @Expose
    private String videoLink;
    @SerializedName("flickr_images")
    @Expose
    private List<Object> flickrImages = null;
    private final static long serialVersionUID = 6258055709952436994L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param missionPatch
     * @param articleLink
     * @param missionPatchSmall
     * @param flickrImages
     * @param videoLink
     * @param wikipedia
     */
    public Links(String missionPatch, String missionPatchSmall, String articleLink, String wikipedia, String videoLink, List<Object> flickrImages) {
        super();
        this.missionPatch = missionPatch;
        this.missionPatchSmall = missionPatchSmall;
        this.articleLink = articleLink;
        this.wikipedia = wikipedia;
        this.videoLink = videoLink;
        this.flickrImages = flickrImages;
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public List<Object> getFlickrImages() {
        return flickrImages;
    }

    public void setFlickrImages(List<Object> flickrImages) {
        this.flickrImages = flickrImages;
    }

}
