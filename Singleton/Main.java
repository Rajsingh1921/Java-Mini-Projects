package Singleton;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Student logged in");

        Logger logger2 = Logger.getInstance();
        logger2.log("Attendance marked");

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("Total logs written : " + logger2.getLogCount());
    }
}
