package attacks.statusMoves;

import ru.ifmo.se.pokemon.*;

public class Roost extends StatusMove {

    public Roost() {
        super();
    }

    @Override
    protected String describe() {
        return "гнездится";
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, -(int)(p.getStat(Stat.HP) / 2.0));
    }

}
