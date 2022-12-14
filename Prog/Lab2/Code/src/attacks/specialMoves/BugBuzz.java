package attacks.specialMoves;

import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class BugBuzz extends SpecialMove {

    public BugBuzz() {
        super(Type.BUG, 90, 100);
    }

    @Override
    protected String describe() {
        return "жужжит по-жучьи";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() <= 0.1) {
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

}
