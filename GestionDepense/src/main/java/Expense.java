import java.time.LocalDate;

//Partie 1 — Classe de base Expense
public class Expense {
    private String label;
    private double amount;
    private LocalDate date;

    public Expense(String label, double amount, LocalDate date) {
        this.label = label;
        this.amount = amount;
        this.date = date;
    }

   public boolean isLargeExpense (){
            return amount > 100.0;
    }


    public String toString () {
        return "Expense: " + label + ", Amount: $" + amount + ", Date: " + date;
    }

    public String getLabel() {
        return label;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isLargeExpense() {
        return true;
    }
}
