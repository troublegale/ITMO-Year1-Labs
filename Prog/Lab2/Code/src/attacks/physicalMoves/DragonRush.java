package attacks.physicalMoves;

import java.lang.Math;
import ru.ifmo.se.pokemon.*;
import static ru.ifmo.se.pokemon.Effect.flinch;

public class DragonRush extends PhysicalMove {

    public DragonRush() {
        super(Type.DRAGON, 100, 75);
    }

    @Override
    protected String describe() {
        return "разгоняется в драконьей ярости";
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() >= 0.2) {
            flinch(p);
        }
    }

}
