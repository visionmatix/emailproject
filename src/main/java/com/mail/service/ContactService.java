package com.mail.service;


import com.mail.model.Contact;
import com.mail.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EmailServiceContact emailServiceContact;

    public Contact saveAndNotify(Contact contact) {
        // Save into DB
        Contact saved = contactRepository.save(contact);

        // Prepare Email Content
        String subject = "New Contact Form Submission";
        String body = "📩 New Contact Details:\n\n"
                + "Name: " + contact.getName() + "\n"
                + "Email: " + contact.getEmail() + "\n"
                + "Phone: " + contact.getPhoneNo() + "\n"
                + "Service Interested: " + contact.getServiceInterested() + "\n"
                + "Message: " + contact.getMessage();

        // Send email to company inbox
        emailServiceContact.sendmail("ganvirtine@gmail.com",subject,body);

        return saved;
    }
}
