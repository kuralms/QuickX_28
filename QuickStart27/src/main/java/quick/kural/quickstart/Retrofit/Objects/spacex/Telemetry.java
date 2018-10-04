
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telemetry implements Serializable
{

    @SerializedName("flight_club")
    @Expose
    private Object flightClub;
    private final static long serialVersionUID = 2156137470440066905L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Telemetry() {
    }

    /**
     * 
     * @param flightClub
     */
    public Telemetry(Object flightClub) {
        super();
        this.flightClub = flightClub;
    }

    public Object getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(Object flightClub) {
        this.flightClub = flightClub;
    }

}
