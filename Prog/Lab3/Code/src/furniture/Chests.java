package furniture;

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

    public Chests(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " сундуки.");

    }

    @Override
    public void fallAsleepOn() {
        System.out.println("Все засыпают в сундуках. Спокойной ночи!\n");
    }

}
