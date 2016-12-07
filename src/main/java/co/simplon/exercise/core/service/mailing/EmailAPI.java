package co.simplon.exercise.core.service.mailing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("Email")
public class EmailAPI {
    @Autowired
    private MailSender mail; // MailSender interface defines a strategy
    // for sending simple mails

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(fromAddress);
        msg.setTo(toAddress);
        msg.setSubject(subject);
        msg.setText(msgBody);
        mail.send(msg);
    }
}
