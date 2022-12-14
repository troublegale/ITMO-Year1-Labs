import ru.ifmo.se.pokemon.*;
import pokemon.*;

public class Main {
    public static void main(String args[]) {

        Clefable clefable = new Clefable("Олег", 10);
        Clefairy clefairy = new Clefairy("Обалдуй", 10);
        Cleffa cleffa = new Cleffa("Буба", 10);
        Dhelmise dhelmise = new Dhelmise("Хулиган", 10);
        Larvesta larvesta = new Larvesta("Грызлик", 10);
        Volcarona volcarona = new Volcarona("Бабокач", 10);

        Battle battle = new Battle();
        battle.addAlly(volcarona);
        battle.addAlly(dhelmise);
        battle.addAlly(cleffa);
        battle.addFoe(clefable);
        battle.addFoe(clefairy);
        battle.addFoe(larvesta);

        battle.go();

    }
}
