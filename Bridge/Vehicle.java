package Bridge;

// Abstraction - the "what it is" side of the bridge
public abstract class Vehicle {
    protected Engine engine; // this reference is the bridge

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}
