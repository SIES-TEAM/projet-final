package co.simplon.exercise.core.model;

import co.simplon.exercise.core.service.mailing.EmailAPI;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//Update your configuration file with the right path
@ContextConfiguration(locations = {"/spring-email-config.xml","/spring-config.xml","/spring-security-config.xml"})
@WebAppConfiguration
public class EmailAPITest {

    @Autowired
    private EmailAPI emailAPI;

    @Test
    public void SendEmail() throws Exception {

        String prenom = "Prenom recu par ???";

        String toAddr = "simplon.company@gmail.com";
        String fromAddr = "millet.elina@gmail.com";

        // email subject
        String subject = "Hey.. This email sent by SIE team";

        // email body
        String body = "Bonjour " + prenom + ", Heureux d'avoir votre message";
        emailAPI.sendEmail(toAddr, fromAddr, subject, body);
    }

}