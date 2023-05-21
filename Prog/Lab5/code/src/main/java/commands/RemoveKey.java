package commands;

import managers.CollectionManager;
import managers.UserInteractionManager;
import utilities.DataLimitations;
import utilities.DataType;
import workerRelated.Worker;

/**
 * Command to remove an element with the given key from the collection.
 * Implements the {@link Command} interface.
 */
public class RemoveKey implements Command {
    private final CollectionManager colMan;
    /**
     * Constructs a RemoveKey command object with the given ColMan object.
     *
     * @param colMan the ColMan object to operate on
     */
    public RemoveKey(CollectionManager colMan) {
        this.colMan = colMan;
    }
    /**
     * Executes the RemoveKey command by removing the element with the given key from the collection.
     *
     * @param arg the key of the element to remove from the collection
     */
    @Override
    public void execute(String arg) {
        long key = Long.parseLong(arg);
        for (Worker worker : colMan.getWorkerMap().values()) {
            if (worker.getId() == key) {
                colMan.getWorkerMap().values().remove(worker);
                System.out.println("Collection element with key " + key + " has been successfully deleted.\n");
                return;
            }
        }
        System.out.println("The collection doesn't contain an element with key = " + key + ".\n");
    }
    /**
     * Returns the name of the RemoveKey command.
     *
     * @return the name of the command
     */
    @Override
    public String name() {
        return "remove_key";
    }

    /**
     * Returns the argument syntax of the RemoveKey command.
     *
     * @return the argument syntax of the command
     */
    @Override
    public String argDesc() {
        return "{key(long value)}";
    }
    /**
     * Returns the description of the RemoveKey command.
     *
     * @return the description of the command
     */
    @Override
    public String desc() {
        return "delete an element with the given key from the collection";
    }
    /**
     * Returns the argument limitations of the RemoveKey command.
     *
     * @return the argument limitations of the command
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations(DataType.LONG,
                UserInteractionManager.wrongArgMessage(this) + "Please, use a proper long value.",
                UserInteractionManager.noArgMessage(this)).limitations();
    }
}
