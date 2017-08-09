package com.ednTISolutions.controleHoras.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by edneyroldao on 20/05/17.
 */
@Component
@PropertySource("classpath:mail.properties")
public class MailService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private Environment env;

    @Autowired
    private MailSender mailSender;

    public boolean sendEmailToUser(String userMail, String subject, String content) {
        SimpleMailMessage messageObj = new SimpleMailMessage();

        messageObj.setFrom(env.getProperty("username"));
        messageObj.setTo(userMail);
        messageObj.setSubject(subject);
        messageObj.setText(content);
        
        System.out.println("Sending e-mail...");

        try {
            mailSender.send(messageObj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("the e-mail has been sent successfully !");
        return true;
    }


}
