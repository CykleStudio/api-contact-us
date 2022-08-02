package com.contactus.controller;


import com.contactus.model.MailDataToSend;
import com.contactus.model.ResponseData;
import com.contactus.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
public class SendMailApi {

    @Autowired
    EmailService emailService;

    @CrossOrigin
    @PostMapping("/sendmail")
    private ResponseEntity<ResponseData> sendMailToUser(@RequestBody MailDataToSend mailDataToSend) {
        try {
            emailService.sendHtmlMessage(mailDataToSend.getEmail(), mailDataToSend);
            emailService.sendEmailToAdmin("cykle.products@gmail.com", mailDataToSend);
        } catch (NullPointerException exception) {
            exception.getMessage();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ResponseData responseData = new ResponseData("success", "Email sent successfuly");
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }


    @CrossOrigin
    @GetMapping("/")
    private String welcome(){
        return "Welcome to cykle";
    }
}
