package com.example.hadhospitalservice.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PatientHealthRecord {
    public PatientHealthRecord(String abhaId, String recordType, Date timestamp, String hospitalName, String description) {
        this.abhaId = abhaId;
        this.recordType = recordType;
        this.timestamp=timestamp;
        this.hospitalName=hospitalName;
        this.description=description;
    }
    public PatientHealthRecord(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String abhaId;

    @Column(nullable = false)
    String recordType;

    @Column(nullable = false)
    Date timestamp;

    @Column(nullable = false)
    String hospitalName;
    
    @Column(nullable = false)
    String description;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getAbhaId() {
        return abhaId;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }


}
