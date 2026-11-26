package Adapter;

public class SmsAdapter implements Notifier {
    private final SmsService smsService;
    private final String mobileNumber;

    public SmsAdapter(SmsService smsService, String mobileNumber) {
        this.smsService = smsService;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void send(String message) {
        smsService.sendSms(mobileNumber, message);
    }
}
