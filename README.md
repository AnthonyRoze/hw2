# Expense Tracker App – CS 520 Homework 2

## Overview

This project is a redesign and extension of the original Expense Tracker App. The goal was to improve the application in terms of understandability, modularity, extensibility, and testability while following best practices such as the Open-Closed Principle and the Strategy Design Pattern. This version also applies the MVC (Model-View-Controller) architecture more strictly.

---

## New Functionality

### 1. Filter Feature (Strategy Design Pattern)
- Users can now filter transactions by either **amount** or **category**.
- This was implemented using the Strategy Design Pattern.
- Two filter strategies were created:
  - `AmountFilter`: filters transactions with amount less than or equal to the specified value.
  - `CategoryFilter`: filters transactions by a specific category name.
- Validation for inputs is handled using methods from `InputValidation.java`, as done in Homework 1.
- Filter controls are available in the UI via a dropdown and text field, with an "Apply Filter" button.

### 2. Input Validation
- The application uses strict input validation for:
  - Amount: must be a positive number ≤ 1000.
  - Category: must be one of five valid categories – `food`, `travel`, `bills`, `entertainment`, or `other`.

### 3. Improved Modularity (Open-Closed Principle)
- `Transaction` class was made immutable:
  - Removed setters.
  - Fields are `private final`.
- The `ExpenseTrackerModel` uses encapsulation:
  - The internal list of transactions is private.
  - The getter returns an unmodifiable copy of the list.
- These changes improve information hiding and protect against unintended data modification.

### 4. Unit Testing (Testability)
- All existing tests pass.
- Four new test cases were added:
  1. Add Transaction
  2. Invalid Input Handling
  3. Filter by Amount
  4. Filter by Category
- Test files are located in the `test/` folder.
- A screenshot of the test runner with all tests passing is included in the submission.

---

## How to Compile and Run

From the root project directory:

```bash
# Compile the app
ant compile

# Run tests
ant test

# (Optional) Clean build files
ant clean
```

## Javadoc
The Javadoc for all source files was generated using Ant and is available in the jdoc/ folder.
