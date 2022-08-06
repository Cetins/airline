public abstract class Crew  {
    private String name;
    private Rank rank;

    public Crew(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }
}
