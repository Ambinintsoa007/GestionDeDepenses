import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDAOTest {

    private ExpenseDAO dao;

    @BeforeEach
    void setUp() {
        Expense e1 = new RefundableExpense("Taxi", 50.0, LocalDate.now(), false);
        Expense e2 = new RefundableExpense("Avion", 200.0, LocalDate.now(), true);
        Expense e3 = new RecurringExpense("Netflix", 15.0, LocalDate.now());
        Expense e4 = new Expense("Achat PC", 120.0, LocalDate.now());
        Expense e5 = new RecurringExpense("Loyer", 500.0, LocalDate.now());

        dao = new ExpenseDAO(Arrays.asList(e1, e2, e3, e4, e5));
    }

    @Test
    void testGetUnrefundedExpenses() {
        List<RefundableExpense> result = dao.getUnrefundedExpenses();
        assertEquals(1, result.size());
        assertEquals("Taxi", result.get(0).getLabel());
        assertFalse(result.get(0).isRefunded());
    }

    @Test
    void testGetTotalRecurringExpensesAmount() {
        double total = dao.getTotalRecurringExpensesAmount();
        assertEquals(515.0, total, 0.01);
    }

    @Test
    void testGetLabelsOfLargeExpenses() {
        List<String> labels = dao.getLabelsOfLargeExpenses();
        assertTrue(labels.contains("Achat PC"));
        assertTrue(labels.contains("Avion"));
        assertTrue(labels.contains("Loyer"));
        assertEquals(3, labels.size());
    }

    @Test
    void testGetTotalExpensesAmount() {
        double total = dao.getTotalExpensesAmount();
        assertEquals(885.0, total, 0.01);
    }
}
