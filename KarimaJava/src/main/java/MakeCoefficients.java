import java.util.HashMap;
import java.util.Map;

public class MakeCoefficients {
    private Map<String, Float> makeCoef;
    public MakeCoefficients() {
        makeCoef = new HashMap<String, Float>();
        makeCoef.put("VOLVO", 0.96f);
        makeCoef.put("TATRA", 0.85f);
        makeCoef.put("SUBARU", 1.2f);
        makeCoef.put("BMW", 1.3f);
        makeCoef.put("PORSCHE", 1.2f);
        makeCoef.put("TESLA", 11f);
    }

    public Map<String, Float> getMakeCoef() {
        return makeCoef;
    }

    public void setMakeCoef(HashMap<String, Float> makeCoef) {
        this.makeCoef = makeCoef;
    }
}
