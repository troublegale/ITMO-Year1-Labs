import enums.feeling;
import enums.mood;
import furniture.Beds;
import furniture.Chests;
import furniture.Furnace;
import persons.Julio;
import persons.Others;
import persons.Person;

public class TimeTo {

    private static void spendADay(Julio julio, Others others, Chests chests, Beds beds, Furnace furnace) {
        System.out.println("\nНачался новый день.");
        Person.tellTemperature();
        beds.setHasMattress(true);

        //others' mood for the current day
        if (Math.random() >= 0.5) {
            others.setWill(mood.LAZY);
        } else {
            others.setWill(mood.WANNAWORK);
        }

        julio.cook();
        julio.clean();
        julio.think();

        if (!julio.isInventedSleepingInChests()) {
            furnace.stoke(others);
        } else {
            System.out.println("Печку можно не топить, ведь " + julio.getName() + " придумал спать в сундуках!");
        }
    }

    private static void sleep(Julio julio, Others others, Chests chests, Beds beds, Furnace furnace) {
        System.out.println("Настало время ложиться спать.");
        if (!julio.isInventedSleepingInChests()) {
            beds.fallAsleepOn();
            if (!furnace.isStoked()) {
                Person.setTemperature(feeling.COLD);
            } else {
                Person.setTemperature(feeling.WARM);
            }
        } else {
            chests.setOpen(true);
            beds.setHasMattress(false);
            chests.setOpen(false);
            julio.breathe();
            others.breathe();
            chests.fallAsleepOn();
        }
    }

    public static void live(Julio julio, Others others, Chests chests, Beds beds, Furnace furnace, int days) {
        if (days > 0) {
            for (int i = 0; i < days; i++) {
                TimeTo.spendADay(julio, others, chests, beds, furnace);
                TimeTo.sleep(julio, others, chests, beds, furnace);
            }
            System.out.println("Хорошо живём!");
        } else {
            System.out.println("\nПожить не дают...");
        }
    }

}
