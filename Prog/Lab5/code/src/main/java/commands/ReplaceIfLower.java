package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import managers.UserInteractionManager;
import utilities.DataLimitations;
import utilities.DataType;
import workerRelated.Worker;

/**
 * A command that replaces an element in the collection with the given key if the newly described element is lower
 * than the current one.
 * Implements the {@link Command} interface.
 */
public class ReplaceIfLower implements Command {
    CollectionManager colMan;
    /**
     * Creates a new instance of the ReplaceIfLower command.
     *
     * @param colMan the collection manager that holds the worker collection to be modified
     */
    public ReplaceIfLower(CollectionManager colMan) {
        this.colMan = colMan;
    }
    /**
     * Executes the ReplaceIfLower command by replacing an element in the collection with the given key if the newly
     * described element is lower than the current one.
     *
     * @param arg the argument provided with the command (the key of the element to be replaced)
     */
    @Override
    public void execute(String arg) {
        long key = Long.parseLong(arg);
        if (!colMan.getWorkerMap().containsKey(key)) {
            System.out.println("The collection doesn't contain an element with key = " + key +".\n");
        } else {
            if (UserInteractionManager.getMode()) {
                System.out.println("To cancel the worker description process, use '!e'.");
                System.out.println("Empty input will result in assigning a field to null where it's possible.");
            }
            try {
                Worker worker = UserInteractionManager.createNewWorker(key);
                if (colMan.getWorkerMap().get(key).compareTo(worker) < 0) {
                    colMan.replace(worker);
                    System.out.println();
                } else {
                    System.out.println("Current element under the key = " + key + " is equal to or greater than the given one.\n");
                }
            } catch (ExitException e) {
                System.out.println("The updating process was cancelled.\n");
            }
        }
    }
    /**
     * Returns the name of the ReplaceIfLower command.
     *
     * @return the name of the command
     */
    @Override
    public String name() {
        return "replace_if_lower";
    }
    /**
     * Returns the argument syntax of the ReplaceIfLower command.
     *
     * @return the argument syntax of the command
     */
    @Override
    public String argDesc() {
        return "{key(long value)}";
    }
    /**
     * Returns the description of the ReplaceIfLower command for help command output.
     *
     * @return the description of the command
     */
    @Override
    public String desc() {
        return "replace an element with the given key if the newly described element is lower than the current";
    }
    /**
     * Returns an array of the limitations of the argument of the ReplaceIfLower command.
     *
     * @return an array of the argument limitations of the command
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations(DataType.LONG,
                UserInteractionManager.wrongArgMessage(this) + "Please, use a proper long value.",
                UserInteractionManager.noArgMessage(this)).limitations();
    }
}
