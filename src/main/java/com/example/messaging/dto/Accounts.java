package com.example.messaging.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AccountID;
    private String Name;
    private String Email;
    private String UserType;
    private String Department;
    private String Promotion;
    private Date UniversityEntry;
    private Long PublicationsTotal;
    private String PublicationsAtUni;
    private String AcademicEmployment;

    protected Accounts() {};

    public Accounts(Long accountID, String name, String email, String userType, String department, String promotion, Date universityEntry, Long publicationsTotal, String publicationsAtUni, String academicEmployment) {
        AccountID = accountID;
        Name = name;
        Email = email;
        UserType = userType;
        Department = department;
        Promotion = promotion;
        UniversityEntry = universityEntry;
        PublicationsTotal = publicationsTotal;
        PublicationsAtUni = publicationsAtUni;
        AcademicEmployment = academicEmployment;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "AccountID=" + AccountID +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", UserType='" + UserType + '\'' +
                ", Department='" + Department + '\'' +
                ", Promotion='" + Promotion + '\'' +
                ", UniversityEntry=" + UniversityEntry +
                ", PublicationsTotal=" + PublicationsTotal +
                ", PublicationsAtUni='" + PublicationsAtUni + '\'' +
                ", AcademicEmployment='" + AcademicEmployment + '\'' +
                '}';
    }

    public Long getAccountID() {
        return AccountID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getUserType() {
        return UserType;
    }

    public String getDepartment() {
        return Department;
    }

    public String getPromotion() {
        return Promotion;
    }

    public Date getUniversityEntry() {
        return UniversityEntry;
    }

    public Long getPublicationsTotal() {
        return PublicationsTotal;
    }

    public String getPublicationsAtUni() {
        return PublicationsAtUni;
    }

    public String getAcademicEmployment() {
        return AcademicEmployment;
    }
}
