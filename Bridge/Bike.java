package Bridge;

public class Bike extends Vehicle {
    public Bike(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Bike is running on 2 wheels");
        engine.stop();
    }
}
