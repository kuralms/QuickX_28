
package quick.kural.quickstart.Retrofit.Objects.spacex;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecondStage implements Serializable
{

    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = null;
    private final static long serialVersionUID = -5591662768958760842L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecondStage() {
    }

    /**
     * 
     * @param payloads
     * @param block
     */
    public SecondStage(Integer block, List<Payload> payloads) {
        super();
        this.block = block;
        this.payloads = payloads;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

}
