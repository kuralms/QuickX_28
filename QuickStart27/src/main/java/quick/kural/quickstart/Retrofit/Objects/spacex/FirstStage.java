
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FirstStage implements Serializable
{

    @SerializedName("cores")
    @Expose
    private List<Core> cores = null;
    private final static long serialVersionUID = 4852914237263069209L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FirstStage() {
    }

    /**
     * 
     * @param cores
     */
    public FirstStage(List<Core> cores) {
        super();
        this.cores = cores;
    }

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

}
