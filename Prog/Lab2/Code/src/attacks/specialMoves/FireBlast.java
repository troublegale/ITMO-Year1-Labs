package attacks.specialMoves;

import ru.ifmo.se.pokemon.*;
import static ru.ifmo.se.pokemon.Effect.burn;

public class FireBlast extends SpecialMove {

    public FireBlast() {
        super(Type.FIRE, 110, 85);
    }

    @Override
    protected String describe() {
        return "запускает огненный залп";
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        burn(p);
    }

}
