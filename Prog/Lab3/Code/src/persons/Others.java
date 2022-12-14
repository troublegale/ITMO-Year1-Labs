package persons;

import enums.feeling;
import enums.mood;

public class Others extends Person {

    private mood will;

    public Others(String name) {
        super(name);
        System.out.println(this.getName() + " в роли \"них\"!");
    }

    public void setWill(mood will) {
        this.will = will;
        if (will.equals(mood.LAZY)) {
            System.out.println("Сегодня всем как-то лениво.");
        } else {
            System.out.println("Сегодня все готовы работать!");
        }
    }

    public mood getWill() {
        return this.will;
    }

    @Override
    public void breathe() {
        System.out.println(this.getName() + " тоже согревались своим дыханием.");
        this.setTemperature(feeling.WARM);
    }
}
