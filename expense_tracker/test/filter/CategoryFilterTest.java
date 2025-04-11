package filter;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class CategoryFilterTest {

    @Test
    public void testFilterByCategory_ShouldReturnMatchingTransactions() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(150.0, "food"));
        transactions.add(new Transaction(250.0, "travel"));
        transactions.add(new Transaction(120.0, "food"));
        transactions.add(new Transaction(80.0, "bills"));

        String filterCategory = "food";
        CategoryFilter filter = new CategoryFilter(filterCategory);

        // Act
        List<Transaction> result = filter.filter(transactions);

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(t -> t.getCategory().equalsIgnoreCase("food")));
    }
}

