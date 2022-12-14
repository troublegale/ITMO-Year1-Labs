package attacks.physicalMoves;

import ru.ifmo.se.pokemon.*;

public class ShadowClaw extends PhysicalMove {

    public ShadowClaw() {
        super(Type.GHOST, 70, 100);
    }

    @Override
    protected String describe() {
        return "раздирает врага из тени";
    }
    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        if (att.getStat(Stat.SPEED) / 512.0 * 3 > Math.random()) {
            System.out.println("Критический удар!");
            return 2.0;
        } else {
            return 1.0;
        }
    }

}
