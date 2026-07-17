package io.github.andruid929.expensetracker;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "expense-tracker",
        description = "Save and view expenses",
        mixinStandardHelpOptions = true,
        version = "1.0"
)
public class ExpenseTracker implements Runnable {

    public static boolean discardOnClose = false;

    public static void main(String[] args) {
        Worker.assign();

        int exitCode = new CommandLine(new ExpenseTracker()).execute(args);

        if (!discardOnClose) {
            Worker.dismiss();
        }

        System.exit(exitCode);
    }

    @Override
    public void run() {
        main(new String[]{"-h"});
    }
}
