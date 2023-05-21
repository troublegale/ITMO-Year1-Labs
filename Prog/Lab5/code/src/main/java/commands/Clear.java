package commands;

import managers.CollectionManager;
import utilities.DataLimitations;

/**
 * The Clear class represents a command that clears the WorkerMap collection.
 * Implements the {@link Command} interface.
 */
public class Clear implements Command {
    CollectionManager colMan;

    /**
     * Constructs a Clear object with a specified ColMan object.
     *
     * @param colMan the ColMan object used to manage the collection
     */
    public Clear(CollectionManager colMan) {
        this.colMan = colMan;
    }

    /**
     * Executes the clear command by clearing the WorkerMap collection.
     * If the collection is already empty, a message is printed to indicate so.
     */
    @Override
    public void execute(String arg) {
        if (colMan.getWorkerMap().isEmpty()) {
            System.out.println("This collection is already empty.\n");
            return;
        }
        colMan.getWorkerMap().clear();
        System.out.println("Collection has been cleared.\n");
    }

    /**
     * @return the name of this command
     */
    @Override
    public String name() {
        return "clear";
    }

    /**
     * @return the argument string for the command
     */
    @Override
    public String argDesc() {
        return "";
    }

    /**
     * @return a description of this command
     */
    @Override
    public String desc() {
        return "clear the collection";
    }

    /**
     * @return an array of DataLimitations objects
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations().limitations();
    }
}