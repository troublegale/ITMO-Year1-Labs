package me.lab6.server.commands;

import me.lab6.common.network.Response;
import me.lab6.common.workerRelated.Position;
import me.lab6.common.workerRelated.Worker;
import me.lab6.server.managers.CollectionManager;

import java.util.List;

public class CountByPosition implements Command {
    CollectionManager collectionManager;

    /**
     * Constructs a new CountByPosition command with the given ColMan object.
     *
     * @param collectionManager the ColMan object to use for the command
     */
    public CountByPosition(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command with the given argument.
     *
     * @param arg the Position value to count
     */
    @Override
    public Response execute(Object arg) {
        String argStr = (String) arg;
        Position position = Position.valueOf(argStr.toUpperCase());
        List<Worker> filtered = collectionManager.workerMap().values()
                .stream().filter(w -> w.getPosition() == position).toList();
        if (filtered.size() == 0) {
            return new Response("The collection doesn't contain elements with such position value.\n");
        } else {
            return new Response("The collection contains " + filtered.size() + " element(s) with position = " + position + ".\n");
        }
    }

    /**
     * Returns the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String name() {
        return "count_by_position";
    }

    /**
     * Returns the argument string for use in a help message.
     *
     * @return the argument string for the command
     */
    @Override
    public String argDesc() {
        return "{Position ( " + Position.allPositions() + ")}";
    }

    /**
     * Returns the description of the command for use in a help message.
     *
     * @return the description of the command
     */
    @Override
    public String desc() {
        return "print out the number of elements with Position field value equal to given";
    }


}
