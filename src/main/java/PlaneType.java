public enum PlaneType {
    BOEING747(149, 8940),
    BOEING767(248, 17360),
    BOEING777(317, 22190);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }
}
