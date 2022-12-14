package pokemon;

import ru.ifmo.se.pokemon.*;
import attacks.physicalMoves.*;
import attacks.specialMoves.*;

public class Dhelmise extends Pokemon {

    public Dhelmise(final String name, final int level) {
        super(name, level);
        setStats(70, 131, 100, 86, 90, 40);
        setType(Type.GHOST, Type.GRASS);
        setMove(new ShadowClaw(), new DracoMeteor(), new DragonRush(), new FireBlast());
    }

}
