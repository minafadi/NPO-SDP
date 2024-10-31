import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private List<Drug> drugList = new ArrayList<Drug>();
    private Payment payment;
    private double totalPrice;

    public Boolean isDrugAvailable(Drug drug) {
        return drugList.contains(drug);
    }

    public double getDrugPrice(Drug drug) {
        if (isDrugAvailable(drug))
            return drug.getPrice();
        else return -1;
    }

    public boolean addDrug(Drug drug) {
        drugList.add(drug);
        return true;
    }

    public Boolean removeDrug(Drug drug) {
        drugList.remove(drug);
        return true;
    }

    public Boolean pay() {
        return false;
    }

    public double getTax() {
        return payment.getTax();
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
