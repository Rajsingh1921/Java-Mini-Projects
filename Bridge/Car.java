package Bridge;

public class Car extends Vehicle {
    public Car(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Car is running on 4 wheels");
        engine.stop();
    }
}
