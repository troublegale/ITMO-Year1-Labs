package commands;

import managers.CollectionManager;
import utilities.DataLimitations;
import workerRelated.Status;
import workerRelated.Worker;

/**
 * A command to print out all elements with the lowest status value in the collection.
 * Implements the {@link Command} interface.
 */
public class MinByStatus implements Command {
    CollectionManager colMan;

    /**
     * Constructs a MinByStatus command object with a given collection manager.
     *
     * @param colMan the collection manager that contains the collection to be searched
     */
    public MinByStatus(CollectionManager colMan) {
        this.colMan = colMan;
    }

    /**
     * Executes the MinByStatus command by printing out all elements with the lowest status value.
     *
     * @param arg a string argument that is not used in this command
     */
    @Override
    public void execute(String arg) {
        System.out.println("Minimal status is " + Status.minStatus() + ".");
        int count = 0;
        for (Worker w : colMan.getWorkerMap().values()) {
            if (w.getStatus() == Status.FIRED) {
                System.out.println(w + "\n");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The collection doesn't contain elements with the minimal status value.\n");
        }

    }
    /**
     * Returns the name of the MinByStatus command.
     * @return the name of the command as a string
     */
    @Override
    public String name() {
        return "min_by_status";
    }
    /**
     * Returns the string representation of the command argument for help.
     * @return an empty string since this command doesn't take any arguments
     */
    @Override
    public String argDesc() {
        return "";
    }
    /**
     * Returns the description of the MinByStatus command for help.
     * @return the description of the command as a string
     */
    @Override
    public String desc() {
        return "print out all elements with the lowest status value";
    }
    /**
     * Returns the description of the MinByStatus command for help.
     * @return the description of the command as a string
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations().limitations();
    }
}
