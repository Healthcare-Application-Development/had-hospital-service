package com.example.hadhospitalservice.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PatientHealthRecord {
    public PatientHealthRecord(Integer abhaId, String recordType, Date timestamp, String hospitalName) {
        this.abhaId = abhaId;
        this.recordType = recordType;
        this.timestamp=timestamp;
        this.hospitalName=hospitalName;
    }
    public PatientHealthRecord(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer abhaId;

    @Column(nullable = false)
    String recordType;

    @Column(nullable = false)
    Date timestamp;

    @Column(nullable = false)
    String hospitalName;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }


}
