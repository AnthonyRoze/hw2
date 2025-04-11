package filter;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;

public class CategoryFilter implements TransactionFilter {
    private String category;

    public CategoryFilter(String category) {
        this.category = category.toLowerCase(); // case-insensitive match
    }

    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filtered = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getCategory().toLowerCase().equals(category)) {
                filtered.add(t);
            }
        }
        return filtered;
    }
}