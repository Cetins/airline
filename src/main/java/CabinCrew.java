public class CabinCrew extends Crew{

    public CabinCrew(String name, Rank rank) {
        super(name, rank);
    }

    public String relayMessage() {
        return "Welcome on board";
    }
}
