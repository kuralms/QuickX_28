
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reuse implements Serializable
{

    @SerializedName("core")
    @Expose
    private Boolean core;
    @SerializedName("side_core1")
    @Expose
    private Boolean sideCore1;
    @SerializedName("side_core2")
    @Expose
    private Boolean sideCore2;
    @SerializedName("fairings")
    @Expose
    private Boolean fairings;
    @SerializedName("capsule")
    @Expose
    private Boolean capsule;
    private final static long serialVersionUID = -4071404985829956686L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Reuse() {
    }

    /**
     * 
     * @param capsule
     * @param fairings
     * @param sideCore2
     * @param core
     * @param sideCore1
     */
    public Reuse(Boolean core, Boolean sideCore1, Boolean sideCore2, Boolean fairings, Boolean capsule) {
        super();
        this.core = core;
        this.sideCore1 = sideCore1;
        this.sideCore2 = sideCore2;
        this.fairings = fairings;
        this.capsule = capsule;
    }

    public Boolean getCore() {
        return core;
    }

    public void setCore(Boolean core) {
        this.core = core;
    }

    public Boolean getSideCore1() {
        return sideCore1;
    }

    public void setSideCore1(Boolean sideCore1) {
        this.sideCore1 = sideCore1;
    }

    public Boolean getSideCore2() {
        return sideCore2;
    }

    public void setSideCore2(Boolean sideCore2) {
        this.sideCore2 = sideCore2;
    }

    public Boolean getFairings() {
        return fairings;
    }

    public void setFairings(Boolean fairings) {
        this.fairings = fairings;
    }

    public Boolean getCapsule() {
        return capsule;
    }

    public void setCapsule(Boolean capsule) {
        this.capsule = capsule;
    }

}
