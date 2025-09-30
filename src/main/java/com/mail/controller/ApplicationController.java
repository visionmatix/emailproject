package com.mail.controller;

import com.mail.model.Application;
import com.mail.repository.ApplicationRepository;
import com.mail.service.ApplicationService;
import com.mail.service.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {


    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private EmailServices emailServices;

    @Autowired
    private ApplicationRepository applicationRepository;


    //http:localhost:8080/api/applications/apply
    @PostMapping("/apply")
    public ResponseEntity<String> saveApplication(
            @RequestParam String name,
            @RequestParam String contactNumber,
            @RequestParam String email,
            @RequestParam String experience,
            @RequestParam String currentCTC,
            @RequestParam String expectedCTC,
            @RequestParam String location,
            @RequestParam (required = false) String countryName,
            @RequestParam (required = false)String countryCode,
            @RequestParam (required = false) String notes,

            @RequestParam("resume") MultipartFile resumeFile) {
        try {
            Application application = new Application();
            application.setName(name);
            application.setContactNumber(contactNumber);
            application.setEmail(email);
            application.setExperience(experience);
            application.setCurrentCTC(currentCTC);
            application.setExpectedCTC(expectedCTC);
            application.setLocation(location);
            application.setCountryName(countryName);
            application.setCountryCode(countryCode);
            application.setNotes(notes);

            if (resumeFile!=null && ! resumeFile.isEmpty()) {
                application.setResumeFileName(resumeFile.getOriginalFilename());
                application.setResumeContentType(resumeFile.getContentType());
                application.setResume(resumeFile.getBytes());
            }
            applicationService.saveApplication(application);



          emailServices.sendApplicationEmail(application);

            return ResponseEntity.ok("Application submitted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while submitting application: " + e.getMessage());
        }
    }

}
