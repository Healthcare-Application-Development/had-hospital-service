package com.example.hadhospitalservice.bean;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class PatientHealthRecordDetails {
    public PatientHealthRecordDetails(String abhaId,String artifactId,String consentId, String listOfRecordType, Date requestTimestamp, String hospitalName) {
        this.abhaId = abhaId;
        this.artifactId=artifactId;
        this.consentId=consentId;
        this.listOfRecordType = listOfRecordType;
        this.requestTimestamp=requestTimestamp;
        this.hospitalName=hospitalName;

    }
    public PatientHealthRecordDetails(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String abhaId;
    @Column(nullable = false)
    private String artifactId;

    @Column(nullable = false)
    private String consentId;

    @Column(nullable = false)
    String listOfRecordType;

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    @Column(nullable = false)
    Date requestTimestamp;

    @Column(nullable = false)
    String hospitalName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListOfRecordType() {
        return listOfRecordType;
    }

    public void setListOfRecordType(String listOfRecordType) {
        this.listOfRecordType = listOfRecordType;
    }

    public String getAbhaId() {
        return abhaId;
    }

    public void setAbhaId(String abhaId) {
        this.abhaId = abhaId;
    }



    public Date getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(Date requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
