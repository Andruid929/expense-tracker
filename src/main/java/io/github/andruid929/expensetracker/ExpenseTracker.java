package io.github.andruid929.expensetracker;

import picocli.CommandLine;
import picocli.CommandLine.Command;

public class ExpenseTracker implements Runnable{

    @Command(
            name = "expense-tracker",
            description = "Simple expense tracker",
            mixinStandardHelpOptions = true,
            version = "1.0")
    public static void main(String[] args) {
        int exitCode = new CommandLine(new ExpenseTracker()).execute(args);

        System.exit(exitCode);
    }

    @Override
    public void run() {
        System.out.println("Use 'expense --help' to see available commands");
    }
}
