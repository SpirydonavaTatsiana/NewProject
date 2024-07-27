import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transferFruitsTo(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
        System.out.println("Apple box 1 weight: " + appleBox1.getWeight());
        System.out.println("Orange box weight: " + orangeBox.getWeight());
        System.out.println("Comparing apple box 1 with orange box: " + appleBox1.compare(orangeBox));
        appleBox1.transferFruitsTo(appleBox2);
        System.out.println("Apple box 1 weight after transfer: " + appleBox1.getWeight());
        System.out.println("Apple  box 2 weight after transfer: " + appleBox2.getWeight());
    }
}