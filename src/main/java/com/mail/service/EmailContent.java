package com.mail.service;

import com.mail.model.Application;
import org.springframework.stereotype.Component;

@Component
public class EmailContent {

    public String applicationEmailText(Application application) {
        return "new Job Application details from user\n\n" +
                "Name:" + application.getName() + "\n" +
                "Email:" + application.getEmail() + "\n" +
                "Contact:" + application.getContactNumber() + "\n" +
                "Experience:" + application.getExperience() + "\n" +
                "Current CTC:" + application.getCurrentCTC() + "\n" +
                "Expected CTC:" + application.getExpectedCTC() + "\n" +
                "Location:" + application.getLocation() + "\n" +
                "Country:" + application.getCountryName() + "(" + application.getCountryCode() + ")\n" +
                "Notes:" + application.getNotes();
    }
}