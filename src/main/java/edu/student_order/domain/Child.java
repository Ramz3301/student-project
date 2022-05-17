package edu.student_order.domain;

import java.time.LocalDate;

public class Child extends Person {
    private String certificateNumber;
    private LocalDate issueDate;
    private String issueDepartment;

    public Child(String surname, String firstName, String patronymic, LocalDate dateOfBirth) {
        super(surname, firstName, patronymic, dateOfBirth);
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
