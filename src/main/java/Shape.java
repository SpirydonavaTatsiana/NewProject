interface Shape {
    double calculatePerimeter();
    double calculateArea();
    String getFillColor();
    void setFillColor(String color);
    String getBorderColor();
    void setBorderColor(String color);
    default void printCharacteristics() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}