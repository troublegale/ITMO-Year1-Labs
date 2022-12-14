package furniture;

import persons.Julio;
import persons.Sproots;
import enums.mood;

public class Furnace extends Furniture implements Stokable {

    private boolean stoked;

    public void setStoked(boolean stoked) {
        this.stoked = stoked;
    }

    public boolean isStoked() {
        return this.stoked;
    }

    public Furnace() {
        super("обычный");
        System.out.println("Есть обычная печка.");
    }

    public Furnace(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " печка.");
    }

    @Override
    public void stoke(Julio julio, Sproots sproots) {
        if (sproots.getWill().equals(mood.WANNAWORK)) {
            System.out.println(sproots.getName() + " и " + julio.getName() +
                    " затопили печку. Сегодня будет тепло!");
            this.setStoked(true);
        } else {
            System.out.println("Сегодня печку топить не стали... Всем было лень.");
            this.setStoked(false);
        }
    }

    @Override
    public void stoke(Sproots sproots) {
        if (sproots.getWill().equals(mood.WANNAWORK)) {
            System.out.println(sproots.getName() + " затопил печку. Сегодня будет тепло!");
            this.setStoked(true);
        } else {
            System.out.println("Сегодня " + sproots.getName() +
                    " не стал топить печку... Ему было лень.");
        }
    }
}
