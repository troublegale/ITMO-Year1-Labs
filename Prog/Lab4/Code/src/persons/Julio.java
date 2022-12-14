package persons;

import enums.feeling;

public class Julio extends Person implements Cleaning, Thinking {

    private boolean inventedSleepingInChests;
    private boolean livesWithSproots;

    public void setInventedSleepingInChests(boolean invented) {
        this.inventedSleepingInChests = invented;
    }

    public boolean isInventedSleepingInChests() {
        return this.inventedSleepingInChests;
    }

    public void setLivesWithSproots(boolean lives) {
        this.livesWithSproots = lives;
    }

    public boolean isLivesWithSproots() {
        return this.livesWithSproots;
    }

    {
        inventedSleepingInChests = false;
        livesWithSproots = false;
    }

    public Julio() {
        super("Жулио");
        System.out.println("Приветствуйте Жулио!");
    }

    public Julio(String name) {
        super(name);
        System.out.println(this.getName() + " в роли Жулио!");
    }

    public Julio(String name, boolean invented) {
        super(name);
        System.out.println(this.getName() + " в роли Жулио! Он, кстати, уже придумал спать в сундуках.");
        this.setInventedSleepingInChests(invented);
    }

    @Override
    public void think() {
        if (!this.isInventedSleepingInChests()) {
            System.out.println(this.getName() + " думает.");
            if (Math.random() >= 0.5) {
                System.out.println(this.getName() + " придумал спать в сундуках!");
                this.setInventedSleepingInChests(true);
            } else {
                System.out.println(this.getName() + " пока ничего не придуал.");
            }
        } else {
            System.out.println(this.getName() + " доволен собой, ведь он уже придумал спать в сундуках.");
        }
    }

    @Override
    public void clean() {
        System.out.println(this.getName() + " позаботился о чистоте.");
    }

    @Override
    public void breathe() {
        System.out.println("План, который придумал " + this.getName() +
                ", работал, от собственного дыхания холода почти не чувствовалось. " +
                "От гордости " + this.getName() + " чувствовал себя ещё теплее.");
        setTemperature(feeling.WARM);
    }

}
