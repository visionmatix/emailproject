package com.mail.service;

import com.mail.model.Application;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {

    @Autowired
    private JavaMailSender mailSender;

    // ✅ Method to send application details + resume
    public void sendApplicationEmail(Application application) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("ganvirtine@gmail.com"); // Change to your HR email
        helper.setSubject("New Job Application");

        String body = "Name: " + application.getName() + "\n"
                + "Contact: " + application.getContactNumber() + "\n"
                + "Email: " + application.getEmail() + "\n"
                + "Experience: " + application.getExperience() + "\n"
                + "Current CTC: " + application.getCurrentCTC() + "\n"
                + "Expected CTC: " + application.getExpectedCTC() + "\n"
                + "Location: " + application.getLocation() + "\n"
                + "Country: " + application.getCountryName() + " (" + application.getCountryCode() + ")\n"
                + "Notes: " + application.getNotes();

        helper.setText(body);

        // Attach resume if available
        if (application.getResume() != null && application.getResume().length > 0) {
            helper.addAttachment(
                    application.getResumeFileName(),
                    new ByteArrayResource(application.getResume()),
                    application.getResumeContentType()
            );
        }
        mailSender.send(message);
    }
}