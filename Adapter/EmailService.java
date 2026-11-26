package Adapter;

// Another existing class (Adaptee) - needs 3 values instead of 1
public class EmailService {
    public void sendEmail(String toAddress, String subject, String body) {
        System.out.println("Email sent to " + toAddress);
        System.out.println("   Subject : " + subject);
        System.out.println("   Body    : " + body);
    }
}
