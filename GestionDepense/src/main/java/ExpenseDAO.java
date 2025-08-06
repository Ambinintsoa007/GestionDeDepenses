import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Partie 3 — Manipulations avec Streams
public class ExpenseDAO extends Expense{
    private Expense expenses;

    public ExpenseDAO (Expense expenses){
        this.expenses = expenses;
    }

    public List<RefindableExpense> isNotRefundable(){
        return expenses.stream()
                .filter(e -> !e.isRefinded)
                .collect(Collectors.toList());
    }
    public double totalAount(){
        return expenses.stream()
                .filter(e -> e instanceof RecurringExpense)
                .map(Expense::getAmount)
                .sum()
    }

    public List<String> expenseLabels() {
        return expenses.stream()
                .filter(Expense::isLargeExpense)
                .map(Expense::getLabel)
                .collect(Collectors.toList());
    }

    public double totalExpenses() {
        return expenses.stream()
                .map(Expense::getAmount)
                .sum();
    }
}