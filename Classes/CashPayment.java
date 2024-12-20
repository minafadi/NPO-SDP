package Classes;

public class CashPayment implements Payment {
    private double tax;
    private String description="Invoice Paid using Cash Method";

    @Override
    public boolean executePayment() {
        throw new UnsupportedOperationException("Unimplemented method 'executePayment'");
    }

    @Override
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
