package com.mail.controller;

import com.mail.model.Contact;
import com.mail.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {


    @Autowired
    private ContactService contactService;

    // API: POST -> http://localhost:8080/api/contact/send
    @PostMapping("/send")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveAndNotify(contact);
    }

}
