package io.github.andruid929.expensetracker.io;

import static io.github.andruid929.expensetracker.defaults.FilePaths.APP_FOLDER_PATH;
import static io.github.andruid929.expensetracker.defaults.FilePaths.SAVE_FILEPATH;
import static io.github.andruid929.leutils.stringutil.StringFormatter.interpolate;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;

import io.github.andruid929.leutils.stringutil.StringFormatter;

public class PathWriter {

    private PathWriter() {
        //Utility classes cannot be instantiated
    }

    public static boolean saveToFile(@NotNull String jsonString) {
        try {
            Files.writeString(SAVE_FILEPATH, jsonString);

            return true;

        } catch (IOException _) {
            return false;
        }
    }

    public static void validateAppPaths() {
        try {
            if (Files.notExists(APP_FOLDER_PATH)) {
                Files.createDirectory(APP_FOLDER_PATH);

                Files.createFile(SAVE_FILEPATH);
            }

            if (Files.notExists(SAVE_FILEPATH)) {
                Files.createFile(SAVE_FILEPATH);
            }
        } catch (IOException e) {
            String message = interpolate("I may not be able to save expenses: {}", e.getMessage());

            System.err.println(message);
        }
    }

}
