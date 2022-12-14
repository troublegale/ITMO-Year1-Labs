package furniture;

import persons.Julio;
import persons.Sproots;

public class Chests extends Furniture implements SleepableOn {

    private boolean open = false;

    public void setOpen(boolean open) {
        this.open = open;
        if (open) {
            System.out.println("Сундуки открыли.");
        } else {
            System.out.println("Сундуки закрыли.");
        }
    }

    public boolean isOpen() {
        return this.open;
    }

    public Chests() {
        super("обычные");
        System.out.println("Есть обычные сундуки.");
    }

    public Chests(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " сундуки.");

    }

    @Override
    public void fallAsleepOn(Sproots sproots) {
        System.out.println(sproots.getName() +  "засыпает в сундуке. Откуда он только узнал,"+
                " что так вообще можно делать? Должно быть, кто-то очень умный" +
                " подсказал ему. Что ж, спокойной ночи, " + sproots.getName() + "!");
    }

    @Override
    public void fallAsleepOn(Sproots sproots, Julio julio) {
        System.out.println("Все засыпают в сундуках. Спокойной ночи!");
    }

}
