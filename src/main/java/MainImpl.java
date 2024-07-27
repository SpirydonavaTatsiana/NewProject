public class MainImpl {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");
        System.out.println("Характеристики круга:");
        circle.printCharacteristics();
        System.out.println("\nХарактеристики прямоугольника:");
        rectangle.printCharacteristics();
        System.out.println("\nХарактеристики треугольника:");
        triangle.printCharacteristics();
    }
}