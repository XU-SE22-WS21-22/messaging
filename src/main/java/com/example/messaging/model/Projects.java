package com.example.messaging.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ProjectID;
    @Id
    private Long PartnerID;
    String ProjectName;
    Short InPlanning;
    Date DateStart;
    Date DateEnd;
    Date DateSubmission;
    Date DateDecision;
    String Department;
    String ThirdPartySupport;
    Short Funding;
    String ResposibleForFunding;
    String Editor;

    protected Projects() {}

    public Long getProjectID() {
        return ProjectID;
    }

    public Long getPartnerID() {
        return PartnerID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public Short getInPlanning() {
        return InPlanning;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public Date getDateSubmission() {
        return DateSubmission;
    }

    public Date getDateDecision() {
        return DateDecision;
    }

    public String getDepartment() {
        return Department;
    }

    public String getThirdPartySupport() {
        return ThirdPartySupport;
    }

    public Short getFunding() {
        return Funding;
    }

    public String getResposibleForFunding() {
        return ResposibleForFunding;
    }

    public String getEditor() {
        return Editor;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "ProjectID=" + ProjectID +
                ", PartnerID=" + PartnerID +
                ", ProjectName='" + ProjectName + '\'' +
                ", InPlanning=" + InPlanning +
                ", DateStart=" + DateStart +
                ", DateEnd=" + DateEnd +
                ", DateSubmission=" + DateSubmission +
                ", DateDecision=" + DateDecision +
                ", Department='" + Department + '\'' +
                ", ThirdPartySupport='" + ThirdPartySupport + '\'' +
                ", Funding=" + Funding +
                ", ResposibleForFunding='" + ResposibleForFunding + '\'' +
                ", Editor='" + Editor + '\'' +
                '}';
    }

    public Projects(Long projectID, Long partnerID, String projectName, Short inPlanning, Date dateStart, Date dateEnd, Date dateSubmission, Date dateDecision, String department, String thirdPartySupport, Short funding, String resposibleForFunding, String editor) {
        ProjectID = projectID;
        PartnerID = partnerID;
        ProjectName = projectName;
        InPlanning = inPlanning;
        DateStart = dateStart;
        DateEnd = dateEnd;
        DateSubmission = dateSubmission;
        DateDecision = dateDecision;
        Department = department;
        ThirdPartySupport = thirdPartySupport;
        Funding = funding;
        ResposibleForFunding = resposibleForFunding;
        Editor = editor;
    }
}
