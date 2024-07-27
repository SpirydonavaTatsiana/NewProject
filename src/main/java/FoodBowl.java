class FoodBowl {
    private int foodAmount;

    public FoodBowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        if (amount > foodAmount) {
            amount = foodAmount;
        }
        foodAmount -= amount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }
}