import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTest {

    @Test
    void testGetters() {
        Expense e = new Expense("Repas", 50.0, LocalDate.of(2025, 8, 4));
        assertEquals("Repas", e.getLabel());
        assertEquals(50.0, e.getAmount());
        assertEquals(LocalDate.of(2025, 8, 4), e.getDate());
    }

    @Test
    void testIsLargeExpenseTrue() {
        Expense e = new Expense("Achat TV", 150.0, LocalDate.now());
        assertTrue(e.isLargeExpense());
    }

    @Test
    void testIsLargeExpenseFalse() {
        Expense e = new Expense("Café", 2.5, LocalDate.now());
        assertFalse(e.isLargeExpense());
    }
}