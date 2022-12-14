package furniture;

import persons.Others;
import enums.mood;

public class Furnace extends Furniture implements Stokable {

    private boolean stoked;

    public void setStoked(boolean stoked) {
        this.stoked = stoked;
    }

    public boolean isStoked() {
        return this.stoked;
    }

    public Furnace(String type) {
        super(type);
        System.out.println("Есть " + this.getType() + " печка.");
    }

    @Override
    public void stoke(Others others) {
        if (others.getWill().equals(mood.WANNAWORK)) {
            System.out.println(others.getName() + " затопили печку. Сегодня будет тепло!");
            this.setStoked(true);
        } else {
            System.out.println("Сегодня печку топить не стали... Всем было лень.");
            this.setStoked(false);
        }
    }
}
