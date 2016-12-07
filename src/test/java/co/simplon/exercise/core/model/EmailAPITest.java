package co.simplon.exercise.core.model;

import co.simplon.exercise.core.service.mailing.EmailAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by millet on 06/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//Update your configuration file with the right path
@ContextConfiguration(locations = {"/spring-email-config.xml","/spring-config.xml","/spring-security-config.xml"})
@WebAppConfiguration
public class EmailAPITest {

    @Autowired
    private EmailAPI emailAPI;

    @Test
    public void SendEmail() throws Exception {

        String toAddr = "simplon.company@gmail.com";
        String fromAddr = "millet.elina@gmail.com";

        // email subject
        String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";

        // email body
        String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
        emailAPI.sendEmail(toAddr, fromAddr, subject, body);
    }

}