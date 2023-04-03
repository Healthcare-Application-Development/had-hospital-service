package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientHealthRecord {
    public PatientHealthRecord(Integer abhaID, String recordCategory) {
        this.abhaID = abhaID;
        this.recordCategory = recordCategory;
    }

    public PatientHealthRecord(){}

    public Integer getAbhaID() {
        return abhaID;
    }

    public void setAbhaID(Integer abhaID) {
        this.abhaID = abhaID;
    }

    public String getRecordCategory() {
        return recordCategory;
    }

    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory;
    }

    @Id
    @Column(nullable = false)
    private Integer abhaID;
    @Column(nullable = false, unique = true)
    String recordCategory;
}
