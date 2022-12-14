package pokemon;

import attacks.specialMoves.Flamethrower;
import attacks.specialMoves.ShadowBall;
import attacks.statusMoves.CosmicPower;
import attacks.statusMoves.Sing;
import ru.ifmo.se.pokemon.*;

public class Clefable extends Clefairy {

    public Clefable(final String name, final int level) {
        super(name, level);
        setStats(95, 70, 73, 95, 90, 60);
        setType(Type.FAIRY);
        setMove(new Flamethrower(), new ShadowBall(), new CosmicPower(), new Sing());
    }
}
