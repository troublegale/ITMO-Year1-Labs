package furniture;

import persons.Julio;
import persons.Sproots;

public class Beds extends Furniture implements SleepableOn {

    private boolean hasMattress;

    {
        this.hasMattress = true;
    }

    private static class Mattresses {
        public static void putInsideChests() {
            System.out.println("Перины с кроватей положили в сундуки.");
        }
        public static void returnOnBeds() {
            System.out.println("Перины вернули на кровати.");
        }
    }

    public void setHasMattress(boolean hasMattress) {
        if (hasMattress & !this.hasMattress) {
            Mattresses.returnOnBeds();
        } else if (!hasMattress){
            Mattresses.putInsideChests();
        }
        this.hasMattress = hasMattress;
    }

    public boolean isHasMattress() {
        return this.hasMattress;
    }

    public Beds() {
        super("удобные");
        System.out.println("Есть удобные кровати.");
    }

    public Beds(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " кровати.");
    }

    @Override
    public void fallAsleepOn(Sproots sproots) {
        System.out.println(sproots.getName() +  " засыпает в своей кровати. Спокойной ночи!");
    }

    @Override
    public void fallAsleepOn(Sproots sproots, Julio julio) {
        System.out.println("Все засыпают в своих кроватях. Спокойной ночи!");
    }

}
