package io.github.andruid929.expensetracker.defaults;

import java.nio.file.Path;

import io.github.andruid929.leutils.wora.PathFinder;

public final class FilePaths {

    public static final String APP_FOLDER_NAME = "Expense tracker";

    public static final String SAVE_FILENAME = "Expenses.json";

    public static final Path APP_FOLDER_PATH = PathFinder.getDocumentsFolder().resolve(APP_FOLDER_NAME);

    public static final Path SAVE_FILEPATH = APP_FOLDER_PATH.resolve(SAVE_FILENAME);

    private FilePaths() {
        //Utility classes cannot be instantiated
    }
}
