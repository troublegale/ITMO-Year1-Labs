package commands;

import managers.CollectionManager;
import managers.FileManager;
import utilities.DataLimitations;

import java.io.IOException;

/**
 * A command to save the current state of the collection to a file.
 * Implements the {@link Command} interface.
 */
public class Save implements Command {
    CollectionManager colMan;
    FileManager fileMan;
    /**
     * Constructor for the Save command.
     *
     * @param colMan the collection manager object
     * @param fileMan the file manager object
     */
    public Save(CollectionManager colMan, FileManager fileMan) {
        this.colMan = colMan;
        this.fileMan = fileMan;
    }
    /**
     * Executes the save command, saving the current state of the collection to a file.
     *
     * @param arg the command argument
     */
    @Override
    public void execute(String arg) {
        System.out.println("Saving...");
        try {
            fileMan.writeWorkersToFile(colMan);
            System.out.println("Successfully saved.\n");
        } catch (IOException e) {
            System.out.println("Failed to save to the source file. Make sure that the file is available.\n");
        }
    }
    /**
     * Returns the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String name() {
        return "save";
    }
    /**
     * Returns the argument format for the command.
     *
     * @return the argument format for the command
     */
    @Override
    public String argDesc() {
        return "";
    }
    /**
     * Returns a description of the command.
     *
     * @return a description of the command
     */
    @Override
    public String desc() {
        return "save the collection to file";
    }
    /**
     * Returns the argument limitations for the command.
     *
     * @return the argument limitations for the command
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations().limitations();
    }
}
