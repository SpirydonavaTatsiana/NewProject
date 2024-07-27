class Cat extends Animal {
    private static int totalCats = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        totalCats++;
        this.isFull = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(int foodAmount, FoodBowl bowl) {
        if (foodAmount <= bowl.getFoodAmount()) {
            bowl.decreaseFood(foodAmount);
            this.isFull = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не хватает еды в миске.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getTotalCats() {
        return totalCats;
    }
}