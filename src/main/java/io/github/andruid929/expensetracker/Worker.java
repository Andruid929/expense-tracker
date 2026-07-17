package io.github.andruid929.expensetracker;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import io.github.andruid929.expensetracker.io.PathReader;
import io.github.andruid929.expensetracker.io.PathWriter;
import io.github.andruid929.expensetracker.json.JsonHandler;

public final class Worker {

    private static final Set<Expense> LOADED_EXPENSES = new HashSet<>();

    private Worker() {
        //Utility classes cannot be instantiated
    }

    public static void assign() {
        PathWriter.validateAppPaths();

        deserialise();
    }

    public static void dismiss() {
        serialise();
    }

    public static void serialise() {
        String jsonString = JsonHandler.toJson(LOADED_EXPENSES);

        if (jsonString == null) {
            System.out.println("I was unable to save expenses");

            return;
        }

        PathWriter.saveToFile(jsonString);
    }

    public static void deserialise() {
        String jsonString = PathReader.readSaves();

        if (jsonString == null) {
            System.err.println(" I was unable to read save data");

            return;
        }

        Set<Expense> savedExpenses = JsonHandler.fromJson(jsonString);

        if (!savedExpenses.isEmpty()) {
            LOADED_EXPENSES.addAll(savedExpenses);
        }
    }

    public static void add(@NotNull Expense expense) {

        if (LOADED_EXPENSES.contains(expense)) {
            System.err.println("Duplicate expense ID detected, discarding");

            return;
        }

        if (LOADED_EXPENSES.add(expense)) {
            System.out.println("Expense added successfully");
        }
    }

    public static boolean remove(long id) {
        return LOADED_EXPENSES.removeIf(expense -> expense.getID() == id);
    }
}
