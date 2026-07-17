package io.github.andruid929.expensetracker;

import static io.github.andruid929.leutils.stringutil.StringFormatter.interpolate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Objects;

public final class Expense {

    private static long previousID = 0;

    private final long id;

    private @NotNull String description;
    private long amount;

    public Expense(@NotNull String description, @Range(from = 0, to = Long.MAX_VALUE) long amount) {
        this.description = description;
        this.amount = amount;

        this.id = ++previousID;
    }


    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getID() {
        return id;
    }

    public static void updateLastID(long newID) {
        previousID = newID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;
        return id == expense.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return interpolate("Expense{id={}, desc='{}', amount={}}", id, description, amount);
    }
}
