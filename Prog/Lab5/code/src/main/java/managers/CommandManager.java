package managers;

import commands.*;
import exceptions.ExitException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The ComMan class represents a command manager that handles the user input commands
 * and executes the corresponding actions.
 */
public class CommandManager {
    private final Map<String, Command> commandMap;
    private final ArrayList<String> keyList;
    private final ArrayList<String> history;
    private final boolean mode;

    {
        history = new ArrayList<>();
    }

    /**
     * Constructs a ComMan object with the specified column and file managers, and interactive mode flag.
     *
     * @param colMan  The Column Manager object.
     * @param fileMan The File Manager object.
     * @param mode    The interactive mode flag.
     */
    public CommandManager(CollectionManager colMan, FileManager fileMan, boolean mode) {
        this.mode = mode;
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("info", new Info(colMan));
        commandMap.put("show", new Show(colMan));
        commandMap.put("insert", new Insert(colMan));
        commandMap.put("update", new Update(colMan));
        commandMap.put("remove_key", new RemoveKey(colMan));
        commandMap.put("clear", new Clear(colMan));
        commandMap.put("save", new Save(colMan, fileMan));
        commandMap.put("execute_script", new ExecuteScript(colMan, fileMan));
        commandMap.put("exit", new Exit());
        commandMap.put("history", new History(history));
        commandMap.put("replace_if_lower", new ReplaceIfLower(colMan));
        commandMap.put("remove_lower_key", new RemoveLowerKey(colMan));
        commandMap.put("min_by_status", new MinByStatus(colMan));
        commandMap.put("count_by_position", new CountByPosition(colMan));
        commandMap.put("filter_greater_than_organization", new FilterGreaterThanOrganization(colMan));
        commandMap.put("help", new Help(new ArrayList<>(commandMap.values())));
        this.commandMap = commandMap;
        this.keyList = new ArrayList<>(commandMap.keySet());
    }

    /**
     * Returns the mode flag.
     *
     * @return The mode flag.
     */
    public boolean getMode() {
        return mode;
    }

    /**
     * Returns the map that holds the available commands and their corresponding objects.
     *
     * @return The map that holds the available commands and their corresponding objects.
     */
    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    /**
     * Checks if the specified string matches any available command key.
     *
     * @param string The string to check.
     * @return True if the string matches a command key, false otherwise.
     */
    public boolean hasCommand(String string) {
        return keyList.contains(string);
    }

    /**
     * Executes the specified command object with the given argument, and adds the command to the history list.
     * If the history list size exceeds 6 elements, the oldest element is removed.
     *
     * @param command The command object to execute.
     * @param arg     The argument string for the command.
     * @throws ExitException If the command is the exit command and an exception is thrown during
     */


    public void handleCommand(Command command, String arg) throws ExitException {
        command.execute(arg);
        history.add(command.name());
        if (history.size() > 6) {
            history.remove(0);
        }
    }

}
