

public class Main {

    public static void main(String[] args) {
        DataFetching dataFetching = new DataFetching();
        MakeCoefficients makeCoefficients = new MakeCoefficients();
        dataFetching.makeRisk(makeCoefficients);
        for (Vehicles vehicles : dataFetching.getDataList()) {
            System.out.println("Plate Number " + vehicles.getPlateNumber() + " Producer " + vehicles.getProducer() +
                    " Annual fee " + vehicles.getAnnualFee() + " manual fee " + vehicles.getManualFee());
        }
    }


}
