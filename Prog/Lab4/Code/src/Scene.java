import enums.*;
import exceptions.OutOfFoodException;
import furniture.*;
import persons.*;

import java.util.Scanner;

public class Scene {

    private static int foodCount;

    static {
        foodCount = (int) Math.floor(Math.random() * 3);
    }

    public static void setFoodCount(int food) {
        foodCount = food;
    }

    public static int getFoodCount() {
        return foodCount;
    }

    public static Object[] initStuff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбрать своих героев? (Да/Нет)");
        Sproots sproots;
        Julio julio;
        while (true) {
            String answer1 = scanner.nextLine();
            if (answer1.toLowerCase().equals("да")) {
                System.out.println("Кто в роли Жулио?");
                String jName = scanner.nextLine();
                System.out.println("Он уже придумал спать в сундуках? (Да/Нет)");
                while (true) {
                    String answer12 = scanner.nextLine();
                    if (answer12.toLowerCase().equals("да")) {
                        julio = new Julio(jName, true);
                        break;
                    } else if (answer12.toLowerCase().equals("нет")) {
                        julio = new Julio(jName);
                        break;
                    } else {
                        System.out.println("Пожалуйста, ответьте корректно.");
                    }
                }
                System.out.println("Кто в роли Спрутса?");
                String sName = scanner.nextLine();
                sproots = new Sproots(sName);
                break;
            } else if (answer1.toLowerCase().equals("нет")) {
                julio = new Julio();
                sproots = new Sproots();
                break;
            } else {
                System.out.println("Пожалуйста, ответьте корректно.");
            }
        }
        System.out.println("Описать мебель? (Да/Нет)");
        TV tv;
        Furnace furnace;
        Beds beds;
        Chests chests;
        while (true) {
            String answer2 = scanner.nextLine();
            if (answer2.toLowerCase().equals("да")) {
                System.out.println("Какие в доме сундуки?");
                chests = new Chests(scanner.nextLine().toLowerCase());
                System.out.println("Какие в доме кровати?");
                beds = new Beds(scanner.nextLine().toLowerCase());
                System.out.println("Какая в доме печка?");
                furnace = new Furnace(scanner.nextLine().toLowerCase());
                System.out.println("Какой в доме телевизор?");
                tv = new TV(scanner.nextLine().toLowerCase());
                break;
            } else if (answer2.toLowerCase().equals("нет")) {
                chests = new Chests();
                beds = new Beds();
                furnace = new Furnace();
                tv = new TV();
                break;
            } else {
                System.out.println("Пожалуйста, ответьте корректно.");
            }
        }
        return new Object[] {julio, sproots, chests, beds, furnace, tv};
    }

    private static boolean askJulio(Julio julio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Будет житься лучше, если " + julio.getName() + " подселиться. Пригласить его? (Да/Нет)");
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("да")) {
                return true;
            } else if (answer.equalsIgnoreCase("нет")) {
                return false;
            } else {
                System.out.println("Пожалуйста, ответьте корректно.");
            }
        }
    }

    private static void cook(Sproots sproots) throws OutOfFoodException {

        while (true) {
            if (getFoodCount() == 0) {
                throw new OutOfFoodException();
            } else {
                System.out.println(sproots.getName() + " пытается приготовить еду...");
                if (Math.random() >= 0.5) {
                    System.out.println(sproots.getAgility() + " " + sproots.getName() + " испортил продукты!");
                    setFoodCount(getFoodCount() - 1);
                } else {
                    System.out.println(sproots.getName() +
                            " приготовил еду посредственного качества и оттрапезничал.");
                    setFoodCount(getFoodCount() - 1);
                    break;
                }
            }
        }
    }

    private static void cook(Sproots sproots, Julio julio) throws OutOfFoodException {

        if (getFoodCount() == 0) {
            throw new OutOfFoodException();
        } else {
            System.out.println(julio.getName() + " и " + sproots.getName() + " вместе готовят еду.");
            System.out.println(julio.getName() + " и " + sproots.getName() +
                    " совместными усилиями приготовили вкуснейшую еду и с удовольствием оттрапезничали.");
            setFoodCount(getFoodCount() - 1);
        }

    }

    private static void goBuyFood(Sproots sproots) {
        System.out.println("Делать нечего, " + sproots.getName() + " пошёл за продуктами.");
        setFoodCount(1 + (int) Math.floor(Math.random() * 5));
        System.out.println(sproots.getName() + " вернулся домой с продуктами.");
    }

    private static void goBuyFood(Julio julio) {
        System.out.println("Ничего, " + julio.getName() + " сходит за продуктами.");
        setFoodCount(1 + (int) Math.floor(Math.random() * 5));
        System.out.println(julio.getName() + " вернулся домой с продуктами.");
    }

    private static void routine(Sproots sproots, Beds beds, Furnace furnace) {
        System.out.println(sproots.getName() + " пока живёт один.");
        Person.tellTemperature();
        beds.setHasMattress(true);

        if (Math.random() >= 0.5) {
            sproots.setWill(mood.LAZY);
        } else {
            sproots.setWill(mood.WANNAWORK);
        }

        while (true) {
            try {
                cook(sproots);
                break;
            } catch (OutOfFoodException e) {
                System.out.println("Продукты кончились!");
                goBuyFood(sproots);
            }
        }

        furnace.stoke(sproots);
    }

    private static void routine(Julio julio, Sproots sproots, Beds beds, Furnace furnace) {
        Person.tellTemperature();
        beds.setHasMattress(true);

        if (Math.random() >= 0.5) {
            sproots.setWill(mood.LAZY);
        } else {
            sproots.setWill(mood.WANNAWORK);
        }

        while (true) {
            try {
                cook(sproots, julio);
                break;
            } catch (OutOfFoodException e) {
                System.out.println("Продукты кончились!");
                goBuyFood(julio);
            }
        }

        julio.clean();
        julio.think();

        if (!julio.isInventedSleepingInChests()) {
            furnace.stoke(sproots);
        } else {
            System.out.println("Печку можно не топить, ведь " + julio.getName() + " придумал спать в сундуках!");
        }
    }

    private static void sleep(Sproots sproots, Beds beds, Furnace furnace) {
        System.out.println("Настало время ложиться спать.");
        beds.fallAsleepOn(sproots);
        if (!furnace.isStoked()) {
            Person.setTemperature(feeling.COLD);
        }
    }

    private static void sleep(Julio julio, Sproots sproots, Chests chests, Beds beds, Furnace furnace) {
        System.out.println("Настало время ложиться спать.");
        if (!julio.isInventedSleepingInChests()) {
            beds.fallAsleepOn(sproots, julio);
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
            sproots.breathe();
            chests.fallAsleepOn(sproots, julio);
        }
    }

    public static void live(Object[] stuff) {
        Julio julio = (Julio) stuff[0];
        Sproots sproots = (Sproots) stuff[1];
        Chests chests = (Chests) stuff[2];
        Beds beds = (Beds) stuff[3];
        Furnace furnace = (Furnace) stuff[4];
        TV tv = (TV) stuff[5];
        while (true) {
            System.out.println("\nНачался новый день.");
            if (!julio.isLivesWithSproots() && askJulio(julio)) {
                julio.setLivesWithSproots(true);
                System.out.println(julio.getName() + " и " + sproots.getName() + " теперь живут вместе.");
            }
            if (julio.isLivesWithSproots()) {
                routine(julio, sproots, beds, furnace);
                tv.watch(sproots, julio);
                if (tv.isWatchedChannelThreeTogether()) {
                    System.out.println("С тревожными мыслями о своих врагах " + sproots.getName() +
                            " и " + julio.getName() + " доделали оставшиеся дела.");
                    sleep(julio, sproots, chests, beds, furnace);
                    System.out.println("Ночью им обоим снились коротышки...");
                    System.out.println("\nНа этом всё!");
                    break;
                }
                sleep(julio, sproots, chests, beds, furnace);

            } else {
                routine(sproots, beds, furnace);
                tv.watch(sproots);
                sleep(sproots, beds, furnace);
            }
        }
    }

}
