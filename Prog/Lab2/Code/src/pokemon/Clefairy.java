package pokemon;

import attacks.specialMoves.Flamethrower;
import attacks.specialMoves.ShadowBall;
import attacks.statusMoves.CosmicPower;
import ru.ifmo.se.pokemon.*;

public class Clefairy extends Cleffa {

    public Clefairy(final String name, final int level) {
        super(name, level);
        setStats(70, 45, 48, 60, 65, 35);
        setType(Type.FAIRY);
        setMove(new Flamethrower(), new ShadowBall(), new CosmicPower());
    }

}
