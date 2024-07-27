class Animal {
    private static int totalAnimals = 0;
    protected String name;
    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
    public static int getTotalAnimals() {
        return totalAnimals;
    }
}
