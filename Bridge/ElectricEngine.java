package Bridge;

public class ElectricEngine implements Engine {
    public void start() {
        System.out.println("Electric motor switched ON (no sound)");
    }

    public void stop() {
        System.out.println("Electric motor switched OFF");
    }
}
