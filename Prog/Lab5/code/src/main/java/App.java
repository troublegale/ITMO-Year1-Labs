import com.google.gson.JsonParseException;
import exceptions.*;
import managers.*;
import workerRelated.Worker;

import java.io.File;
import java.time.LocalDate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The main class of the worker management application.
 * This class initializes the application and handles exceptions that may occur during the initialization process.
 */
public class App {
    /**
     * The main method of the application.
     * It reads the file path from the "workers" environmental variable, initializes the file manager, and reads workers from the file.
     * After that, it prepares the necessary managers and starts the user interaction.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {

        String fileName = System.getenv("workers");
        if (fileName != null) {
            FileManager fileMan = new FileManager(fileName);
            try {
                if (!new File(fileName).createNewFile()) {
                    HashMap<Long, Worker> workerMap = fileMan.readWorkersFromFile();
                    prepareAndStart(fileMan, workerMap);
                } else {
                    prepareAndStart(fileMan, new HashMap<>());
                }
            } catch (IOException e) {
                System.out.println("Can't read the source file. Make sure that the environmental variable 'workers' stores a proper path to an existent file.");
            } catch (SameIDException e) {
                System.out.println("The source file contains two or more workers with the same ID. ID has to be unique.");
            } catch (JsonParseException e) {
                System.out.println("Failed to read the source file: content doesn't meet json standards.");
            } catch (IncorrectWorkerFieldException e) {
                System.out.println("The source file's worker representation is incorrect.");
            } catch (NullPointerException e) {
                prepareAndStart(fileMan, new HashMap<>());
            }
        } else {
            System.out.println("Can't read the source file. Environmental variable 'workers' is null.");
        }
    }

    private static void prepareAndStart(FileManager fileMan, HashMap<Long, Worker> workerMap) {
        CollectionManager colMan = new CollectionManager(workerMap, LocalDate.now().toString());
        CommandManager comMan = new CommandManager(colMan, fileMan, true);
        UserInteractionManager uiMan = new UserInteractionManager(comMan);
        UserInteractionManager.setSource(new Scanner(System.in), comMan.getMode());
        try {
            uiMan.interact();
        } catch (InputEndException | ScriptEndException | ExitException e) {
            System.out.println("Any changes after the last save will be discarded.");
            System.out.println("Shutting down...");
        }
    }

}
