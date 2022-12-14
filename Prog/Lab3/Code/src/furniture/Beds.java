package furniture;

public class Beds extends Furniture implements SleepableOn {

    private boolean hasMattress = true;

    public void setHasMattress(boolean hasMattress) {
        if (hasMattress & !this.hasMattress) {
            System.out.println("Перины вернули на кровати.");
        } else if (!hasMattress){
            System.out.println("Перины с кроватей положили в сундуки.");
        }
        this.hasMattress = hasMattress;
    }

    public boolean isHasMattress() {
        return this.hasMattress;
    }

    public Beds(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " кровати.");
    }

    @Override
    public void fallAsleepOn() {
        System.out.println("Все засыпают в своих кроватях. Спокойной ночи!\n");
    }



}
