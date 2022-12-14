package persons;

import enums.feeling;

public class Julio extends Person implements Cooking, Cleaning, Thinking {

    private boolean inventedSleepingInChests;

    public void setInventedSleepingInChests(boolean invented) {
        this.inventedSleepingInChests = invented;
    }

    public boolean isInventedSleepingInChests() {
        return this.inventedSleepingInChests;
    }

    public Julio(String name, boolean invented) {
        super(name);
        System.out.println(this.getName() + " в роли Жулио!");
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
    public void cook() {
        System.out.println(this.getName() + " позаботился о пище.");
    }

    @Override
    public void clean() {
        System.out.println(this.getName() + " позаботился о чистоте.");
    }

    @Override
    public void breathe() {
        System.out.println("План Жулио сработал, от собственного дыхания холода почти не чувствовалось. " +
                "От гордости Жулио стало ещё теплее.");
        this.setTemperature(feeling.WARM);
    }

}
