public class CatTask {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Котя");
        FoodBowl bowl = new FoodBowl(20);
        cat1.eat(10, bowl);
        cat2.eat(15, bowl);
        System.out.println(cat1.name + " сыт: " + cat1.isFull());
        System.out.println(cat2.name + " сыт: " + cat2.isFull());
        System.out.println("Общее количество животных: " + Animal.getTotalAnimals());
        System.out.println("Общее количество собак: " + Dog.getTotalDogs());
        System.out.println("Общее количество котов: " + Cat.getTotalCats());
    }
}