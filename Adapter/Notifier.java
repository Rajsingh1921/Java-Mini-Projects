package Adapter;

// Target interface - the one our app wants to use
public interface Notifier {
    void send(String message);
}
