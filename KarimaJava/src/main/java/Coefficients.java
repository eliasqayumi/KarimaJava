public class Coefficients {
    protected static float VEHICLEAGE = 1.1f;
    protected static float vehicleValue = 0.08f;
    protected static float previousIndemnity = 0.05f;

    public Coefficients() {
    }

    public float getVehicleAge() {
        return VEHICLEAGE;
    }

    public void setVehicleAge(float vehicleAge) {
        this.VEHICLEAGE = vehicleAge;
    }

    public float getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(float vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    public float getPreviousIndemnity() {
        return previousIndemnity;
    }

    public void setPreviousIndemnity(float previousIndemnity) {
        this.previousIndemnity = previousIndemnity;
    }
}
