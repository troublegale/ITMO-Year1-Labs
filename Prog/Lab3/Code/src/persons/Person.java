package persons;

import enums.feeling;

import java.util.Objects;

public abstract class Person {

    private String name;
    private static feeling temperature = feeling.WARM;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static void setTemperature(feeling feeling) {
        temperature = feeling;
    }

    public static feeling getTemperature() {
        return temperature;
    }

    public Person(String name) {
        this.setName(name);
    }

    public abstract void breathe();

    public static void tellTemperature() {
        if (Person.getTemperature().equals(feeling.COLD)) {
            System.out.println("Ночью всем было зябко.");
        } else {
            System.out.println("Ночью всем было хорошо и тепло.");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Person otherPerson = (Person) obj;
        return Objects.equals(this.name, otherPerson.name);
    }

    @Override
    public String toString() {
        if (this instanceof Others) {
            return this.getName() + " передают привет";
        } else {
            return this.getName() + " передаёт привет";
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
