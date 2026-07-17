package io.github.andruid929.expensetracker.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.Set;

import io.github.andruid929.expensetracker.Expense;

public class JsonHandler {

    private static final JsonMapper jsonMapper;

    private static final TypeReference<Set<Expense>> EXPENSES_COLLECTION_TYPE = new TypeReference<>() {};

    static {
        jsonMapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
    }

    private JsonHandler() {
        //Utility classes cannot be instantiated
    }

    @Nullable
    public static String toJson(@NotNull Set<Expense> expenses) {
        try {
            return jsonMapper.writeValueAsString(expenses);

        } catch (JsonProcessingException _) {
            return null;
        }
    }

    @Unmodifiable
    public static Set<Expense> fromJson(@NotNull String jsonString) {
        try {
            Set<Expense> expenseSet = jsonMapper.readValue(jsonString, EXPENSES_COLLECTION_TYPE);

            return Collections.unmodifiableSet(expenseSet);
        } catch (JsonProcessingException _) {

            System.err.println("I was unable to read the save file");

            return Collections.emptySet();
        }
    }
}
