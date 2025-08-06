public class RecurringExpense extends Expense.java{
    private Reccurence recurence;

    public RecurringExpense(Reccurence recurence) {
        this.recurence = recurence;
        if (recurence != "monthly" && recurence != "yearly")
    }

    public Reccurence getRecurence() {
        return recurence;
    }

    @Override
    public String toString() {
        return "Refunded = " + refunded;
    }
}
