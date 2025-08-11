import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDAOTest {
    private ExpenseDAO dao;
    private RefundableExpense refundExp;
    private RecurringExpense recurringExp;
    private Expense largeExp;

    @BeforeEach
    void setUp() {
        refundExp = new RefundableExpense("Frais pro", 80.0, LocalDate.now());
        recurringExp = new RecurringExpense("Netflix", 15.0, LocalDate.now(), "monthly");
        largeExp = new Expense("Ordinateur", 1200.0, LocalDate.now());

        dao = new ExpenseDAO(Arrays.asList(refundExp, recurringExp, largeExp));
    }

    @Test
    void testGetUnrefundedExpenses() {
        List<RefundableExpense> unrefunded = dao.getUnrefundedExpenses();
        assertEquals(1, unrefunded.size());
        assertEquals("Frais pro", unrefunded.get(0).getLabel());
    }

    @Test
    void testGetTotalRecurringExpenses() {
        double total = dao.getTotalRecurringExpenses();
        assertEquals(15.0, total);
    }

    @Test
    void testGetLargeExpenseLabels() {
        List<String> labels = dao.getLargeExpenseLabels();
        assertTrue(labels.contains("Ordinateur"));
        assertFalse(labels.contains("Netflix"));
    }

    @Test
    void testGetTotalExpensesAmount() {
        double total = dao.getTotalExpensesAmount();
        assertEquals(80.0 + 15.0 + 1200.0, total);
    }
}

