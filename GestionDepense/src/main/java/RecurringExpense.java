//Partie 2 — Héritage
public class RecurringExpense {
    private Reccurence recurence;

    public RecurringExpense(Reccurence recurence) {
        this.recurence = recurence;
        if (recurence != "monthly" && recurence != "yearly"){
            return "Recurence is invalid";
        }
    }

    public Reccurence getRecurence() {
        return recurence;
    }

    @Override
    public String toString() {
        return "Refundable Expense: Label = " + getLabel() + ", Amount = $" + String.format("%.2f", getAmount())
                + ", Date = " + getDate() + ", Refunded = " + refunded;
    }
}
