package me.lab6.common.utility;

public class Messages {

    public static String hello() {
        return """
                ------------------------------------------------------------------------
                 Welcome to WorkerManager CS Edition! Please, start typing in commands.
                       Use 'help' to see the information about available commands.
                ------------------------------------------------------------------------""";
    }

    public static String goodbye() {
        return "Ending session.\nGoodbye!";
    }

    public static String wrongType(String commandName, String requiredType) {
        return "Wrong argument type for command '" + commandName +
                "'. " + requiredType + " required.\n";
    }

    public static String noInput(String commandName, String requiredType) {
        return "Command '" + commandName + "' requires an argument (" + requiredType + ").\n";
    }

    public static String serverCommunicationError() {
        return "Server did not respond. Command wasn't executed.\n";
    }

    public static String saved() {
        return "The collection was successfully saved to " + System.getenv("workers") + ".\n";
    }

    public static String failedToSave() {
        return "Failed to save the collection to" + System.getenv("workers") + ".\n";
    }

    public static String serverGoodbye() {
        return "Shutting down.\nGoodbye!";
    }

    public static String invalidScript() {
        return "Given script or some of the nested scripts is invalid (incorrect commands, element attributes, etc.).\n";
    }

    public static String fileNotFound() {
        return "File with the given name or some of the nested script files do not exist or can't be accessed.\n";
    }

    public static String scriptRecursion() {
        return "Recursion detected, the script can't be executed.\n";
    }

    public static String tryingAgain() {
        return "Failed to communicate with server. Trying again...\n";
    }
}
