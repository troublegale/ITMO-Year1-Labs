package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import managers.UserInteractionManager;
import utilities.DataLimitations;
import workerRelated.Organization;
import workerRelated.Worker;

/**
 * Represents a command to print out elements from the worker collection with an organization value greater than a given organization.
 * Implements the {@link Command} interface.
 */
public class FilterGreaterThanOrganization implements Command {
    CollectionManager colMan;
    /**
     * Constructs a new {@code FilterGreaterThanOrganization} command with the specified collection manager.
     *
     * @param colMan the collection manager to be used for executing the command
     */
    public FilterGreaterThanOrganization(CollectionManager colMan) {
        this.colMan = colMan;
    }
    /**
     * Prints out elements from the worker collection with an organization value greater than a given organization.
     * If there are no elements that match the criteria, prints out a message indicating that the collection does not contain such elements.
     * Prompts the user to enter the details of the target organization.
     *
     * @param arg the arguments for the command (not used in this command)
     */
    @Override
    public void execute(String arg) {
        if (UserInteractionManager.getMode()) {
            System.out.println("To cancel the organization description process, use '!e'.");
            System.out.println("Target organization:");
        }
        try {
            Organization organization = UserInteractionManager.createNewOrganization();
            System.out.println();
            int count = 0;
            for (Worker w : colMan.getWorkerMap().values()) {
                if (w.getOrganization().compareTo(organization) > 0) {
                    System.out.println(w + "\n");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("The collection doesn't contain elements with organization value greater than given.\n");
            }
        } catch (ExitException e) {
            System.out.println("Description was canceled.\n");
        }
    }
    /**
     * Returns the name of the command as a string ("filter_greater_than_organization").
     *
     * @return the name of the command as a string
     */
    @Override
    public String name() {
        return "filter_greater_than_organization";
    }
    /**
     * Returns the argument string for the command (empty string in this case).
     *
     * @return the argument string for the command
     */
    @Override
    public String argDesc() {
        return "";
    }
    /**
     * Returns a string description of the command ("print out elements with Organization value greater than given").
     *
     * @return a string description of the command
     */
    @Override
    public String desc() {
        return "print out elements with Organization value greater than given";
    }
    /**
     * Returns the argument limitations for the command (no limitations in this case).
     *
     * @return the argument limitations for the command
     */
    @Override
    public Object[] argLimitations() {
        return new DataLimitations().limitations();
    }
}
