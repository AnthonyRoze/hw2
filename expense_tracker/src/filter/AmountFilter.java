package filter;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;

public class AmountFilter implements TransactionFilter {
    private double maxAmount;

    public AmountFilter(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filtered = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() <= maxAmount) {
                filtered.add(t);
            }
        }
        return filtered;
    }
}
