package Bridge;

public class Main {
    public static void main(String[] args) {
        Vehicle petrolCar = new Car(new PetrolEngine());
        Vehicle electricCar = new Car(new ElectricEngine());
        Vehicle petrolBike = new Bike(new PetrolEngine());
        Vehicle electricBike = new Bike(new ElectricEngine());

        System.out.println("--- Petrol Car ---");
        petrolCar.drive();

        System.out.println("\n--- Electric Car ---");
        electricCar.drive();

        System.out.println("\n--- Petrol Bike ---");
        petrolBike.drive();

        System.out.println("\n--- Electric Bike ---");
        electricBike.drive();
    }
}
