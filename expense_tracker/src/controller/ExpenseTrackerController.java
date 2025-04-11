package controller;

import view.ExpenseTrackerView;

import java.util.List;

import javax.swing.JOptionPane;

import filter.TransactionFilter;
import filter.AmountFilter;
import filter.CategoryFilter;
import controller.InputValidation;

import model.ExpenseTrackerModel;
import model.Transaction;
public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
    view.setFilterButtonAction(() -> applyFilter(view.getSelectedFilterType(), view.getFilterValue()));
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }
  
  public void applyFilter(String filterType, String filterValue) {
    TransactionFilter filter = null;

    if (filterType.equalsIgnoreCase("amount")) {
        try {
            double amount = Double.parseDouble(filterValue);
            if (!InputValidation.isValidAmount(amount)) {
                view.showError("Invalid amount entered.");
                return;
            }
            filter = new AmountFilter(amount);
        } catch (NumberFormatException e) {
            view.showError("Amount must be a number.");
            return;
        }
    } 
    else if (filterType.equalsIgnoreCase("category")) {
        if (!InputValidation.isValidCategory(filterValue)) {
            view.showError("Invalid category entered.");
            return;
        }
        filter = new CategoryFilter(filterValue);
    } 
    else {
        view.showError("Unknown filter type.");
        return;
    }
    List<Transaction> filtered = filter.filter(model.getTransactions());
    view.refreshTable(filtered);
  }
  
}