//Partie 2 — Héritage
public class RefundableExpense {
    private boolean refunded;

    public RefundableExpense(boolean refunded) {
        this.refunded = refunded;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public static boolean refund(){
        return true;
    }

    @Override
    public String toString() {
        return "Refundable Expense: Label = " + getLabel() + ", Amount = $" + String.format("%.2f", getAmount())
                + ", Date = " + getDate() + ", Refunded = " + refunded;
    }
}
