package Adapter;

public class Main {
    public static void main(String[] args) {
        Notifier sms = new SmsAdapter(new SmsService(), "9876543210");
        Notifier email = new EmailAdapter(new EmailService(), "student@college.edu");

        // Main only knows Notifier, it does not care how the message is sent
        Notifier[] notifiers = { sms, email };
        for (Notifier notifier : notifiers) {
            notifier.send("Java mini project submission is on Monday");
        }
    }
}
