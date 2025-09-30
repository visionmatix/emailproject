package com.mail.model;

import jakarta.persistence.*;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;
    private String email;
    private String experience;

    @Column(name = "currentctc")
    private String currentCTC;

    @Column(name = "expectedctc")
    private String expectedCTC;

    private String location;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(length = 2000)
    private String notes;

    @Column(name = "resume_file_name")
    private String resumeFileName;          //this are used for the file name of resume

    @Column(name = "resume_content_type")
    private String resumeContentType;       //it will store the formate of the file 

    @Lob
    private byte[] resume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCurrentCTC() {
        return currentCTC;
    }

    public void setCurrentCTC(String currentCTC) {
        this.currentCTC = currentCTC;
    }

    public String getExpectedCTC() {
        return expectedCTC;
    }

    public void setExpectedCTC(String expectedCTC) {
        this.expectedCTC = expectedCTC;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getResumeContentType() {
        return resumeContentType;
    }

    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }
}