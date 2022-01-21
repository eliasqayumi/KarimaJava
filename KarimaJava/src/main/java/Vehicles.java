public class Vehicles {
    private String count;
    private String plateNumber;
    private String firstRegistration;
    private String purchasePrice;
    private String producer;
    private String mileage;
    private String previewsIndemnity;
    private String annualFee;
    private String manualFee;


    public Vehicles() {
    }

    public Vehicles(String count, String plateNumber, String firstRegistration, String purchasePrice, String producer, String mileage, String previewsIndemnity, String annualFee, String manualFee) {
        this.count = count;
        this.plateNumber = plateNumber;
        this.firstRegistration = firstRegistration;
        this.purchasePrice = purchasePrice;
        this.producer = producer;
        this.mileage = mileage;
        this.previewsIndemnity = previewsIndemnity;
        this.annualFee = annualFee;
        this.manualFee = manualFee;
    }

    public Vehicles(String count, String plateNumber, String firstRegistration, String purchasePrice, String producer, String mileage, String previewsIndemnity) {
        this.count=count;
        this.plateNumber = plateNumber;
        this.firstRegistration = firstRegistration;
        this.purchasePrice = purchasePrice;
        this.producer = producer;
        this.mileage = mileage;
        this.previewsIndemnity = previewsIndemnity;
        this.annualFee="";
        this.manualFee="";
    }

    public String getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(String annualFee) {
        this.annualFee = annualFee;
    }

    public String getManualFee() {
        return manualFee;
    }

    public void setManualFee(String manualFee) {
        this.manualFee = manualFee;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(String firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPreviewsIndemnity() {
        return previewsIndemnity;
    }

    public void setPreviewsIndemnity(String previewsIndemnity) {
        this.previewsIndemnity = previewsIndemnity;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "plateNumber='" + plateNumber + '\'' +
                ", firstRegistration=" + firstRegistration +
                ", purchasePrice=" + purchasePrice +
                ", producer='" + producer + '\'' +
                ", mileage=" + mileage +
                ", previewsIndemnity=" + previewsIndemnity +
                '}';
    }
}
