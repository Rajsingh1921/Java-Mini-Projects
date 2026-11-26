package Adapter;

// Existing class with a different method name and parameters (Adaptee)
public class SmsService {
    public void sendSms(String mobileNumber, String text) {
        System.out.println("SMS sent to " + mobileNumber + " : " + text);
    }
}
