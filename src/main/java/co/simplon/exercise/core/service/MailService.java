package co.simplon.exercise.core.service;

import co.simplon.exercise.core.model.Mail;
import co.simplon.exercise.core.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService extends GenericService <Mail, MailRepository> {

    @Autowired
    public MailRepository mailRepository;

    public boolean isTreated(Integer id) {
        Mail mail = mailRepository.findMailById(id);
        if (mail.getTreated().equals(0)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserNameByMailId(Integer id) {
        Mail mail = mailRepository.findMailById(id);
        return mail.getFromAddress();
    }
}


