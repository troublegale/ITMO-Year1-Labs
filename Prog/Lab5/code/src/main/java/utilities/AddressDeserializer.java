package utilities;

import com.google.gson.*;
import exceptions.IncorrectWorkerFieldException;
import managers.DataManager;
import workerRelated.Address;

import java.lang.reflect.Type;

/**
 * A deserializer for the Address class, used to convert JSON data into Address objects.
 */
public class AddressDeserializer implements JsonDeserializer<Address> {
    /**
     * Deserializes a JsonElement into an Address object.
     *
     * @param json    the JsonElement to deserialize.
     * @param typeOfT the type of the JsonElement.
     * @param context the context in which the deserialization is happening.
     * @return an Address object representing the deserialized JSON data.
     * @throws JsonParseException if the JsonElement cannot be deserialized.
     */
    @Override
    public Address deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        DataManager.ensureHas(jsonObject, "zipCode");
        if (jsonObject.get("zipCode").getAsString().isBlank()) {
            throw new IncorrectWorkerFieldException();
        }
        String zipCode = jsonObject.get("zipCode").getAsString();

        String street = null;
        if (jsonObject.has("street")) {
            if (!jsonObject.get("street").getAsString().isBlank()) {
                street = jsonObject.get("street").getAsString();
            }
        }

        return new Address(zipCode, street);
    }
}
