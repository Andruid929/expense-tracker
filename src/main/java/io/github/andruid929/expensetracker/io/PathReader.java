package io.github.andruid929.expensetracker.io;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Files;

import io.github.andruid929.expensetracker.defaults.FilePaths;

public class PathReader {

    private PathReader() {
        //Utility classes cannot be instantiated
    }

    @Nullable
    public static String readSaves() {
        try {
            return Files.readString(FilePaths.SAVE_FILEPATH);

        } catch (IOException _) {
            return null;
        }
    }

}
