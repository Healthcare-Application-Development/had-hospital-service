package com.example.hadhospitalservice.bean;

import jakarta.persistence.*;

@Entity
public class PatientHealthRecord {
    public PatientHealthRecord(Integer healthRecordID, String abhaID, String recordCategory) {
        this.healthRecordID = healthRecordID;
        this.abhaID = abhaID;
        this.recordCategory = recordCategory;
    }

    public PatientHealthRecord(){}

    public String getAbhaID() {
        return abhaID;
    }

    public void setAbhaID(String abhaID) {
        this.abhaID = abhaID;
    }

    public String getRecordCategory() {
        return recordCategory;
    }

    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory;
    }

    public Integer getHealthRecordID() {
        return healthRecordID;
    }

    public void setHealthRecordID(Integer healthRecordID) {
        this.healthRecordID = healthRecordID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer healthRecordID;
    @Column(nullable = false)
    private String abhaID;
    @Column(nullable = false)
    private String recordCategory;
}
