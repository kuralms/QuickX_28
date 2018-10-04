
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrbitParams implements Serializable
{

    @SerializedName("reference_system")
    @Expose
    private String referenceSystem;
    @SerializedName("regime")
    @Expose
    private String regime;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("semi_major_axis_km")
    @Expose
    private Object semiMajorAxisKm;
    @SerializedName("eccentricity")
    @Expose
    private Object eccentricity;
    @SerializedName("periapsis_km")
    @Expose
    private Object periapsisKm;
    @SerializedName("apoapsis_km")
    @Expose
    private Object apoapsisKm;
    @SerializedName("inclination_deg")
    @Expose
    private Object inclinationDeg;
    @SerializedName("period_min")
    @Expose
    private Object periodMin;
    @SerializedName("lifespan_years")
    @Expose
    private Object lifespanYears;
    @SerializedName("epoch")
    @Expose
    private Object epoch;
    @SerializedName("mean_motion")
    @Expose
    private Object meanMotion;
    @SerializedName("raan")
    @Expose
    private Object raan;
    @SerializedName("arg_of_pericenter")
    @Expose
    private Object argOfPericenter;
    @SerializedName("mean_anomaly")
    @Expose
    private Object meanAnomaly;
    private final static long serialVersionUID = -3092079321439654471L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrbitParams() {
    }

    /**
     * 
     * @param semiMajorAxisKm
     * @param raan
     * @param periodMin
     * @param epoch
     * @param meanMotion
     * @param meanAnomaly
     * @param eccentricity
     * @param periapsisKm
     * @param inclinationDeg
     * @param lifespanYears
     * @param referenceSystem
     * @param argOfPericenter
     * @param longitude
     * @param apoapsisKm
     * @param regime
     */
    public OrbitParams(String referenceSystem, String regime, Object longitude, Object semiMajorAxisKm, Object eccentricity, Object periapsisKm, Object apoapsisKm, Object inclinationDeg, Object periodMin, Object lifespanYears, Object epoch, Object meanMotion, Object raan, Object argOfPericenter, Object meanAnomaly) {
        super();
        this.referenceSystem = referenceSystem;
        this.regime = regime;
        this.longitude = longitude;
        this.semiMajorAxisKm = semiMajorAxisKm;
        this.eccentricity = eccentricity;
        this.periapsisKm = periapsisKm;
        this.apoapsisKm = apoapsisKm;
        this.inclinationDeg = inclinationDeg;
        this.periodMin = periodMin;
        this.lifespanYears = lifespanYears;
        this.epoch = epoch;
        this.meanMotion = meanMotion;
        this.raan = raan;
        this.argOfPericenter = argOfPericenter;
        this.meanAnomaly = meanAnomaly;
    }

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(Object semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public Object getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Object eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Object getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(Object periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public Object getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(Object apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public Object getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(Object inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public Object getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(Object periodMin) {
        this.periodMin = periodMin;
    }

    public Object getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(Object lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public Object getEpoch() {
        return epoch;
    }

    public void setEpoch(Object epoch) {
        this.epoch = epoch;
    }

    public Object getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Object meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Object getRaan() {
        return raan;
    }

    public void setRaan(Object raan) {
        this.raan = raan;
    }

    public Object getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Object argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Object getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Object meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

}
