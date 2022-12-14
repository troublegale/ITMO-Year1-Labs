package attacks.specialMoves;

import ru.ifmo.se.pokemon.*;
import java.lang.Math;
import static ru.ifmo.se.pokemon.Effect.burn;

public class Flamethrower extends SpecialMove {

    public Flamethrower() {
        super(Type.FIRE, 90, 100);
    }

    @Override
    protected String describe() {
        return "выпускает поток пламени";
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() <= 0.1) {
            burn(p);
        }
    }

}
