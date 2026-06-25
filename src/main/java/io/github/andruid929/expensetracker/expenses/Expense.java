package io.github.andruid929.expensetracker.expenses;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Expense {

    private static long nextId = 0;

    private final long id;

    private final String description;

    private final LocalDate dateAdded;

    private final BigDecimal amount;

    public Expense(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
        
        dateAdded = LocalDate.now();

        id = ++nextId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return id == expense.id && Objects.equals(description, expense.description) && Objects.equals(dateAdded, expense.dateAdded) && Objects.equals(amount, expense.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, dateAdded, amount);
    }

}
