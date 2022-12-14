package pokemon;

import attacks.specialMoves.BugBuzz;
import attacks.specialMoves.Flamethrower;
import attacks.statusMoves.CalmMind;
import ru.ifmo.se.pokemon.*;

public class Larvesta extends Pokemon {
    public Larvesta(final String name, final int level) {
        super(name, level);
        setStats(55, 85, 55, 50, 55, 60);
        setType(Type.BUG, Type.FIRE);
        setMove(new CalmMind(), new Flamethrower(), new BugBuzz());
    }
}
