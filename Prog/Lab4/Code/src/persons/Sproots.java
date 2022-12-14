package persons;

import enums.feeling;
import enums.mood;

public class Sproots extends Person {

    private static final String agility = "Неуклюжий";
    private mood will;

    private class Flex {
        public static String getAgility() {
            return agility;
        }
    }

    public String getAgility() {
        return Flex.getAgility();
    }

    public void setWill(mood will) {
        this.will = will;
    }

    public mood getWill() {
        return this.will;
    }

    public Sproots() {
        super("Спрутс");
        System.out.println("Приветствуйте Спрутса!");
    }

    public Sproots(String name) {
        super(name);
        System.out.println(this.getName() + " в роли Спрутса!");
    }

    @Override
    public void breathe() {
        System.out.println(this.getName() + " тоже согревался своим дыханием.");
        setTemperature(feeling.WARM);
    }
}
