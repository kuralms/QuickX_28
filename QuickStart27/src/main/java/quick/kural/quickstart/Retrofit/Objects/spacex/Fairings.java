
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fairings implements Serializable
{

    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("recovery_attempt")
    @Expose
    private Boolean recoveryAttempt;
    @SerializedName("recovered")
    @Expose
    private Boolean recovered;
    @SerializedName("ship")
    @Expose
    private Object ship;
    private final static long serialVersionUID = -7048774349178189069L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fairings() {
    }

    /**
     * 
     * @param recovered
     * @param ship
     * @param recoveryAttempt
     * @param reused
     */
    public Fairings(Boolean reused, Boolean recoveryAttempt, Boolean recovered, Object ship) {
        super();
        this.reused = reused;
        this.recoveryAttempt = recoveryAttempt;
        this.recovered = recovered;
        this.ship = ship;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getRecoveryAttempt() {
        return recoveryAttempt;
    }

    public void setRecoveryAttempt(Boolean recoveryAttempt) {
        this.recoveryAttempt = recoveryAttempt;
    }

    public Boolean getRecovered() {
        return recovered;
    }

    public void setRecovered(Boolean recovered) {
        this.recovered = recovered;
    }

    public Object getShip() {
        return ship;
    }

    public void setShip(Object ship) {
        this.ship = ship;
    }

}
