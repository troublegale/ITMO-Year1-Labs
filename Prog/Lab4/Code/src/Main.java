import furniture.*;
import persons.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать!");
        Object[] stuff = Scene.beginOption();

        Julio julio = (Julio) stuff[0];
        Sproots sproots = (Sproots) stuff[1];
        Chests chests = (Chests) stuff[2];
        Beds beds = (Beds) stuff[3];
        Furnace furnace = (Furnace) stuff[4];
        TV tv = (TV) stuff[5];

        Scene.live(julio, sproots, chests, beds, furnace, tv);

    }

}
