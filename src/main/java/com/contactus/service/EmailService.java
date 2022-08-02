package com.contactus.service;

import com.contactus.model.MailDataToSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    private final SpringTemplateEngine springTemplateEngine;

    public EmailService(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    public void sendEmail(String toEmail, String firstName){

         String bodyofMail = "Hi " + firstName + "\n\n" +  "Welcome to Cykle, we got your mail";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("info@cykle.studio");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("We got your mail!");
        simpleMailMessage.setText(bodyofMail);
        javaMailSender.send(simpleMailMessage);

    }


    public void sendEmailToAdmin(String toEmail, MailDataToSend mailDataToSend){

        String bodyofMail = "Hi Cykle Admin, there is a new request from your website and details are listed below \n\n" +


        "Product Name : " + mailDataToSend.getProductName() + "\n\n" +
                "First Name : " + mailDataToSend.getFirstName() + "\n\n" +
                "Last Name : " + mailDataToSend.getLastName() + "\n\n" +
                "Email Address : " + mailDataToSend.getEmail() + "\n\n" +
                "Phone Number : " + mailDataToSend.getPhoneNo() + "\n\n" +
                "Address : " + mailDataToSend.getAddress() + "\n\n" +
                "Project Type  : " + mailDataToSend.getProductType() + "\n\n" +
                "Service Type : " + mailDataToSend.getServiceType()+ "\n\n";



        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("info@cykle.studio");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Another Project don land, Bill am");
        simpleMailMessage.setText(bodyofMail);
        javaMailSender.send(simpleMailMessage);

    }


    public void sendHtmlMessage(String toEmail, MailDataToSend email) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();

        helper.setFrom("info@cykle.studio","Cykle Studio");
        helper.setTo(toEmail);
        helper.setSubject("Thank you for reaching out!");
        String html = springTemplateEngine.process("template.html", context);
        helper.setText(html, true);


        javaMailSender.send(message);
    }
}
