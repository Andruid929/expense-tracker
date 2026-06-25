package io.github.andruid929.expensetracker.io;

import org.jetbrains.annotations.Range;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import io.github.andruid929.leutils.wora.PathFinder;
import picocli.CommandLine;

public class ExpenseIO {

    public static final Path EXPENSES_SAVE_FILE = Path.of(PathFinder.DOCUMENTS_FOLDER, "Expenses.json");

    /*
     * Utility classes cannot be instantiated.
     */

    private ExpenseIO() {
    }

    public static void createSaveFile() {
        if (Files.notExists(EXPENSES_SAVE_FILE)) {
            try {

                Path outputPath = Files.createFile(EXPENSES_SAVE_FILE);

                System.out.print("Expenses save file created at '" + outputPath + "'");

            } catch (IOException e) {
                System.err.println("Unable to create save file: " + e.getMessage());
                System.err.println("Expenses will not be persisted");
            }
        }
    }

    public static void saveExpense() {
    }

    public static Set<Object> loadExpenses() {
        return Set.of();
    }

}
