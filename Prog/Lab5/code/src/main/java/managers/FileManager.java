package managers;

import com.google.gson.*;
import exceptions.SameIDException;
import utilities.*;
import workerRelated.Address;
import workerRelated.Coordinates;
import workerRelated.Organization;
import workerRelated.Worker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * The FileMan class is responsible for reading and writing data from and to a file.
 */
public class FileManager {
    private final String filePath;

    /**
     * Constructor for the FileMan class.
     * @param filePath the filepath string
     */
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads worker data from a file and returns a hashmap of the workers.
     *
     * @return a hashmap of the workers.
     * @throws SameIDException if two or more workers have the same ID.
     * @throws IOException     if there is an error reading from the file.
     */
    public HashMap<Long, Worker> readWorkersFromFile() throws SameIDException, IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] data = inputStream.readAllBytes();
        String jsonString = new String(data, StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Address.class, new AddressDeserializer())
                .registerTypeAdapter(Organization.class, new OrganizationDeserializer())
                .registerTypeAdapter(Coordinates.class, new CoordinatesDeserializer())
                .registerTypeAdapter(Worker.class, new WorkerDeserializer())
                .registerTypeAdapter(Worker[].class, new WorkerMapDeserializer())
                .create();
        JsonArray jsonArr = gson.fromJson(jsonString, JsonArray.class);
        int iter = jsonArr.size();
        Worker[] workers = new Worker[iter];
        for (JsonElement json : jsonArr.asList()) {
            iter--;
            workers[iter] = gson.fromJson(json, Worker.class);
        }
        HashMap<Long, Worker> workerMap = new HashMap<>();
        for (Worker w : workers) {
            if (workerMap.containsKey(w.getId())) {
                throw new SameIDException();
            }
            workerMap.put(w.getId(), w);
        }
        return workerMap;
    }

    /**
     * Writes worker data to a file.
     *
     * @param colMan the collection manager object containing the workers to be written to the file.
     * @throws IOException if there is an error writing to the file.
     */
    public void writeWorkersToFile(CollectionManager colMan) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(Address.class, new AddressSerializer())
                .registerTypeAdapter(Organization.class, new OrganizationSerializer())
                .registerTypeAdapter(Coordinates.class, new CoordinatesSerializer())
                .registerTypeAdapter(Worker.class, new WorkerSerializer())
                .registerTypeAdapter(Worker[].class, new WorkerMapSerializer())
                .create();
        String jsonString = gson.toJson(colMan.getWorkerMap().values().toArray());
        if (jsonString.isBlank()) {
            writer.write("");
        } else {
            writer.write(jsonString);
        }
        writer.flush();
        writer.close();
    }
}
