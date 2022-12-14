package pokemon;

import attacks.specialMoves.Flamethrower;
import attacks.specialMoves.ShadowBall;
import ru.ifmo.se.pokemon.*;

public class Cleffa extends Pokemon {

    public Cleffa (final String name, final int level) {
        super(name, level);
        setStats(50, 25, 28, 45, 55, 15);
        setType(Type.FAIRY);
        setMove(new Flamethrower(), new ShadowBall());
    }

}
