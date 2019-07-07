package com.reactLogin.login.payload;

import javax.validation.constraints.NotBlank;

public class EducationRequest {


    @NotBlank(message = "school cannot be blank")
    private String school;
    private String degree;
    private String fieldofstudy;
    @NotBlank(message = "from cannot be blank")
    private String from;
    private String to;
    private Boolean currentEdu;
    private String description;





    public Boolean getCurrentEdu() {
        return currentEdu;
    }

    public void setCurrentEdu(Boolean currentEdu) {
        this.currentEdu = currentEdu;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFieldofstudy() {
        return fieldofstudy;
    }

    public void setFieldofstudy(String fieldofstudy) {
        this.fieldofstudy = fieldofstudy;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
