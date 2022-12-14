package attacks.statusMoves;

import ru.ifmo.se.pokemon.*;
import static ru.ifmo.se.pokemon.Effect.sleep;

public class Sing extends StatusMove {

    public Sing() {
        super();
    }

    @Override
    protected String describe() {
        return "поёт";
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        sleep(p);
    }

}
