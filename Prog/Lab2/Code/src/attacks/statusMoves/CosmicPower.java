package attacks.statusMoves;

import ru.ifmo.se.pokemon.*;

public class CosmicPower extends StatusMove {

    public CosmicPower() {
        super();
    }

    @Override
    protected String describe() {
        return "черпает космическую силу";
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, 1);
        p.setMod(Stat.SPECIAL_DEFENSE, 1);
    }

}
