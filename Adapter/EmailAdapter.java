package Adapter;

public class EmailAdapter implements Notifier {
    private final EmailService emailService;
    private final String emailId;

    public EmailAdapter(EmailService emailService, String emailId) {
        this.emailService = emailService;
        this.emailId = emailId;
    }

    @Override
    public void send(String message) {
        emailService.sendEmail(emailId, "College Notice", message);
    }
}
