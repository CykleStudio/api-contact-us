package com.contactus.controller;


import com.contactus.model.MailDataToSend;
import com.contactus.model.ResponseData;
import com.contactus.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class SendMailApi {

    @Autowired
    EmailService emailService;

    @PostMapping("/sendmail")
    private ResponseEntity<ResponseData> sendMailToUser(@RequestBody MailDataToSend mailDataToSend) {
        try {
            emailService.sendHtmlMessage(mailDataToSend.getEmail(), mailDataToSend);
            emailService.sendEmailToAdmin("cykle.products@gmail.com", mailDataToSend);
        } catch (NullPointerException exception) {
            exception.getMessage();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        ResponseData responseData = new ResponseData("success", "Email sent successfuly");
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
