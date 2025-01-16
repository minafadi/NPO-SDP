package Models;

public class Nausea extends Symptom {
    private int intensity;

    public Nausea(Illness illness, DBProxy dbProxy) {
        this.illness = illness;
        this.illness.addDrug(Drug.readAllDrugs("Nausea", dbProxy));
    }
    public String getDescription() {
        return super.getDescription()+"nausea";
    }
    @Override
    public int severity() {
        return illness.severity() + 3;
    }

    @Override
    public double calculateCost() {
        return  illness.calculateCost()+70;
    }

}
