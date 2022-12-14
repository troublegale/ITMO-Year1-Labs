package pokemon;

import attacks.specialMoves.BugBuzz;
import attacks.specialMoves.Flamethrower;
import attacks.statusMoves.*;
import ru.ifmo.se.pokemon.*;

public class Volcarona extends Larvesta {
    public Volcarona(final String name, final int level) {
        super(name, level);
        setStats(85, 60, 65, 135, 105, 100);
        setType(Type.BUG, Type.FIRE);
        setMove(new CalmMind(), new Flamethrower(), new BugBuzz(), new Roost());
    }



}
