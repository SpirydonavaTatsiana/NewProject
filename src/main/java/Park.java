public class Park {
    public class Attraction {
        private String name;
        private String workingHours;
        private double price;
        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public void printInfo() {
            System.out.println("Название аттракциона: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction attraction1 = park.new Attraction("Американские горки", "10:00 - 18:00", 500);
        Park.Attraction attraction2 = park.new Attraction("Колесо обозрения", "09:00 - 20:00", 300);
        Park.Attraction attraction3 = park.new Attraction("Комната страха", "12:00 - 22:00", 400);
        attraction1.printInfo();
        attraction2.printInfo();
        attraction3.printInfo();
    }
}