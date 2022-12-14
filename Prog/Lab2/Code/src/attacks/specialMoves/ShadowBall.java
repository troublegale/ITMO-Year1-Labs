package attacks.specialMoves;

import ru.ifmo.se.pokemon.*;

public class ShadowBall extends SpecialMove {

    public ShadowBall() {
        super(Type.GHOST, 80, 100);
    }

    @Override
    protected String describe() {
        return "запускает теневой сгусток";
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() <= 0.2) {
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

}
