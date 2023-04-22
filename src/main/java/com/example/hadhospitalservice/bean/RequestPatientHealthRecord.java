package com.example.hadhospitalservice.bean;

import java.util.Date;

public class RequestPatientHealthRecord {


    public RequestPatientHealthRecord(Integer abhaId, String recordType, Integer consentId, Integer artifactId) {
        this.abhaId = abhaId;
        this.recordType = recordType;
        this.consentId = consentId;
        this.artifactId = artifactId;
    }

    private Integer abhaId;
    private String recordType;
    private Integer consentId;
    private Integer artifactId;

    public Integer getAbhaId() {
        return abhaId;
    }

    public void setAbhaId(Integer abhaId) {
        this.abhaId = abhaId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Integer getConsentId() {
        return consentId;
    }

    public void setConsentId(Integer consentId) {
        this.consentId = consentId;
    }

    public Integer getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(Integer artifactId) {
        this.artifactId = artifactId;
    }
}
