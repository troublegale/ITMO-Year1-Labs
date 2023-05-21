package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import managers.UserInteractionManager;
import utilities.DataLimitations;
import utilities.DataType;
import workerRelated.Worker;

/**
 * The {@code Update} class represents the update command used to replace the worker with the given key in the collection
 * with a newly described worker.
 * Implements the {@link Command} interface.
 */
public class Update implements Command {

    CollectionManager colMan;

    /**
     * Constructs a new {@code Update} command with the given collection manager.
     *
     * @param colMan the collection manager to be used
     */

    public Update(CollectionManager colMan) {
        this.colMan = colMan;
    }

    /**
     * Replaces the worker with the given key in the collection with a newly described worker.
     *
     * @param arg the argument for the command
     */
    @Override
    public void execute(String arg) {
        long key = Long.parseLong(arg);
        if (!colMan.getWorkerMap().containsKey(key)) {
            System.out.println("The collection doesn't contain an element with key = " + key + ".\n");
        } else {
            if (UserInteractionManager.getMode()) {
                System.out.println("To cancel the worker description process, use '!e'.");
                System.out.println("To keep the old value of any field, use '!s'.");
                System.out.println("Empty input will result in assigning a field to null where it's possible.");
            }
            try {
                Worker worker = UserInteractionManager.createNewWorker(key);
                colMan.replace(worker);
                System.out.println();
            } catch (ExitException e) {
                System.out.println("The updating process was cancelled.\n");
            }
        }
    }

    /**
     * Returns the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String name() {
        return "update";
    }

    /**
     * Returns the argument format for the command.
     *
     * @return the argument format for the command
     */
    @Override
    public String argDesc() {
        return "{id(long value)}";
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String desc() {
        return "update an element with the given id field value";
    }

    /**
     * @return an array of DataLimitations objects
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations(DataType.LONG,
                UserInteractionManager.wrongArgMessage(this) + "Please, use a proper long value.",
                UserInteractionManager.noArgMessage(this)).limitations();
    }
}
