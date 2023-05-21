package utilities;

import com.google.gson.*;
import exceptions.IncorrectWorkerFieldException;
import managers.DataManager;
import workerRelated.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * This class represents a custom deserializer for JSON data representing a {@link Worker} object.
 * It implements the {@link JsonDeserializer} interface and provides a custom implementation for the deserialize method.
 * It ensures that the JSON data contains all the necessary fields for creating a {@link Worker} object and that the data is in the correct format.
 */
public class WorkerDeserializer implements JsonDeserializer<Worker> {
    /**
     * This method implements the custom deserialization logic for creating a {@link Worker} object from JSON data.
     * It ensures that the JSON data contains all the necessary fields for creating a {@link Worker} object and that the data is in the correct format.
     *
     * @param json    the JSON element containing the data to be deserialized
     * @param typeOfT the type of the object to be deserialized
     * @param context the context in which the deserialization is happening
     * @return a new {@link Worker} object created from the JSON data
     * @throws JsonParseException            if the JSON data is malformed or does not contain the necessary fields
     * @throws IncorrectWorkerFieldException if any of the fields in the JSON data are in the wrong format
     */
    @Override
    public Worker deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        DataManager.ensureHas(jsonObject, "name");
        if (jsonObject.get("name").getAsString().isBlank()) {
            throw new IncorrectWorkerFieldException();
        }
        String name = jsonObject.get("name").getAsString();

        DataManager.ensureHas(jsonObject, "ID");
        String preId = jsonObject.get("ID").getAsString();
        DataManager.ensureCorrect(DataType.LONG, false, false, preId);
        long id = Long.parseLong(preId);

        Position position = null;
        if (jsonObject.has("position")) {
            DataManager.ensureCorrect(DataType.POSITION, true, false, jsonObject.get("position").getAsString());
            if (!jsonObject.get("position").getAsString().isBlank()) {
                position = Position.valueOf(jsonObject.get("position").getAsString().toUpperCase());
            }
        }

        Status status = null;
        if (jsonObject.has("status")) {
            DataManager.ensureCorrect(DataType.STATUS, true, false, jsonObject.get("status").getAsString());
            if (!jsonObject.get("status").getAsString().isBlank()) {
                status = Status.valueOf(jsonObject.get("status").getAsString().toUpperCase());
            }
        }

        DataManager.ensureHas(jsonObject, "salary");
        String preSalary = jsonObject.get("salary").getAsString();
        DataManager.ensureCorrect(DataType.INT, false, true, preSalary);
        int salary = Integer.parseInt(preSalary);

        DataManager.ensureHas(jsonObject, "creation_date");
        String preCreationDate = jsonObject.get("creation_date").getAsString();
        DataManager.ensureCorrect(DataType.DATE, false, false, preCreationDate);
        LocalDate creationDate = LocalDate.parse(preCreationDate);

        DataManager.ensureHas(jsonObject, "start_date");
        String preStartDate = jsonObject.get("start_date").getAsString();
        DataManager.ensureCorrect(DataType.DATE, false, false, preStartDate);
        LocalDate startDate = LocalDate.parse(preStartDate);
        if (creationDate.compareTo(startDate) > 0) {
            throw new IncorrectWorkerFieldException();
        }

        DataManager.ensureHas(jsonObject, "coordinates");
        Coordinates coordinates = context.deserialize(jsonObject.get("coordinates"), Coordinates.class);

        Organization organization = null;
        if (jsonObject.has("organization")) {
            organization = context.deserialize(jsonObject.get("organization"), Organization.class);
        }

        return new Worker(id, name, coordinates, creationDate, salary, startDate, position, status, organization);
    }
}
