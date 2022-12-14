package furniture;

import persons.Others;
import persons.Person;

import java.util.Objects;

public abstract class Furniture {

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public Furniture(String type) {
        this.setType(type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Furniture otherFurniture = (Furniture) obj;
        return Objects.equals(this.type, otherFurniture.type);
    }

    @Override
    public String toString() {
        return "\"" + this.type + "\" - всё, что известно об этом предмете мебели";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

}
