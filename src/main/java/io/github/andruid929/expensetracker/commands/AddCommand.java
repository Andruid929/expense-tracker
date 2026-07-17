package io.github.andruid929.expensetracker.commands;

import static picocli.CommandLine.Parameters;

import io.github.andruid929.expensetracker.Expense;
import io.github.andruid929.expensetracker.Worker;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "add", description = "Add a new expense")
public class AddCommand implements Runnable {

    @Parameters(description = "The amount spent")
    long amount = 0;

    @Option(names = {"-d", "--desc"}, defaultValue = "No description")
    String description;

    @Override
    public void run() {
        if (amount < 1) {
            System.out.println("Amount must be at least 1");
        }

        var expense = new Expense(description, amount);

        Worker.add(expense);
    }

}
