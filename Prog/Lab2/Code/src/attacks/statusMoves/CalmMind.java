package attacks.statusMoves;

import ru.ifmo.se.pokemon.*;

public class CalmMind extends StatusMove {

    public CalmMind() {
        super();
    }

    @Override
    protected String describe() {
        return "очищает рассудок";
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, 1);
        p.setMod(Stat.SPECIAL_DEFENSE, 1);
    }

}
