package com.example.hadhospitalservice.bean;

import java.util.Date;

public class RequestPatientHealthRecord {


    public RequestPatientHealthRecord(String abhaId, String recordType, String consentId, String artifactId) {
        this.abhaId = abhaId;
        this.recordType = recordType;
        this.consentId = consentId;
        this.artifactId = artifactId;
    }

    private String abhaId;
    private String recordType;
    private String consentId;
    private String artifactId;

    public String getAbhaId() {
        return abhaId;
    }

    public void setAbhaId(String abhaId) {
        this.abhaId = abhaId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
}
