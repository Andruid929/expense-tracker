package io.github.andruid929.expensetracker.session;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import io.github.andruid929.expensetracker.io.ExpenseIO;
import org.jetbrains.annotations.NotNull;

public class Session {

    private static int instancesRunning = 0;

    private Set<Object> expenses;

    private Session() {
        instancesRunning++;

        expenses = ExpenseIO.loadExpenses();
    }

    public void addExpense(Object expense) {
        expenses.add(expense);
    }

    public static @NotNull Session createSession() {
        if (instancesRunning > 0) {
            throw new IllegalStateException("Cannot have multiple sessions running");
        }

        return new Session();
    }
}
