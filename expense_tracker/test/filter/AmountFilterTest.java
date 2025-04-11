package filter;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class AmountFilterTest {

    @Test
    public void testFilterByAmount_ShouldReturnMatchingTransactions() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100.0, "food"));
        transactions.add(new Transaction(300.0, "travel"));
        transactions.add(new Transaction(700.0, "bills"));
        transactions.add(new Transaction(1200.0, "entertainment")); // should be ignored

        double filterAmount = 700.0;
        AmountFilter filter = new AmountFilter(filterAmount);

        // Act
        List<Transaction> result = filter.filter(transactions);

        // Assert
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(t -> t.getAmount() <= 700.0));
    }
}
