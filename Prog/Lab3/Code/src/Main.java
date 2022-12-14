import persons.Julio;
import persons.Others;
import furniture.Beds;
import furniture.Chests;
import furniture.Furnace;

public class Main {
    public static void main(String[] args) {

        Julio julio = new Julio("Жулио", false);
        Others others = new Others("Остальные");
        Chests chests = new Chests("большие");
        Beds beds = new Beds("удобные");
        Furnace furnace = new Furnace("старая");

        TimeTo.live(julio, others, chests, beds, furnace, 2);
    }

}